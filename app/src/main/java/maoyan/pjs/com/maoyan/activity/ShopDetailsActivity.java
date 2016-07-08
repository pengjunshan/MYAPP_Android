package maoyan.pjs.com.maoyan.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cn.bleu.widget.slidedetails.SlideDetailsLayout;
import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.interfaces.ISlideCallback;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.ScrollViewFragment;

public class ShopDetailsActivity extends AppCompatActivity implements ISlideCallback {

    private ShopDetailsActivity ac;
    private SlideDetailsLayout mSlideDetailsLayout;

    private String imgurl;
    private  String title;
    public static int dealid;
    public static int position;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    ScrollViewFragment.tv_title.setText(title);
                    Tools.loadImage(ac,imgurl,ScrollViewFragment.iv_icon);
                break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);
        ac=this;

        Intent intent = getIntent();
        imgurl = intent.getStringExtra("imgurl");
        title = intent.getStringExtra("title");
        dealid = intent.getIntExtra("dealid", 0);
        position = intent.getIntExtra("position", 0);
        Log.i("TAG", "对象内容="+title+"***"+imgurl);
        if(title!=null&&imgurl!=null) {
            handler.sendEmptyMessage(0);
        }

        mSlideDetailsLayout = (SlideDetailsLayout)findViewById(R.id.slidedetails);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.slidedetails_front, new ScrollViewFragment()).commit();


        final WebView webView = (WebView) findViewById(R.id.slidedetails_behind);
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            new Object() {
                public void setLoadWithOverviewMode(boolean overview) {
                    settings.setLoadWithOverviewMode(overview);
                }
            }.setLoadWithOverviewMode(true);
        }

        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("http://m.maoyan.com/store/topicDetail/300000056?_v_=yes&f=android&userid=-1&pushToken=8568be797789152f60d193cec511b9d2c01ebd1e6da38efbd62611e87b213090103b4d6d4a8cb7a6cd70f822f26ffff9&cityId=1");
            }
        });
    }

    @Override
    public void openDetails(boolean smooth) {
        mSlideDetailsLayout.smoothOpen(smooth);
    }

    @Override
    public void closeDetails(boolean smooth) {
        mSlideDetailsLayout.smoothClose(smooth);
    }
}
