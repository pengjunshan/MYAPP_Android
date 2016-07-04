package maoyan.pjs.com.maoyan.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pjs984312808 on 2016/7/4.
 */
public class SPUtitl {

    /**
     * 保存左菜单的json数据
     * @param context
     */
    public static void saveJsonString(Context context, String key, String values) {
        SharedPreferences sp=context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        sp.edit().putString(key,values).commit();
    }


    /**
     * 获取json缓存
     * @param context
     * @param key
     */
    public static String getJsonString(Context context, String key) {
        SharedPreferences sp=context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
