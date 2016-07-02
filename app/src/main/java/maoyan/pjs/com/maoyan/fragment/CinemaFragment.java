package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.WebViewAcitivy;
import maoyan.pjs.com.maoyan.adapter.CinemaAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.CinemaSeverPopWindow;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class CinemaFragment extends BaseFragment implements View.OnClickListener {

    public static RelativeLayout rl_location,cinema_title;
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
                    Log.i("TAG", "地址="+mapLocation.get("detail").toString());
                    adapter.setLocation(mapLocation.get("lng").toString(),mapLocation.get("lat").toString());
                    break;

                case 1:
                    int item = CinemaAdapter.HeardHolder.cinema_viewpager.getCurrentItem()+1;
                    CinemaAdapter.HeardHolder.cinema_viewpager.setCurrentItem(item);
                    handler.removeCallbacksAndMessages(null);
                    handler.sendEmptyMessageDelayed(1,3000);
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
        rl_location = (RelativeLayout) view.findViewById(R.id.rl_location);
        cinema_title = (RelativeLayout) view.findViewById(R.id.cinema_title);
        ll_adr = (LinearLayout) view.findViewById(R.id.ll_adr);
        iv_sever = (ImageView) view.findViewById(R.id.iv_sever);
        iv_search = (ImageView) view.findViewById(R.id.iv_search);
        ll_adr.setOnClickListener(this);
        iv_sever.setOnClickListener(this);
        iv_search.setOnClickListener(this);

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
        HttpUtils.getCinemaList(Constant.CinemaList,context);
        Tools.showRoundProcessDialog(context);

        recyclerView.setOnTouchListener(new MyOnTouchListener());
    }

    private void init() {
        adapter = new CinemaAdapter(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));



        adapter.setOnItemClickLitener(new CinemaAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent=new Intent(context, WebViewAcitivy.class);
                intent.putExtra("url",Constant.CinemaWeb);
                context.startActivity(intent);
            }
        });
    }


    class MyOnTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    rl_location.setVisibility(View.INVISIBLE);
                    break;

                case MotionEvent.ACTION_MOVE:
                    rl_location.setVisibility(View.INVISIBLE);
                    break;

                case MotionEvent.ACTION_UP:
                    rl_location.setVisibility(View.VISIBLE);
                    break;


            }
            return false;
        }
    }

    private LinearLayout ll_adr;
    private ImageView iv_sever,iv_search;

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ll_adr:

                break;

            case R.id.iv_sever://打开快捷服务
                CinemaSeverPopWindow cinemaSeverPopWindow = new CinemaSeverPopWindow(context);
                cinemaSeverPopWindow.showAsDropDown(cinema_title, 0, 0);
                Log.i("TAG", "打开服务界面");
                break;

            case R.id.iv_search:

                break;


        }
    }
}
