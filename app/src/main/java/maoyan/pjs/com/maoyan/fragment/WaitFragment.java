package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.WaitFragmentAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 待映
 */
public class WaitFragment extends BaseFragment {

    private MaterialRefreshLayout wait_refresh;

    private RecyclerView wait_recyclerView;

    private WaitFragmentAdapter adapter;

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
        Log.i("TAG", "WaitFragment");
        init();
    }

    private void init() {

        wait_recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

        adapter=new WaitFragmentAdapter(context);
        wait_recyclerView.setAdapter(adapter);


    }
}
