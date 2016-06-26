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
import maoyan.pjs.com.maoyan.bean.USListBean;
import maoyan.pjs.com.maoyan.bean.WaitListBean;
import maoyan.pjs.com.maoyan.fragment.FireFragment;
import maoyan.pjs.com.maoyan.fragment.OverseasFragment;
import maoyan.pjs.com.maoyan.fragment.WaitFragment;
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
//                        Log.i("TAG", "热映界面-ViewPager请求失败="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.i("TAG", "热映界面-ViewPager请求成功="+response);
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
//                        Log.i("TAG", "热映界面list列表数据请求错误="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.i("TAG", "热映界面list列表数据请求成功="+response);
//                        percessData(response); percessData parseJson
                        FireListBean fireData = new Gson().fromJson(response, FireListBean.class);
                        List<FireListBean.DataBean.HotBean> moviesData = fireData.getData().getHot();
                        if(moviesData!=null&&moviesData.size()>0) {
                            FireFragment.moviesData=moviesData;
                            FireFragment.handler.sendEmptyMessage(1);
                        }
                    }
                });
    }

    /**
     * 待映下部分数据
     * @param url
     */
    public static void getWaitListData(String url) {

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
//                        Log.i("TAG", "待映下部分数据请求错误="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.i("TAG", "待映下部分数据请求成功="+response);
                        WaitListBean waitListBean = new Gson().fromJson(response, WaitListBean.class);
                        WaitListBean.DataBean data = waitListBean.getData();
                        List<WaitListBean.DataBean.ComingBean> comingData = data.getComing();
                        if(comingData!=null&&comingData.size()>0) {
                            WaitFragment.comingData=comingData;
                            WaitFragment.handler.sendEmptyMessage(0);
                        }
                    }
                });

    }


    /**
     * 请求海外热映的国家名称
     * @param countryUrl
     */
    public static void getCountryData(String countryUrl) {
            OkHttpUtils.get().url(countryUrl).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    Log.i("TAG", "海外热映国家名称数据请求失败"+e.getMessage());
                }

                @Override
                public void onResponse(String response, int id) {
                    Log.i("TAG", "海外热映国家名称数据请求成功"+response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String data = jsonObject.getString("data");
                        JSONObject object = new JSONObject(data);

                        JSONArray jsonArray = object.getJSONArray("areas");
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            Map<String,Object> map=new HashMap<String, Object>();
                            JSONObject json = (JSONObject) jsonArray.get(i);
                            map.put("name",json.opt("name"));
                            OverseasFragment.mapList.add(map);
                        }
                        if(OverseasFragment.mapList!=null&&OverseasFragment.mapList.size()>0) {
                            OverseasFragment.handler.sendEmptyMessage(0);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    /**
     * 美国热映
     * @param usUrl
     */
    public static void getUSData(String usUrl) {
            OkHttpUtils.get().url(usUrl).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    Log.i("TAG", "美国数据请求失败"+e.getMessage());
                }

                @Override
                public void onResponse(String response, int id) {
                    Log.i("TAG", "美国数据请求成功"+response);
                    USListBean usListBean = new Gson().fromJson(response, USListBean.class);

                }
            });
    }

    /**
     * 韩国热映
     * @param krUrl
     */
    public static void getKRData(String krUrl) {
        OkHttpUtils.get().url(krUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "韩国数据请求失败"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "韩国数据请求成功"+response);

            }
        });
    }

    /**
     * 日本热映
     * @param jpUrl
     */
    public static void getJPSData(String jpUrl) {
        OkHttpUtils.get().url(jpUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "日本数据请求成功"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "日本数据请求成功"+response);
            }
        });
    }



}
