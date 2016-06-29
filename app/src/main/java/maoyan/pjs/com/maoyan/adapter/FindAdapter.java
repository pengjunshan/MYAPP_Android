package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private LayoutInflater inflater;
    private List<Map<String, Object>> VPData;
    private List<Map<String, Object>> RbmapList;

    public FindAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0) {
            return new FindVPHolder(inflater.inflate(R.layout.item_find_vp,parent,false));
        }else if(viewType==1){
            return new FindRadioButtn(inflater.inflate(R.layout.item_find_radiobuttn,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return 0;
        }else if(position==1) {
            return 1;
        }
        return 2;
    }

    public void setVPData(List<Map<String, Object>> VPData) {
        this.VPData = VPData;
        notifyItemRangeChanged(0,1);
    }

    public void setRBData(List<Map<String, Object>> RbmapList) {
        this.RbmapList=RbmapList;
        notifyItemRangeChanged(1,2);
    }

    /**
     * 头部viewpager的Holder
     */
    class FindVPHolder extends RecyclerView.ViewHolder{

        private ViewPager viewpager;
        public FindVPHolder(View itemView) {
            super(itemView);
            viewpager = (ViewPager) itemView.findViewById(R.id.viewpager);
            if(VPData!=null&&VPData.size()>0) {
                viewpager.setAdapter(new VPAdapter(context,VPData));
            }
        }
    }

    /**
     * 头部RadioButton的Holder
     */
    class FindRadioButtn extends RecyclerView.ViewHolder{

        private ImageView iv_topic,iv_information,iv_movielib,iv_boxoffice;
        private TextView tv_topic,tv_information,tv_movielib,tv_boxoffice;

        public FindRadioButtn(View itemView) {
            super(itemView);
            iv_topic = (ImageView) itemView.findViewById(R.id.iv_topic);
            iv_information = (ImageView) itemView.findViewById(R.id.iv_information);
            iv_movielib = (ImageView) itemView.findViewById(R.id.iv_movielib);
            iv_boxoffice = (ImageView) itemView.findViewById(R.id.iv_boxoffice);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_topic);
            tv_information = (TextView) itemView.findViewById(R.id.tv_information);
            tv_movielib = (TextView) itemView.findViewById(R.id.tv_movielib);
            tv_boxoffice = (TextView) itemView.findViewById(R.id.tv_boxoffice);

            if(RbmapList!=null&&RbmapList.size()>0) {

                Map<String, Object> map1 = RbmapList.get(0);
                tv_topic.setText(map1.get("title").toString());
                Glide.with(context).load(map1.get("imageUrl").toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(iv_topic);//请求成功后把图片设置到的控件


                Map<String, Object> map2 = RbmapList.get(1);
                tv_information.setText(map2.get("title").toString());
                Glide.with(context).load(map2.get("imageUrl").toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(iv_information);//请求成功后把图片设置到的控件


                Map<String, Object> map3 = RbmapList.get(2);
                tv_movielib.setText(map3.get("title").toString());
                Glide.with(context).load(map3.get("imageUrl").toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(iv_movielib);//请求成功后把图片设置到的控件


                Map<String, Object> map4 = RbmapList.get(3);
                tv_boxoffice.setText(map4.get("title").toString());
                Glide.with(context).load(map4.get("imageUrl").toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(iv_boxoffice);//请求成功后把图片设置到的控件
            }

        }
    }




    class VPAdapter extends PagerAdapter{

        private final Context context;
        private final List<Map<String, Object>> vpData;

        public VPAdapter(Context context, List<Map<String, Object>> vpData) {
            this.context=context;
            this.vpData=vpData;
        }

        @Override
        public int getCount() {
            return vpData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Map<String, Object> map = vpData.get(position);
            ImageView imageView=new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(map.get("imgUrl").toString())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.mipmap.vp3)//加载过程中的图片
                    .error(R.mipmap.vp3)//加载失败的时候显示的图片
                    .into(imageView);//请求成功后把图片设置到的控件

            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
