package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import maoyan.pjs.com.maoyan.R;

public class ceshi3 extends AppCompatActivity {

    private Button btn_login,btn_login2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceshi3);


        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login2 = (Button)findViewById(R.id.btn_login2);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(ceshi3.this);
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                weibo.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform qzone = ShareSDK.getPlatform(ceshi3.this, SinaWeibo.NAME);
                        String accessToken = qzone.getDb().getToken(); // 获取授权token
                        String openId = qzone.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = qzone.getDb().get("nickname"); // 获取用户昵称
                                                // 接下来执行您要的操作
                        Log.i("TAG", "用户名：="+nickname);
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
        });


        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(ceshi3.this);
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.SSOSetting(false);  //设置false表示使用SSO授权方式
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform qzone = ShareSDK.getPlatform(ceshi3.this, QQ.NAME);
                        String accessToken = qzone.getDb().getToken(); // 获取授权token
                        String openId = qzone.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = qzone.getDb().get("nickname"); // 获取用户昵称
                        Log.i("TAG", "用户名：="+nickname);
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                }); // 设置分享事件回调
                qq.authorize();
                /*Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform qzone = ShareSDK.getPlatform(ceshi3.this, QZone.NAME);
                        String accessToken = qzone.getDb().getToken(); // 获取授权token
                        String openId = qzone.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = qzone.getDb().get("nickname"); // 获取用户昵称
                        Log.i("TAG", "用户名：="+nickname);
// 接下来执行您要的操作
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                qq.authorize();*/
//移除授权
//weibo.removeAccount(true);
            }
        });
    }
}
