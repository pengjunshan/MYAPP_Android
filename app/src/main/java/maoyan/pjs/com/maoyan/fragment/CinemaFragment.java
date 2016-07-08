package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.WebViewAcitivy;
import maoyan.pjs.com.maoyan.adapter.CinemaAdapter;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.bean.CinemaListBean;
import maoyan.pjs.com.maoyan.droid.Activity01;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.CinemaSeverPopWindow;
import maoyan.pjs.com.maoyan.view.YRecycleview;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class CinemaFragment extends BaseFragment implements View.OnClickListener {

    public static RelativeLayout rl_location,cinema_title;
    public static TextView tv_position;
    private static YRecycleview recyclerView;
    public static CinemaAdapter adapter;

    public static LinearLayout ll_again;
    public static Button againloading;
    public static List<Map<String,Object>> mapList= new ArrayList<>();
    public static Map<String,Object> mapLocation=new HashMap<>();

    public static List<CinemaListBean.DataBean.changpingquBean> changPData=new ArrayList<>();
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

                case 2:
                    HttpUtils.getCinemaVP(Constant.CinemaVP,context);
                    recyclerView.setReFreshComplete();
                    Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    break;

                case 3:
                    recyclerView.setloadMoreComplete();
                    recyclerView.setNoMoreData(true);
                    Toast.makeText(context, "没有更多数据了...", Toast.LENGTH_SHORT).show();
                    break;

                case 4:
                    adapter = new CinemaAdapter(context,mapList,changPData);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
                    init();
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
        recyclerView = (YRecycleview) view.findViewById(R.id.recyclerView);
        tv_position = (TextView) view.findViewById(R.id.tv_position);
        rl_location = (RelativeLayout) view.findViewById(R.id.rl_location);
        cinema_title = (RelativeLayout) view.findViewById(R.id.cinema_title);

        ll_again = (LinearLayout) view.findViewById(R.id.ll_again);
        againloading = (Button) view.findViewById(R.id.againloading);

        againloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.getCinemaVP(Constant.CinemaVP,context);
            }
        });

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


        //请求影院viewpager
        HttpUtils.getCinemaVP(Constant.CinemaVP,context);
        Tools.showRoundProcessDialog(context);

        recyclerView.setOnTouchListener(new MyOnTouchListener());
        recyclerView.setRefreshAndLoadMoreListener(new YRecycleview.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        handler.sendEmptyMessage(2);
                    }
                }, 2500);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        handler.sendEmptyMessage(3);
                    }
                }, 2500);
            }
        });
    }

    private static void init() {

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
                context.startActivity(new Intent(context, Activity01.class));
                break;

            case R.id.iv_sever://打开快捷服务
                CinemaSeverPopWindow cinemaSeverPopWindow = new CinemaSeverPopWindow(context);
                cinemaSeverPopWindow.showAsDropDown(cinema_title, 0, 0);
                break;

            case R.id.iv_search:

                break;


        }
    }
}
