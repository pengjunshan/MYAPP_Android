package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.JPAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/22.
 */
public class JPFragment extends BaseFragment {

    public static RecyclerView recyclerView;
    public static MaterialRefreshLayout refresh;
    public static JPAdapter adapter;

    public JPFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view = View.inflate(context, R.layout.jp, null);
        refresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        /*adapter = new JPAdapter(context);
        recyclerView.setAdapter(adapter);*/
    }
}
