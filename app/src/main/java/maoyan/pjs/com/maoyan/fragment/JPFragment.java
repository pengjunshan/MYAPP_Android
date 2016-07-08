package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.JPAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.view.YRecycleview;

/**
 * Created by pjs984312808 on 2016/6/22.
 */
public class JPFragment extends BaseFragment {

    public static YRecycleview recyclerView;
    public static JPAdapter adapter;

    public static LinearLayout ll_again;
    public static Button againloading;

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
    public JPFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view = View.inflate(context, R.layout.jp, null);
        recyclerView = (YRecycleview) view.findViewById(R.id.recyclerView);

        ll_again = (LinearLayout) view.findViewById(R.id.ll_again);
        againloading = (Button) view.findViewById(R.id.againloading);

        againloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.getUSData(Constant.USUrl,context);
            }
        });
        return view;
    }

    @Override
    public void initData() {
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
