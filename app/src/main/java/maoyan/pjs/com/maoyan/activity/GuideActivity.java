package maoyan.pjs.com.maoyan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.x;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.utils.Constant;
import okhttp3.Call;

public class GuideActivity extends AppCompatActivity {

    private GuideActivity ac;
    private ImageView iv_welcome;
   /* private ImageOptions bigImageOptions = new ImageOptions.Builder()
            .setImageScaleType(ImageView.ScaleType.CENTER_INSIDE)//等比例缩小到充满长/宽居中显示, 或原样显示
    .setLoadingDrawableId(R.mipmap.welcome)
    .setFailureDrawableId(R.mipmap.welcome)
    .setConfig(Bitmap.Config.ARGB_8888)
    .build();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ac=this;
        iv_welcome = (ImageView)findViewById(R.id.iv_welcome);

        getHttpData();
    }

    private void setAnimotion() {
        ScaleAnimation sa=new ScaleAnimation(1,1.2f,1,1.2f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(4000);
        sa.setFillAfter(true);

        iv_welcome.setAnimation(sa);

        sa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                ac.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void getHttpData() {
        String url = Constant.GuideUrl;
        OkHttpUtils
                .get()
                .url(url)
                /*.addParams("username", "hyman")
                .addParams("password", "123")*/
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("TAG", "请求失败="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "请求成功="+response);
                        try {
                            JSONObject json=  new JSONObject(response);

                              JSONArray jsonArray = json.getJSONArray("posters");

                            JSONObject jsonObject = jsonArray.getJSONObject(0);

                            String url = jsonObject.optString("pic");

                             /*  //使用Glide请求图片
                                                      Glide.with(ac).load(url)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
//                                    .placeholder(R.mipmap.welcome)//加载过程中的图片
//                                    .error(R.mipmap.welcome)//加载失败的时候显示的图片
                                    .into(iv_welcome);//请求成功后把图片设置到的控件*/
                            x.image().bind(iv_welcome,url);
                            if(iv_welcome.getDrawable()!=null) {
                                setAnimotion();
                            }else {
                                Log.i("TAG", "图片请求失败");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });



       /* RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("TAG", "请求成功="+result.toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i("TAG", "xutils请求失败="+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                Log.i("TAG", "请求完成");
            }
        });*/

    }
}
