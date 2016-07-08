package maoyan.pjs.com.maoyan.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.ECshopAdapter;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;

/**
 * 我的-商城
 */
public class ECshopActivity extends AppCompatActivity{

    private ECshopActivity ac;
    public static RecyclerView recyclerView;
    public static ECshopAdapter adapter;
    private LinearLayout ecshop_title,ll_ecshop01;
    private ImageView iv_search;

    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    int position=ECshopAdapter.HeardHolder.viewpager.getCurrentItem()+1;
                    ECshopAdapter.HeardHolder.viewpager.setCurrentItem(position);
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(0,3000);
                    break;
            }
        }
    };
    private int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecshop);
        ac=this;
        initFindView();
        initData();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initFindView() {
        recyclerView = (RecyclerView)findViewById(R.id.shop_recyclerview);
        ecshop_title = (LinearLayout)findViewById(R.id.ecshop_title);
        ll_ecshop01 = (LinearLayout)findViewById(R.id.ll_ecshop01);
        iv_search = (ImageView)findViewById(R.id.iv_search);

        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
    }

    private void initData() {
//        ecshop_title.getBackground().setAlpha(50);
        HttpUtils.getMeVP(Constant.MeVP,ac);
    }

    private void showShare() {

}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
//                Log.i("TAG*******快好吧", "event.getY():" + event.getY() + "event.getRawY():" + event.getRawY());

                //数组长度必须为2
//                int[] locations = new int[2];
//                 ECshopAdapter.HeardHolder.ll_ecshop01.getLocationOnScreen(locations);
//                int x = locations[0];//获取组件当前位置的横坐标
//                int y = locations[1];//获取组件当前位置的纵坐标
//                Log.i("TAG*******相約酒吧", "x:" + x + "y:" + y);

//                Log.i("TAG*******来吧来吧", "距离上部距离：" +ECshopAdapter.HeardHolder.ll_ecshop01.getTop() + "距离下部距离:" + ECshopAdapter.HeardHolder.ll_ecshop01.getBottom());
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onTouchEvent(event);

    }

}
