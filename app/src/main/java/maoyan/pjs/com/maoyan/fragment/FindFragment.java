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
import maoyan.pjs.com.maoyan.adapter.FindAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class FindFragment extends BaseFragment {


    private MaterialRefreshLayout refresh;
    private RecyclerView recyclerView;
    public static FindAdapter adapter;
    public static List<Map<String,Object>> mapList=new ArrayList<>();

    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:

                    break;

                case 1:
                    int item = FindAdapter.FindVPHolder.viewpager.getCurrentItem()+1;
                    FindAdapter.FindVPHolder.viewpager.setCurrentItem(item);
                    handler.removeCallbacksAndMessages(null);
                    handler.sendEmptyMessageDelayed(1,3000);
                    break;
            }
        }
    };
    public FindFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.find,null);
        refresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i("TAG", "FindFragment");
        init();

        //请求viewpager数据
        HttpUtils.getFindVP(Constant.FindVP);

        //请求RadioButton数据
        HttpUtils.getRadioButton(Constant.FindRadioButton);

        //请求List数据
        HttpUtils.getListData(Constant.FindList,context);

        Tools.showRoundProcessDialog(context);
    }

    private void init() {
        adapter=new FindAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }
}
