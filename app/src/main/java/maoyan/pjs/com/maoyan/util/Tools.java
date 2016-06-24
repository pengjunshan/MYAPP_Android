package maoyan.pjs.com.maoyan.util;

import android.graphics.Bitmap;
import android.widget.ImageView;

import org.xutils.image.ImageOptions;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/23.
 */
public class Tools {

     public static ImageOptions bigImageOptions = new ImageOptions.Builder()
            .setImageScaleType(ImageView.ScaleType.CENTER_INSIDE)//等比例缩小到充满长/宽居中显示, 或原样显示
    .setLoadingDrawableId(R.mipmap.welcome)
    .setFailureDrawableId(R.mipmap.welcome)
    .setConfig(Bitmap.Config.ARGB_8888)
    .build();


}
