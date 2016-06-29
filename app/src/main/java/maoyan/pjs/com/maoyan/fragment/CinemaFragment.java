package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.CinemaAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class CinemaFragment extends BaseFragment {

    public static TextView tv_position;
    private MaterialRefreshLayout refresh;
    private RecyclerView recyclerView;
    public static CinemaAdapter adapter;
    public static List<Map<String,Object>> mapList= new ArrayList<>();
    public static Map<String,Object> mapLocation=new HashMap<>();
    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    tv_position.setText(mapLocation.get("detail").toString());
                    adapter.setLocation(mapLocation.get("lng").toString(),mapLocation.get("lat").toString());
                    break;
            }
        }
    };


    public CinemaFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view=View.inflate(context,R.layout.cinema,null);
        refresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        tv_position = (TextView) view.findViewById(R.id.tv_position);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i("TAG", "影院");
        init();
        //获取附近位置
        HttpUtils.getNearbyLocation(Constant.CinemaLocation);

        //请求影院viewpager
        HttpUtils.getCinemaVP(Constant.CinemaVP);

        //请求影院List
        HttpUtils.getCinemaList(Constant.CinemaList);

    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        adapter = new CinemaAdapter(context);
        recyclerView.setAdapter(adapter);
    }
}
