package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.FireFragmentAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.bean.FireListBean;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.YRecycleview;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 热映
 */
public class FireFragment extends BaseFragment {

    private static YRecycleview mRecyclerView;

    public static FireFragmentAdapter adapter;
    //正常状态
    public static final String START_NORMAL="nomal";

    //下拉刷新
    public static final String START_REFRESH="refresh";

    //上拉加载
    public static final String START_MORE="loadmore";

    //当前状态
    public static String start=START_NORMAL;

    private static boolean isShowDialog;

    public Button againloading;
    public static LinearLayout ll_again;


    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    mRecyclerView.setloadMoreComplete();
                    mRecyclerView.setNoMoreData(true);
                    Toast.makeText(context,"没有数据了....",Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    showDialog(msg.obj);
                    break;

                case 2:
                   int item = FireFragmentAdapter.HeaderViewHolder.fire_viewpager.getCurrentItem()+1;
                    FireFragmentAdapter.HeaderViewHolder.fire_viewpager.setCurrentItem(item);
                    handler.removeCallbacksAndMessages(null);
                    handler.sendEmptyMessageDelayed(2,3000);
                    break;
            }
        }
    };

    private static void showDialog(final Object obj) {
        AlertDialog dialog=new AlertDialog.Builder(context)
                .setMessage("你目前位置"+obj.toString()+" 是否更改？")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            MovieFragment.tv_address.setText(obj.toString());
                        MovieFragment.setCity(obj);
                    }
                }).show();
        dialog.getWindow().setLayout(Tools.dip2px(context,280), Tools.dip2px(context,160));
    }

    /**
     * 获取热映viewpager的图片
     *
     * @param context
     */
    public static List<Map<String, Object>> listVP = new ArrayList<>();

    /**
     * List下的數據
     *
     * @param context
     */
    public static  List<FireListBean.DataBean.HotBean> moviesData = new ArrayList<>();


    public FireFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.movie_fire, null);
        mRecyclerView = (YRecycleview) view.findViewById(R.id.sp_recyclerView);

        ll_again = (LinearLayout) view.findViewById(R.id.ll_again);
        againloading = (Button) view.findViewById(R.id.againloading);

        againloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        return view;

    }

    @Override
    public void initData() {
        super.initData();
        init();
        setRefresh();
    }



    private void init() {

        /**
         * 请求List集合
         */
        HttpUtils.getFireList(Constant.FireListUrl,context);
        Tools.showRoundProcessDialog(context);
//        mRefresh.setSunStyle(true);
    }

    private void refreshData() {
        start=START_REFRESH;
        init();
    }

    private void setRefresh() {
        mRecyclerView.setRefreshAndLoadMoreListener(new YRecycleview.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }

            @Override
            public void onLoadMore() {
                SystemClock.sleep(1000);
                    handler.sendEmptyMessage(0);
            }

        });
    }


    public static void showData() {
        switch (start){
            case START_NORMAL://第一次
                //设置布局管理器
                mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                adapter = new FireFragmentAdapter(context,handler,listVP,moviesData);
                mRecyclerView.setAdapter(adapter);
                if(!isShowDialog) {
                    HttpUtils.getNearbyLocation2(Constant.CinemaLocation);
                    isShowDialog=true;
                }
                break;

            case START_REFRESH://下拉
                //清空数据
                adapter.deleteData();
                //填充新的数据
                adapter.setData(listVP,moviesData);
                //隐藏加载圈
                mRecyclerView.setReFreshComplete();
                Toast.makeText(context, "刷新完成", Toast.LENGTH_SHORT).show();
                break;

            case START_MORE://上拉

                break;


        }
    }
}
