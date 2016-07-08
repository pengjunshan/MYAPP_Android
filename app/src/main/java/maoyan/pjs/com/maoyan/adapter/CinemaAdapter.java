package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import maoyan.pjs.com.maoyan.bean.CinemaListBean;
import maoyan.pjs.com.maoyan.fragment.CinemaFragment;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class CinemaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static Context context;
    private static List<Map<String, Object>> mapList;
    private LayoutInflater inflater;
    private List<CinemaListBean.DataBean.changpingquBean> changPData;
    private String lng;
    private String lat;

    public CinemaAdapter(Context context, List<Map<String, Object>> mapList, List<CinemaListBean.DataBean.changpingquBean> changPData) {
        this.context=context;
        this.mapList=mapList;
        this.changPData=changPData;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0) {
            return new HeardHolder(inflater.inflate(R.layout.item_cinema_header,parent,false));
        }else {
            return new ContentHolder(inflater.inflate(R.layout.item_cinema_content,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HeardHolder) {

        }else if(holder instanceof ContentHolder) {
            if(changPData!=null&&changPData.size()>0) {
                CinemaListBean.DataBean.changpingquBean changPingBean = changPData.get(position - 1);

                ((ContentHolder)holder).tv_nm.setText(changPingBean.getNm());
                ((ContentHolder)holder).tv_sellPrice.setText(changPingBean.getSellPrice()+"");
                ((ContentHolder)holder).tv_addr.setText(changPingBean.getAddr());

                if(lng!=null&&lat!=null) {
                    double lngDou = Double.parseDouble(lng);
                    double latDou = Double.parseDouble(lat);
                    double dist = Tools.GetDistance(lngDou, latDou, changPingBean.getLng(), changPingBean.getLat());

                    if(!TextUtils.isEmpty("dist")) {
                        dist=dist/1000;
                    }
                    ((ContentHolder)holder).tv_km.setText(dist+"km");
                }

                if(changPingBean.getSellPrice()<30) {
                    ((ContentHolder)holder).tv_goup.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if(changPData!=null&&changPData.size()>0) {
            return changPData.size()+1;
        }
        return 1;
    }

//    public void setVP(List<Map<String, Object>> mapList) {
//        this.mapList=mapList;
//        notifyItemRangeChanged(0,1);
//    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return 0;
        }
        return 1;

    }

//    public void setListData(List<CinemaListBean.DataBean.changpingquBean> listData) {
//        this.changPData = listData;
//        notifyItemRangeChanged(1,listData.size());
//    }

    public void setLocation(String lng, String lat) {
        this.lng=lng;
        this.lat=lat;
    }


   public static class HeardHolder extends RecyclerView.ViewHolder{

        public static ViewPager cinema_viewpager;
        public HeardHolder(View itemView) {
            super(itemView);
            cinema_viewpager = (ViewPager) itemView.findViewById(R.id.cinema_viewpager);
            if(mapList!=null&&mapList.size()>0) {
                cinema_viewpager.setAdapter(new cinemaVPAdapter(context,mapList));

                //设置显示在最大值的中间
                int centitem = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mapList.size();
                cinema_viewpager.setCurrentItem(centitem);

                CinemaFragment.handler.sendEmptyMessageDelayed(1, 3000);
            }
        }
    }

    class ContentHolder extends RecyclerView.ViewHolder{

        private TextView tv_nm,tv_sellPrice,tv_addr,tv_km,tv_seat,tv_goup,tv_snact;
        public ContentHolder(View itemView) {
            super(itemView);
            tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);//电影院名字
            tv_sellPrice = (TextView) itemView.findViewById(R.id.tv_sellPrice);//最低价格
            tv_addr = (TextView) itemView.findViewById(R.id.tv_addr);//位置
            tv_km = (TextView) itemView.findViewById(R.id.tv_km);//距离多远
            tv_seat = (TextView) itemView.findViewById(R.id.tv_seat);//座
            tv_goup = (TextView) itemView.findViewById(R.id.tv_goup);//团
            tv_snact = (TextView) itemView.findViewById(R.id.tv_snact);//小吃
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickLitener!=null) {
                        onItemClickLitener.onItemClick(v,getLayoutPosition());

                    }
                }
            });
        }
    }

    static class cinemaVPAdapter extends PagerAdapter{

        private final Context context;
        private final List<Map<String, Object>> mapList;

        public cinemaVPAdapter(Context context, List<Map<String, Object>> mapList) {
            this.context=context;
            this.mapList=mapList;
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
            int realposition=position%mapList.size();//得到实际的下标
            Map<String, Object> map = mapList.get(realposition);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            Glide.with(context).load(map.get("imgUrl").toString())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.mipmap.lh)//加载过程中的图片
                    .error(R.mipmap.lh)//加载失败的时候显示的图片
                    .into(imageView);//请求成功后把图片设置到的控件

            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private OnItemClickLitener onItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    public interface OnItemClickLitener{
        void onItemClick(View v,int position);
    }

}
