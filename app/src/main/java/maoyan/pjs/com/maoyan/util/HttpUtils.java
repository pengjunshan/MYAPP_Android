package maoyan.pjs.com.maoyan.util;

import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.activity.GuideActivity;
import maoyan.pjs.com.maoyan.bean.FireListBean;
import maoyan.pjs.com.maoyan.fragment.FireFragment;
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
                        Log.i("TAG", "请求引导页面=" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "请求引导页面=" + response);
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


    /**
     * 热映界面-ViewPager
     * @param url
     */
    public static void getFireViewPager(String url) {

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("TAG", "热映界面-ViewPager请求失败="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "热映界面-ViewPager请求成功="+response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json  = (JSONObject) jsonArray.get(i);
                                Map<String,Object> map=new HashMap<String, Object>();
                                String imgUrl = json.optString("imgUrl");
                                map.put("imgUrl",imgUrl);
                                FireFragment.listVP.add(map);
                            }
                            FireFragment.handler.sendEmptyMessage(0);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    /**
     * 热映界面list列表数据
     * @param url
     */
    public static void getFireList(String url) {

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("TAG", "热映界面list列表数据请求错误="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "热映界面list列表数据请求成功="+response);
//                        percessData(response);
                        FireListBean fireData = new Gson().fromJson(response, FireListBean.class);
                        List<FireListBean.DataBean.MoviesBean> moviesData = fireData.getData().getMovies();
                        if(moviesData!=null&&moviesData.size()>0) {
                            FireFragment.moviesData=moviesData;
                            FireFragment.handler.sendEmptyMessage(1);
                        }
                    }
                });
    }

    /*private static void percessData(String json) {
        FireListBean fireData = parseJson(json);
        List<FireListBean.DataBean.MoviesBean> moviesData = fireData.getData().getMovies();


    }


    private static FireListBean parseJson(String json) {

        return new Gson().fromJson(json,FireListBean.class);
    }*/


}
