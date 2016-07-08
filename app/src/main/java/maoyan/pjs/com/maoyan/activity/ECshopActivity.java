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
    ShareSDK.initSDK(this);
    OnekeyShare oks = new OnekeyShare();
    //关闭sso授权
    oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
    //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
    // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
    oks.setTitle("这是神马标题");
    // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
    oks.setTitleUrl("http://image.so.com/v?q=%E9%AB%98%E5%9C%86%E5%9C%86&src=famous&fromurl=http%3A%2F%2Fwww.7kmn.com%2Farticle%2F34%2F1545.html#q=%E9%AB%98%E5%9C%86%E5%9C%86&src=famous&fromurl=http%3A%2F%2Fwww.7kmn.com%2Farticle%2F34%2F1545.html&lightboxindex=5&id=e54fdedddc3ef4024305feb0d4078b2b&multiple=1&itemindex=0&dataindex=8");
    // text是分享文本，所有平台都需要这个字段
    oks.setText("一人我饮酒醉");
    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
    //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
    // url仅在微信（包括好友和朋友圈）中使用
    oks.setUrl("http://www.360kan.com/tv/PbRran7kSWDtNX.html");
    // comment是我对这条分享的评论，仅在人人网和QQ空间使用
    oks.setComment("我是测试评论文本");
    // site是分享此内容的网站名称，仅在QQ空间使用
    oks.setSite(getString(R.string.app_name));
    // siteUrl是分享此内容的网站地址，仅在QQ空间使用
    oks.setSiteUrl("http://www.360kan.com/tv/PbRran7kSWDtNX.html");

// 启动分享GUI
    oks.show(this);
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
