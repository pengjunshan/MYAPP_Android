package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

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

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 热映
 */
public class FireFragment extends BaseFragment {

    public static MaterialRefreshLayout mRefresh;

    private static RecyclerView mRecyclerView;

    public static FireFragmentAdapter adapter;
    //正常状态
    public static final String START_NORMAL="nomal";

    //下拉刷新
    public static final String START_REFRESH="refresh";

    //上拉加载
    public static final String START_MORE="loadmore";

    //当前状态
    public static String start=START_NORMAL;

    private boolean isShowDialog;

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
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
        mRefresh = (MaterialRefreshLayout) view.findViewById(R.id.sp_refresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.sp_recyclerView);
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
        if(!isShowDialog) {
            HttpUtils.getNearbyLocation2(Constant.CinemaLocation);
            isShowDialog=true;
        }
//        mRefresh.setSunStyle(true);
    }

    private void refreshData() {
        start=START_REFRESH;
        HttpUtils.getFireList(Constant.FireListUrl,context);
    }

    private void setRefresh() {
        mRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        refreshData();
                    }
                }.start();

            }

            @Override
            public void onfinish() {
                super.onfinish();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
//                super.onRefreshLoadMore(materialRefreshLayout);
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        SystemClock.sleep(1000);
                        mRefresh.finishRefreshLoadMore();
                        handler.sendEmptyMessage(0);
                    }
                }.start();
            }
        });
    }


    public static void showData() {
        switch (start){
            case START_NORMAL://第一次
                //设置布局管理器
                Log.i("TAG", "刷新数据111**listVP="+listVP.toString()+"刷新数据111**moviesData="+moviesData);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                adapter = new FireFragmentAdapter(context,handler,listVP,moviesData);
                mRecyclerView.setAdapter(adapter);
                break;

            case START_REFRESH://下拉
                //清空数据
                adapter.deleteData();
                //填充新的数据
                Log.i("TAG", "刷新数据222**listVP="+listVP.toString()+"刷新数据222**moviesData="+moviesData);
                adapter.setData(listVP,moviesData);
                //隐藏加载圈
                mRefresh.finishRefresh();
                Toast.makeText(context, "刷新完成", Toast.LENGTH_SHORT).show();
                break;

            case START_MORE://上拉

                break;


        }
    }
}
