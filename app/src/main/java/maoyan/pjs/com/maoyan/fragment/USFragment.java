package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.USAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.view.YRecycleview;

/**
 * Created by pjs984312808 on 2016/6/22.
 */
public class USFragment extends BaseFragment {

    private MaterialRefreshLayout refresh;
    public static YRecycleview recyclerView;

    public static USAdapter adapter;

    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    recyclerView.setReFreshComplete();
                    Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    recyclerView.setloadMoreComplete();
                    recyclerView.setNoMoreData(true);
                    Toast.makeText(context, "没有更多数据了...", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    public USFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view =View.inflate(context, R.layout.us,null);
//        refresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        recyclerView = (YRecycleview) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void initData() {
        Log.i("TAG", "美国热映");
        super.initData();
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setRefreshAndLoadMoreListener(new YRecycleview.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                       handler.sendEmptyMessage(0);
                    }
                }, 2500);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        handler.sendEmptyMessage(1);
                    }
                }, 2500);
            }
        });
    }
}
