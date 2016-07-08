package maoyan.pjs.com.maoyan.util;

import android.content.Context;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.activity.ECshopActivity;
import maoyan.pjs.com.maoyan.activity.GuideActivity;
import maoyan.pjs.com.maoyan.activity.ShopTypeActivity;
import maoyan.pjs.com.maoyan.adapter.ECshopAdapter;
import maoyan.pjs.com.maoyan.adapter.JPAdapter;
import maoyan.pjs.com.maoyan.adapter.KRAdapter;
import maoyan.pjs.com.maoyan.adapter.USAdapter;
import maoyan.pjs.com.maoyan.bean.CinemaListBean;
import maoyan.pjs.com.maoyan.bean.ECshopBean;
import maoyan.pjs.com.maoyan.bean.FindListBean;
import maoyan.pjs.com.maoyan.bean.FireListBean;
import maoyan.pjs.com.maoyan.bean.JPListBean;
import maoyan.pjs.com.maoyan.bean.KRListBean;
import maoyan.pjs.com.maoyan.bean.USListBean;
import maoyan.pjs.com.maoyan.bean.WaitExpctBean;
import maoyan.pjs.com.maoyan.bean.WaitListBean;
import maoyan.pjs.com.maoyan.fragment.CinemaFragment;
import maoyan.pjs.com.maoyan.fragment.FindFragment;
import maoyan.pjs.com.maoyan.fragment.FireFragment;
import maoyan.pjs.com.maoyan.fragment.JPFragment;
import maoyan.pjs.com.maoyan.fragment.KRFragmnet;
import maoyan.pjs.com.maoyan.fragment.OverseasFragment;
import maoyan.pjs.com.maoyan.fragment.USFragment;
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
    public static void getGuideImage(String url, final ImageView iv_welcome, final Context context) {

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
                        Tools.ToaDis(context);
                        GuideActivity.handler.sendEmptyMessage(1);
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
     * @param context
     */
    public static void getFireViewPager(String url, final Context context) {

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
//                        Log.i("TAG", "热映界面-ViewPager请求失败="+e.getMessage());
                        Tools.ToaDis(context);
                        FireFragment.ll_again.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Log.i("TAG", "热映界面-ViewPager请求成功="+response);
                        FireFragment.ll_again.setVisibility(View.GONE);
                        Tools.dismissRoundProcessDialog();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            List<Map<String, Object>> listVP = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json  = (JSONObject) jsonArray.get(i);
                                Map<String,Object> map=new HashMap<String, Object>();
                                String imgUrl = json.optString("imgUrl");
                                map.put("imgUrl",imgUrl);
                               listVP.add(map);
                            }
                            if(listVP.size()>0) {
                                FireFragment.listVP=listVP;
                            }
                            FireFragment.showData();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    /**
     * 热映界面list列表数据
     * @param url
     * @param context
     */
    public static void getFireList(String url, final Context context) {


        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
//                        Log.i("TAG", "热映界面list列表数据请求错误="+e.getMessage());
                        Tools.ToaDis(context);
                        FireFragment.ll_again.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //请求ViewPager数据

                        HttpUtils.getFireViewPager(Constant.FireVPUrl,context);
//                        Log.i("TAG", "热映界面list列表数据请求成功="+response);
                        FireListBean fireData = new Gson().fromJson(response, FireListBean.class);
                        List<FireListBean.DataBean.HotBean> moviesData = fireData.getData().getHot();
                        if(moviesData!=null&&moviesData.size()>0) {
                            FireFragment.moviesData=moviesData;
                        }
                    }
                });
    }

    /**
     * 待映下部分数据
     * @param url
     * @param context
     */
    public static void getWaitListData(String url, final Context context) {

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
//                        Log.i("TAG", "待映下部分数据请求错误="+e.getMessage());
//                      Tools.ToaDis(context);
                        WaitFragment.ll_again.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        WaitFragment.ll_again.setVisibility(View.GONE);
                        Tools.dismissRoundProcessDialog();
                        Log.i("TAG", "待映下部分数据请求成功="+response);
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
                        OverseasFragment.mapList.clear();
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
     * @param context
     */
    public static void getUSData(final String usUrl, final Context context) {

            OkHttpUtils.get().url(usUrl).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    Log.i("TAG", "美国数据请求失败"+e.getMessage());
                    Tools.ToaDis(context);
                    USFragment.ll_again.setVisibility(View.VISIBLE);
                }

                @Override
                public void onResponse(String response, int id) {
                    Log.i("TAG", "美国数据请求成功"+response);
                    USFragment.ll_again.setVisibility(View.GONE);
                    Tools.dismissRoundProcessDialog();
                    USListBean usListBean2 = new Gson().fromJson(response, USListBean.class);
                    List<USListBean.DataBean.ComingBean> comingData2 = usListBean2.getData().getComing();
                    if(comingData2!=null&&comingData2.size()>0) {
                        USFragment.adapter=new USAdapter(context,comingData2);
                        USFragment.recyclerView.setAdapter(USFragment.adapter);
                    }
                }
            });
    }

    /**
     * 韩国热映
     * @param krUrl
     * @param context
     */
    public static void getKRData(String krUrl, final Context context) {
        OkHttpUtils.get().url(krUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "韩国数据请求失败"+e.getMessage());
                Tools.ToaDis(context);
                KRFragmnet.ll_again.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "韩国数据请求成功"+response);
                KRFragmnet.ll_again.setVisibility(View.GONE);
                Tools.dismissRoundProcessDialog();
                KRListBean krListBean = new Gson().fromJson(response, KRListBean.class);
                List<KRListBean.DataBean.HotBean> hotData = krListBean.getData().getHot();
                if(hotData!=null&&hotData.size()>0) {
                    KRFragmnet.adapter =new KRAdapter(context,hotData);
                    //关联适配器
                    KRFragmnet.recyclerView.setAdapter(KRFragmnet.adapter);
//                    KRFragmnet.adapter.setkrList(hotData);
                }
            }
        });
    }

    /**
     * 日本热映
     * @param jpUrl
     * @param context
     */
    public static void getJPSData(String jpUrl, final Context context) {
        OkHttpUtils.get().url(jpUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "日本数据请求成功"+e.getMessage());
                Tools.ToaDis(context);
                JPFragment.ll_again.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "日本数据请求成功"+response);
                JPFragment.ll_again.setVisibility(View.GONE);
                Tools.dismissRoundProcessDialog();
                JPListBean jpListBean = new Gson().fromJson(response, JPListBean.class);
                List<JPListBean.DataBean.HotBean> hotBeen = jpListBean.getData().getHot();
                if(hotBeen!=null&&hotBeen.size()>0) {
                    JPFragment.adapter = new JPAdapter(context,hotBeen);
                    JPFragment.recyclerView.setAdapter(JPFragment.adapter);
                }
            }
        });
    }


    /**
     * 请求影院上部分viewpager
     */
    public static void getCinemaVP(String url, final Context context) {
        OkHttpUtils
                .get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("TAG", "请求影院上部分viewpager请求失败="+e.getMessage());
                        CinemaFragment.ll_again.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "请求影院上部分viewpager请求成功="+response);
                        //请求影院List
                        HttpUtils.getCinemaList(Constant.CinemaList,context);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object= (JSONObject) jsonArray.get(i);
                                Map<String,Object> map = new HashMap<String, Object>();
                                String imgUrl = object.optString("imgUrl");
                                String url = object.optString("url");
                                map.put("imgUrl",imgUrl);
                                map.put("url",url);
                                CinemaFragment.mapList.add(map);
                            }
//                            if(CinemaFragment.mapList!=null&&CinemaFragment.mapList.size()>0) {
//                                CinemaFragment.adapter.setVP(CinemaFragment.mapList);
//                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 影院List
     * @param url
     * @param context
     */
    public static void getCinemaList(String url, final Context context) {

        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "影院List请求失败="+e.getMessage());
                Tools.ToaDis(context);
                CinemaFragment.ll_again.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String result, int id) {
                Log.i("TAG", "影院List请求成功="+result);
                //获取附近位置
                HttpUtils.getNearbyLocation(Constant.CinemaLocation);
                CinemaFragment.ll_again.setVisibility(View.GONE);
                Tools.dismissRoundProcessDialog();
                result = result.replace("朝阳区", "chaoyangqu");
                result = result.replace("海淀区", "haidianqu");
                result = result.replace("东城区", "dongchengqu");
                result = result.replace("丰台区", "fengtaiqu");
                result = result.replace("大兴区", "daxingqu");
                result = result.replace("西城区", "xichengqu");
                result = result.replace("通州区", "tongzhouqu");
                result = result.replace("昌平区", "changpingqu");
                result = result.replace("房山区", "fangshanqu");
                result = result.replace("顺义区", "shunyiqu");
                result = result.replace("门头沟区", "mentougouqu");
                result = result.replace("石景山区", "shijingshanqu");
                result = result.replace("怀柔区", "huairouqu");
                result = result.replace("平谷区", "pingguqu");
                result = result.replace("密云县", "miyunxian");
                result = result.replace("延庆县", "yanqingxian");


                CinemaListBean cinemaListBean = new Gson().fromJson(result, CinemaListBean.class);
                List<CinemaListBean.DataBean.changpingquBean> changPData = cinemaListBean.getData().getchangpingqu();

                if(changPData!=null&&changPData.size()>0) {
                    CinemaFragment.changPData=changPData;
                    CinemaFragment.handler.sendEmptyMessage(4);
                }
            }
        });
    }

    /**
     * 获取附近位置
     */
    public static void getNearbyLocation(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "获取附近位置失败="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "获取附近位置成功="+response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String jsonObjectString = jsonObject.getString("data");
                    JSONObject jsonObject1 = new JSONObject(jsonObjectString);

                    String city = jsonObject1.optString("city");//城市名 北京
                    String province = jsonObject1.optString("province");//北京市
                    String district = jsonObject1.optString("district");//区名
                    String detail = jsonObject1.optString("detail");//附近地点名
                    String lat = jsonObject1.optString("lat");//经纬度
                    String lng = jsonObject1.optString("lng");//经纬度

                    CinemaFragment.mapLocation.put("city",city);
                    CinemaFragment.mapLocation.put("province",province);
                    CinemaFragment.mapLocation.put("district",district);
                    CinemaFragment.mapLocation.put("detail",detail);
                    CinemaFragment.mapLocation.put("lat",lat);
                    CinemaFragment.mapLocation.put("lng",lng);

                    CinemaFragment.handler.sendEmptyMessage(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    /**
     * 获取附近位置
     */
    public static void getNearbyLocation2(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "获取附近位置失败="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "获取附近位置成功="+response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String jsonObjectString = jsonObject.getString("data");
                    JSONObject jsonObject1 = new JSONObject(jsonObjectString);

                    String city = jsonObject1.optString("city");//城市名 北京
                    String province = jsonObject1.optString("province");//北京市
                    String district = jsonObject1.optString("district");//区名
                    String detail = jsonObject1.optString("detail");//附近地点名
                    String lat = jsonObject1.optString("lat");//经纬度
                    String lng = jsonObject1.optString("lng");//经纬度

                        Message message =Message.obtain();
                        message.what=1;
                        message.obj=city;
                        FireFragment.handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * 发现上部viewpager
     */
    public static void getFindVP(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "发现上部viewpager请求失败="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "发现上部viewpager请求成功="+response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = (JSONObject) jsonArray.get(i);
                        Map<String,Object> map=new HashMap<String, Object>();
                        String imgUrl = object.optString("imgUrl");
                        String url1 = object.optString("url");
                        map.put("imgUrl",imgUrl);
                        map.put("url1",url1);
                        FindFragment.mapList.add(map);
                    }
                    if(FindFragment.mapList.size()>0) {
                        FindFragment.adapter.setVPData( FindFragment.mapList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 发现RadioButton
     */
    public static void getRadioButton(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "发现RadioButton请求失败="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "发现RadioButton请求成功="+response);
                try {
                    List<Map<String,Object>> mapList=new ArrayList<Map<String, Object>>();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = (JSONObject) jsonArray.get(i);
                        Map<String,Object> map=new HashMap<String, Object>();
                        JSONObject image = object.getJSONObject("image");

                        String title = object.optString("title");
                        String webUrl = object.optString("url");
                        String imageUrl = image.optString("url");

                        map.put("title",title);
                        map.put("webUrl",webUrl);
                        map.put("imageUrl",imageUrl);
                        mapList.add(map);
                    }
                    if(mapList.size()>0) {
                        FindFragment.adapter.setRBData(mapList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 请求发现下部分数据
     * @param url
     * @param context
     */
    public static void getListData(String url, final Context context) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "请求发现下部分数据请求失败="+e.getMessage());
                Tools.ToaDis(context);
            }

            @Override
            public void onResponse(String response, int id) {
                Tools.dismissRoundProcessDialog();
                Log.i("TAG", "请求发现下部分数据请求成功="+response);
                FindListBean findListBean = new Gson().fromJson(response, FindListBean.class);
                FindListBean.DataBean dataBean = findListBean.getData();
                List<FindListBean.DataBean.FeedsBean> feedList = dataBean.getFeeds();
                if(feedList!=null&&feedList.size()>0) {
                    FindFragment.adapter.setListData(feedList);
                }
            }
        });
    }

    /**
     * 请求待映预告推荐
     */
    public static void getWaitRecommend(String url, final Context context) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "请求待映预告推荐失败="+e.getMessage());
                WaitFragment.ll_again.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "请求待映预告推荐成功="+response);
                //请求待映最受期待
                HttpUtils.WaitExpct(Constant.WaitExpct,context);

                USListBean waitRecomBean = new Gson().fromJson(response, USListBean.class);
                List<USListBean.DataBean.ComingBean> recomData = waitRecomBean.getData().getComing();
                if(recomData!=null&&recomData.size()>0) {
                    WaitFragment.recomData=recomData;
                }
            }
        });
    }

    /**
     * 请求待映最受期待
     */
    public static void WaitExpct(String url, final Context context) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "请求待映最受期待失败="+e.getMessage());
                WaitFragment.ll_again.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("TAG", "请求待映最受期待成功="+response);
                HttpUtils.getWaitListData(Constant.WaitListUrl,context);

                WaitExpctBean waitExpctBean = new Gson().fromJson(response, WaitExpctBean.class);
                List<WaitExpctBean.DataBean.MoviesBean> moviesData = waitExpctBean.getData().getMovies();
                if(moviesData!=null&&moviesData.size()>0){
                    WaitFragment.moviesData=moviesData;
                }
            }
        });
    }


    /**
     * 我的-viewpager
     * @param url
     * @param ac
     */
    public static void getMeVP(String url, final Context ac) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("TAG", "我的-viewpager请求数据失败="+e.getMessage());
                Tools.ToaDis(ac);
            }

            @Override
            public void onResponse(String response, int id) {
                Tools.dismissRoundProcessDialog();
                Log.i("TAG", "我的-viewpager请求数据成功="+response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    List<Map<String,Object>> mapList= new ArrayList<Map<String, Object>>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Map<String,Object> map=new HashMap<String, Object>();
                        JSONObject object = (JSONObject) jsonArray.get(i);
                        String imgUrl = object.optString("imgUrl");
                        String url = object.optString("url");
                        map.put("imgUrl",imgUrl);
                        map.put("url",url);
                        mapList.add(map);
                    }
                    if(mapList.size()>0) {
                        ECshopActivity.adapter=new ECshopAdapter(ac,mapList);
                        ECshopActivity.recyclerView.setAdapter(ECshopActivity.adapter);
                        ECshopActivity.recyclerView.setLayoutManager(new LinearLayoutManager(ac,LinearLayoutManager.VERTICAL,false));
//                        ECshopActivity.adapter.setVP(mapList);
                        Log.i("TAG", "请求到了");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 获取商城中十个数据
     */
    public static void getShopNum(final Context context, final String url, final int type) {
         OkHttpUtils.get().url(url).build().execute(new StringCallback() {
             @Override
             public void onError(Call call, Exception e, int id) {
                 Log.i("TAG", "获取商城中十个数据请求失败="+e.getMessage());
                 Tools.ToaDis(context);
             }

             @Override
             public void onResponse(String response, int id) {
                 Log.i("TAG", "获取商城中十个数据请求成功"+response);
                 Tools.dismissRoundProcessDialog();
                 ECshopBean eCshopBean = new Gson().fromJson(response, ECshopBean.class);
                 List<ECshopBean.DataBean.ListBean> listData = eCshopBean.getData().getList();
                 if(listData.size()>0) {
                     ShopTypeActivity.listData=listData;
                     Message message=Message.obtain();
                     message.obj=url;
                     message.what=0;
                     ShopTypeActivity.handler.sendMessage(message);
                     ShopTypeActivity.setType(type);
                 }
                 if(type==0) {
                     ShopTypeActivity.handler.sendEmptyMessage(1);
                 }
             }

         });
    }


}
