package maoyan.pjs.com.maoyan.util;

import android.util.Log;
import android.widget.ImageView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.x;

import maoyan.pjs.com.maoyan.activity.GuideActivity;
import okhttp3.Call;

/**
 * Created by pjs984312808 on 2016/6/23.
 */
public class HttpUtils {


    /**
     * 请求引导页面图片
     * @param url
     * @param iv_welcome
     */
    public static void getGuideImage(String url, final ImageView iv_welcome) {

        OkHttpUtils
                .get()
                .url(url)
                /*.addParams("username", "hyman")
                .addParams("password", "123")*/
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("TAG", "请求失败=" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "请求成功=" + response);
                        try {
                            JSONObject json = new JSONObject(response);

                            JSONArray jsonArray = json.getJSONArray("posters");

                            JSONObject jsonObject = jsonArray.getJSONObject(0);

                            String url = jsonObject.optString("pic");

                            x.image().bind(iv_welcome, url);
                            if (iv_welcome.getDrawable() != null) {
                                GuideActivity.handler.sendEmptyMessage(0);
                            } else {
                                Log.i("TAG", "图片请求失败");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });
    }




}
