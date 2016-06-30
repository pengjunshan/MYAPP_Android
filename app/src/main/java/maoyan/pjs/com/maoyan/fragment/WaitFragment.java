package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.WaitFragmentAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.bean.WaitListBean;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 待映
 */
public class WaitFragment extends BaseFragment {

    private MaterialRefreshLayout wait_refresh;

    private RecyclerView wait_recyclerView;

    public static WaitFragmentAdapter adapter;

    public static List<WaitListBean.DataBean.ComingBean> comingData;

    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    adapter.setListData(comingData);
                    adapter.notifyItemRangeChanged(4,comingData.size());
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
        wait_refresh = (MaterialRefreshLayout) view.findViewById(R.id.wait_refresh);
        wait_recyclerView = (RecyclerView) view.findViewById(R.id.wait_recyclerView);

        return view;
    }

    @Override
    public void initData() {
        super.initData();

        //请求待映预告片
        HttpUtils.getWaitRecommend(Constant.WaitRecommend);

        //请求待映最受期待
        HttpUtils.WaitExpct(Constant.WaitExpct);
        /**
         * 请求待映下部分List数据
         */
        HttpUtils.getWaitListData(Constant.WaitListUrl,context);
        Tools.showRoundProcessDialog(context);
        init();
    }

    private void init() {

        //设置布局管理器
        wait_recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

        //关联适配器
        adapter=new WaitFragmentAdapter(context);
        wait_recyclerView.setAdapter(adapter);


    }
}
