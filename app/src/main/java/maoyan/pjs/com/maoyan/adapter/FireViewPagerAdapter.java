package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/25.
 */
public class FireViewPagerAdapter extends PagerAdapter {

    private final Context mContext;
    public static List<Map<String, Object>> listVP;


    public FireViewPagerAdapter(Context mContext, List<Map<String, Object>> listVP) {
        this.mContext=mContext;
        this.listVP=listVP;
        Log.i("TAG", "listVP****="+listVP.toString());
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("TAG", "listVP2******="+listVP.toString());
        int realposition=0;
        if(listVP.size()!=0) {
            realposition =position%listVP.size();//得到实际的下标
        Map<String, Object> map = listVP.get(realposition);
        String imgUrl = map.get("imgUrl").toString();
        ImageView image=new ImageView(mContext);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                .placeholder(R.mipmap.lh)//加载过程中的图片
                .error(R.mipmap.lh)//加载失败的时候显示的图片
                .into(image);//请求成功后把图片设置到的控件
        container.addView(image);
        return image;
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setVPData(List<Map<String, Object>> listVP) {
        this.listVP=listVP;
        notifyDataSetChanged();
    }

    public void deleteData() {
        this.listVP.clear();
        notifyDataSetChanged();
    }
}
