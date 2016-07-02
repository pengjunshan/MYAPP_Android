package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.KRAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/22.
 */
public class KRFragmnet extends BaseFragment {

    private MaterialRefreshLayout refresh;
    public static RecyclerView recyclerView;

    public static KRAdapter adapter;

    public KRFragmnet(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view=View.inflate(context, R.layout.kr,null);
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
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }
}
