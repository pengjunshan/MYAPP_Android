package maoyan.pjs.com.maoyan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import maoyan.pjs.com.maoyan.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private LoginActivity ac;
    private ImageView iv_weixin, iv_qq, iv_weibo, iv_kongjian;
    private String nickname;
    private String userIcon;

    private TextView quicklogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ac = this;
        initView();
    }

    private void initView() {
        iv_weixin = (ImageView) findViewById(R.id.iv_weixin);
        iv_qq = (ImageView) findViewById(R.id.iv_qq);
        iv_weibo = (ImageView) findViewById(R.id.iv_weibo);
        iv_kongjian = (ImageView) findViewById(R.id.iv_kongjian);
        quicklogin = (TextView) findViewById(R.id.quicklogin);

        iv_weixin.setOnClickListener(this);
        iv_qq.setOnClickListener(this);
        iv_weibo.setOnClickListener(this);
        iv_kongjian.setOnClickListener(this);
        quicklogin.setOnClickListener(this);


        quicklogin.setOnClickListener(new MyClick());
    }

    @Override
    public void onClick(View v) {
        ShareSDK.initSDK(ac);
        switch (v.getId()) {
            case R.id.iv_weixin:
                loginWechat();
                break;

            case R.id.iv_qq:
                loginQQ();
                break;

            case R.id.iv_weibo:
                loginSinaWeibo();
                break;

            case R.id.iv_kongjian:
                loginQZone();
                break;
        }
    }


    class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.quicklogin:
                    smsLogin();
                    break;
            }
        }
    }


    private void smsLogin() {
        SMSSDK.initSDK(this, "14a06f832d59e", "e3885bc59a00a89cdd4a025545fc283c");

        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    Log.i("TAG", "注册短信验证信息="+country+"   -"+phone);

// 提交用户信息
//                    registerUser(country, phone);
                }
            }
        });
        registerPage.show(ac);
    }

    /**
     * 空间登录
     */
    private void loginQZone() {
        Platform qzone = ShareSDK.getPlatform(QZone.NAME);
        qzone.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Platform qzone = ShareSDK.getPlatform(ac, QZone.NAME);
                String accessToken = qzone.getDb().getToken(); // 获取授权token
                String openId = qzone.getDb().getUserId(); // 获取用户在此平台的ID
                nickname = qzone.getDb().get("nickname"); // 获取用户昵称
                Log.i("TAG", "用户名：=" + nickname);
                finish();
// 接下来执行您要的操作
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });
        qzone.authorize();
//移除授权
//weibo.removeAccount(true);
    }

    /**
     * 新浪微博
     */
    private void loginSinaWeibo() {
        Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
        weibo.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Platform sinaWeibo = ShareSDK.getPlatform(ac, SinaWeibo.NAME);
                String accessToken = sinaWeibo.getDb().getToken(); // 获取授权token
                String openId = sinaWeibo.getDb().getUserId(); // 获取用户在此平台的ID
                nickname = sinaWeibo.getDb().get("nickname"); // 获取用户昵称
                userIcon = sinaWeibo.getDb().getUserIcon();
                // 接下来执行您要的操作
                Log.i("TAG", "用户名：=" + nickname);
                finish();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });
        weibo.authorize();
//移除授权
//weibo.removeAccount(true);
    }

    /**
     * QQ登录
     */
    private void loginQQ() {
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        qq.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Platform qq = ShareSDK.getPlatform(ac, QQ.NAME);
                String accessToken = qq.getDb().getToken(); // 获取授权token
                String openId = qq.getDb().getUserId(); // 获取用户在此平台的ID
                nickname = qq.getDb().get("nickname"); // 获取用户昵称
                userIcon = qq.getDb().getUserIcon();

                Intent intent = new Intent();
                intent.putExtra("nickName", nickname);
                intent.putExtra("userIcon", userIcon);
                setResult(RESULT_OK, intent);
                finish();
// 接下来执行您要的操作
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });
        qq.authorize();
//移除授权
//weibo.removeAccount(true);
    }

    /**
     * 微信登录
     */
    private void loginWechat() {
        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        wechat.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Platform wechat = ShareSDK.getPlatform(ac, Wechat.NAME);
                String accessToken = wechat.getDb().getToken(); // 获取授权token
                String openId = wechat.getDb().getUserId(); // 获取用户在此平台的ID
                nickname = wechat.getDb().get("nickname"); // 获取用户昵称
                userIcon = wechat.getDb().getUserIcon();
                Log.i("TAG", "用户名：=" + nickname);
                finish();

// 接下来执行您要的操作
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });
        wechat.authorize();
//移除授权
//weibo.removeAccount(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Intent intent = new Intent();
//        intent.putExtra("nickName", nickname);
//        intent.putExtra("userIcon", userIcon);
//        Log.i("TAG", "用户名：=" + nickname);
//        Log.i("TAG", "用户头像连接：=" + userIcon);
//        setResult(RESULT_OK, intent);
    }


}
