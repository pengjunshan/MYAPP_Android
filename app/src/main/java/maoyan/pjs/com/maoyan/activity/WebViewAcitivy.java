package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.util.Tools;

public class WebViewAcitivy extends AppCompatActivity {

    private WebView webView;
    private String url;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_acitivy);
        webView = (WebView) findViewById(R.id.webview);

        //得到地址
        url=getIntent().getStringExtra("url");

        Log.i("TAG", "url="+url);
        //加载网页
        webView.loadUrl(url);

        //得到webview的设置
        webSettings = webView.getSettings();

        //设置WebView支持javaScript
        webSettings.setJavaScriptEnabled(true);

        //用户双击页面页面变大变小-页面要支持才可以
        webSettings.setUseWideViewPort(true);

        //增加缩放按钮 --页面要支持才可以
        webSettings.setBuiltInZoomControls(true);

        //当webview请求成功
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Tools.dismissRoundProcessDialog();
            }
        });
    }
}
