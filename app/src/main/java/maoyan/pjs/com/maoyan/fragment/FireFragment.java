package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

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

    private MaterialRefreshLayout mRefresh;

    private static RecyclerView mRecyclerView;

    public static FireFragmentAdapter adapter;


    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    adapter.setViewPagerData(listVP);
                    adapter.notifyItemRangeChanged(0, 1);
                    break;

                case 1:
                    adapter.setListData(moviesData);
                    adapter.notifyItemRangeChanged(2, moviesData.size());
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
        Log.i("TAG", "FireFragment");

        /**
         * 请求ViewPager数据
         */
        HttpUtils.getFireViewPager(Constant.FireVPUrl);

        /**
         * 请求List集合
         */
        HttpUtils.getFireList(Constant.FireListUrl,context);
        Tools.showRoundProcessDialog(context);

        init();

    }

    private void init() {

        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        adapter = new FireFragmentAdapter(context,handler);
        mRecyclerView.setAdapter(adapter);

        //recyclerview关联适配器
//        mRefresh.setSunStyle(true);

    }


}
