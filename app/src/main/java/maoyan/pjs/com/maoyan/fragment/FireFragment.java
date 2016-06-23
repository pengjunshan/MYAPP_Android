package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.FireFragmentAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 热映
 */
public class FireFragment extends BaseFragment {

    private MaterialRefreshLayout mRefresh;

    private RecyclerView mRecyclerView;

    private FireFragmentAdapter adapter;




    public FireFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.movie_fire,null);
        mRefresh = (MaterialRefreshLayout) view.findViewById(R.id.sp_refresh);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.sp_recyclerView);

        return view;

    }

    @Override
    public void initData() {
        super.initData();
        Log.i("TAG", "FireFragment");
        init();
    }

    private void init() {


        mRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        adapter=new FireFragmentAdapter(context);

//        mRefresh.setSunStyle(true);
        mRecyclerView.setAdapter(adapter);

    }


}
