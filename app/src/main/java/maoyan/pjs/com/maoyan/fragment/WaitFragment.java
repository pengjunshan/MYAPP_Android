package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.WaitFragmentAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.bean.USListBean;
import maoyan.pjs.com.maoyan.bean.WaitExpctBean;
import maoyan.pjs.com.maoyan.bean.WaitListBean;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.YRecycleview;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 待映
 */
public class WaitFragment extends BaseFragment {


    public static YRecycleview wait_recyclerView;

    public static WaitFragmentAdapter adapter;

    private static StickyRecyclerHeadersDecoration headersDecor;

    //预告片
    public static  List<USListBean.DataBean.ComingBean> recomData= new ArrayList<>();

    //近期最受期待
    public static List<WaitExpctBean.DataBean.MoviesBean> moviesData=new ArrayList<>();

    //下部分
    public static List<WaitListBean.DataBean.ComingBean> comingData=new ArrayList<>();

    public Button againloading;
    public static LinearLayout ll_again;

    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    init();
                  /*
                    adapter.setListData(comingData);
                    adapter.notifyItemRangeChanged(4,comingData.size());*/
                    break;

                case 1:
                    wait_recyclerView.setReFreshComplete();
                    Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    wait_recyclerView.setloadMoreComplete();
                    wait_recyclerView.setNoMoreData(true);
                    Toast.makeText(context, "没有更多数据了...", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public WaitFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.movie_wait,null);
//        View view= LayoutInflater.from(context).inflate(R.layout.movie_wait,null);
        wait_recyclerView = (YRecycleview) view.findViewById(R.id.wait_recyclerView);

        ll_again = (LinearLayout) view.findViewById(R.id.ll_again);
        againloading = (Button) view.findViewById(R.id.againloading);

        againloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //请求待映预告片
                HttpUtils.getWaitRecommend(Constant.WaitRecommend,context);
                Tools.showRoundProcessDialog(context);
            }
        });

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //请求待映预告片
        HttpUtils.getWaitRecommend(Constant.WaitRecommend,context);
        Tools.showRoundProcessDialog(context);


        wait_recyclerView.setRefreshAndLoadMoreListener(new YRecycleview.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                //请求待映预告片
//                HttpUtils.getWaitRecommend(Constant.WaitRecommend,context);
                handler.sendEmptyMessage(1);
            }

            @Override
            public void onLoadMore() {
                SystemClock.sleep(2000);
                handler.sendEmptyMessage(2);
            }
        });
    }
    private static boolean isOneLoading=false;

    private static void init() {

        //关联适配器
        adapter=new WaitFragmentAdapter(context,recomData,moviesData,comingData);
        //设置adapter
        wait_recyclerView.setAdapter(adapter);
        //设置布局管理器
        wait_recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

        headersDecor = new StickyRecyclerHeadersDecoration(adapter);
        wait_recyclerView.addItemDecoration(headersDecor);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                headersDecor.invalidateHeaders();
            }
        });  //刷新数据的时候回刷新头部


        if(!isOneLoading) {
            wait_recyclerView.addItemDecoration(headersDecor);
            headersDecor.invalidateHeaders();
            isOneLoading=true;
        }

    }
}
