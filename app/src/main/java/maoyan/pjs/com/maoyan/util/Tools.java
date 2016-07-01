package maoyan.pjs.com.maoyan.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/23.
 */
public class Tools {

     private static AlertDialog mRoundProcessDialog = null;
     private static final  double EARTH_RADIUS = 6378137;//赤道半径(单位m)

     /**
      * 转化为弧度(rad)
      * 两经纬度之间的距离
      * */
     private static double rad(double d)
     {
          return d * Math.PI / 180.0;
     }
     /**
      * 基于googleMap中的算法得到两经纬度之间的距离,计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下
      * @param lon1 第一点的精度
      * @param lat1 第一点的纬度
      * @param lon2 第二点的精度
      * @return 返回的距离，单位km
      * */
     public static double GetDistance(double lon1,double lat1,double lon2, double lat2)
     {
          double radLat1 = rad(lat1);
          double radLat2 = rad(lat2);
          double a = radLat1 - radLat2;
          double b = rad(lon1) - rad(lon2);
          double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
          s = s * EARTH_RADIUS;
          s = Math.round(s * 10000) / 10000;
          return s;
     }

     /**
      * 加载等待圈
      *
      * @param mContext
      */
     public static void showRoundProcessDialog(Context mContext) {
          if (mRoundProcessDialog == null) {
           /* DialogInterface.OnKeyListener keyListener = new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {   //该加载圈无法被home键，搜索键，返回键取消。
                    if (keyCode == KeyEvent.KEYCODE_SEARCH ) {
                        return true;
                    }
                    return false;
                }
            };*/

               mRoundProcessDialog = new AlertDialog.Builder(mContext, R.style.TranslucentProcessDialog).create();
               //mRoundProcessDialog.setOnKeyListener(keyListener);
               //点击无法取消
               //mRoundProcessDialog.setCancelable(false);
               mRoundProcessDialog.show();
               // 注意此处要放在show之后 否则会报异常
               mRoundProcessDialog.setContentView(R.layout.activity_loading_process);
          }
     }

     /**
      * 取消等待圈
      */
     public static void dismissRoundProcessDialog() {
          if (mRoundProcessDialog != null) {
               mRoundProcessDialog.dismiss();
               mRoundProcessDialog = null;
          }
     }

    /**
     * 取消加载圈并弹出加载失败
     * @param context
     */
    public static void ToaDis(Context context){
         Tools.dismissRoundProcessDialog();
         Toast.makeText(context, "加载失败", Toast.LENGTH_SHORT).show();
     }


     /**
      * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
      */
     public static int dip2px(Context context, float dpValue) {
          final float scale = context.getResources().getDisplayMetrics().density;
          return (int) (dpValue * scale + 0.5f);
     }

     /**
      * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
      */
     public static int px2dip(Context context, float pxValue) {
          final float scale = context.getResources().getDisplayMetrics().density;
          return (int) (pxValue / scale + 0.5f);
     }

}
