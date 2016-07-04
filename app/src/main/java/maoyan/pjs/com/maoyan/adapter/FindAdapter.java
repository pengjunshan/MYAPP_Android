package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.WebViewAcitivy;
import maoyan.pjs.com.maoyan.bean.FindListBean;
import maoyan.pjs.com.maoyan.fragment.FindFragment;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static  Context context;
    private LayoutInflater inflater;
    private static List<Map<String, Object>> VPData;
    private List<Map<String, Object>> RbmapList;
    private List<FindListBean.DataBean.FeedsBean> feedList;

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
        }else if(viewType==2) {

        }else if(viewType==3) {
            return new TwoHolder(inflater.inflate(R.layout.item_find_two,parent,false));
        }else if(viewType==4) {

        }else if(viewType==5) {
            return new FourHolder(inflater.inflate(R.layout.item_find_four,parent,false));
        }else if(viewType==6) {

        }else if(viewType==7) {

        }else if(viewType==8) {
            return new SevenHolder(inflater.inflate(R.layout.item_find_seven,parent,false));
        }else if(viewType==9) {
            return new EightHolder(inflater.inflate(R.layout.item_find_eight,parent,false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof EightHolder) {
            if(feedList!=null&&feedList.size()>0) {
                FindListBean.DataBean.FeedsBean feedsBean = feedList.get(position-2);
                if( feedsBean.getFeedType()==8) {


                ((EightHolder)holder).tv_title.setText(feedsBean.getTitle());
                ((EightHolder)holder).tv_viewCount.setText(feedsBean.getViewCount()+"");
                List<FindListBean.DataBean.FeedsBean.ImagesBean> images = feedsBean.getImages();

                Glide.with(context).load(images.get(0).getUrl().toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(((EightHolder)holder).iv_left);//请求成功后把图片设置到的控件


                Glide.with(context).load(images.get(1).getUrl().toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(((EightHolder)holder).iv_righttop);//请求成功后把图片设置到的控件


                Glide.with(context).load(images.get(2).getUrl().toString())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                        .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                        .into(((EightHolder)holder).iv_rightbom);//请求成功后把图片设置到的控件

            }
            }
        }else if(holder instanceof FourHolder) {
            if(feedList!=null&&feedList.size()>0) {
                FindListBean.DataBean.FeedsBean feedsBean = feedList.get(position-2);
               if( feedsBean.getFeedType()==4) {
                   ((FourHolder)holder).tv_title.setText(feedsBean.getTitle());
                   FindListBean.DataBean.FeedsBean.UserBean userBean = feedsBean.getUser();
                   ((FourHolder)holder).tv_nickName.setText(userBean.getNickName());
                   ((FourHolder)holder).tv_viewCount.setText(feedsBean.getViewCount()+"");
                   List<FindListBean.DataBean.FeedsBean.ImagesBean> imagesBeen = feedsBean.getImages();

                   Glide.with(context).load(imagesBeen.get(0).getUrl().toString())
                           .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                           .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                           .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                           .into(((FourHolder)holder).iv_icon);//请求成功后把图片设置到的控件

               }
            }
        }else if(holder instanceof SevenHolder) {
            if(feedList!=null&&feedList.size()>0) {
                FindListBean.DataBean.FeedsBean feedsBean = feedList.get(position-2);
                if (feedsBean.getFeedType() == 7) {
                    ((SevenHolder)holder).tv_title.setText(feedsBean.getTitle());
                    FindListBean.DataBean.FeedsBean.UserBean userBean = feedsBean.getUser();
                    ((SevenHolder)holder).tv_nickName.setText(userBean.getNickName());
                    ((SevenHolder)holder).tv_viewCount.setText(feedsBean.getViewCount()+"");
                    List<FindListBean.DataBean.FeedsBean.ImagesBean> imagesBeen = feedsBean.getImages();

                    Glide.with(context).load(imagesBeen.get(0).getUrl().toString())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                            .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                            .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                            .into(((SevenHolder)holder).iv_icon);//请求成功后把图片设置到的控件
                }
            }
        }else if(getItemViewType(position)==3) {
            FindListBean.DataBean.FeedsBean feedsBean = feedList.get(position-2);
            ((TwoHolder)holder).tv_title.setText(feedsBean.getTitle());
            FindListBean.DataBean.FeedsBean.UserBean userBean = feedsBean.getUser();
            ((TwoHolder)holder).tv_nickName.setText(userBean.getNickName());
            ((TwoHolder)holder).tv_viewCount.setText(feedsBean.getViewCount()+"");
            List<FindListBean.DataBean.FeedsBean.ImagesBean> imagesBeen = feedsBean.getImages();

            Glide.with(context).load(imagesBeen.get(0).getUrl().toString())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                    .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                    .into(((TwoHolder)holder).iv_image1);//请求成功后把图片设置到的控件

            Glide.with(context).load(imagesBeen.get(1).getUrl().toString())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                    .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                    .into(((TwoHolder)holder).iv_image2);//请求成功后把图片设置到的控件

            Glide.with(context).load(imagesBeen.get(0).getUrl().toString())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                    .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                    .into(((TwoHolder)holder).iv_image3);//请求成功后把图片设置到的控件

        }

    }

    @Override
    public int getItemCount() {
        if(feedList!=null&&feedList.size()>0) {
         return feedList.size()+2;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return 0;
        }else if(position==1) {
            return 1;
        }else if(feedList.get(position-2).getFeedType()==1) {
            return 2;
        }else if(feedList.get(position-2).getFeedType()==2) {
            return 3;
        }else if(feedList.get(position-2).getFeedType()==3) {
            return 4;
        }else if(feedList.get(position-2).getFeedType()==4) {
            return 5;
        }else if(feedList.get(position-2).getFeedType()==5) {
            return 6;
        }else if(feedList.get(position-2).getFeedType()==6) {
            return 7;
        }else if(feedList.get(position-2).getFeedType()==7) {
            return 8;
        }else if(feedList.get(position-2).getFeedType()==8) {
            return 9;
        }

        return 100;
    }

    public void setVPData(List<Map<String, Object>> VPData) {
        this.VPData = VPData;
        notifyItemRangeChanged(0,1);
    }

    public void setRBData(List<Map<String, Object>> RbmapList) {
        this.RbmapList=RbmapList;
        notifyItemRangeChanged(1,2);
    }

    public void setListData(List<FindListBean.DataBean.FeedsBean> feedList) {
        this.feedList=feedList;
        notifyItemRangeChanged(3,feedList.size());
    }

    /**
     * 头部viewpager的Holder
     */
    public static class FindVPHolder extends RecyclerView.ViewHolder{

        public static ViewPager viewpager;
        public static LinearLayout ll_point;
        private int currentPoint;
        public FindVPHolder(View itemView) {
            super(itemView);
            viewpager = (ViewPager) itemView.findViewById(R.id.viewpager);
            ll_point = (LinearLayout) itemView.findViewById(R.id.ll_point);
            if(VPData!=null&&VPData.size()>0) {
                viewpager.setAdapter(new VPAdapter(context,VPData));
                //设置显示在最大值的中间
                int centitem = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % VPData.size();
                viewpager.setCurrentItem(centitem);
                for (int i = 0; i <VPData.size(); i++) {
                    ImageView point =new ImageView(context);
                    point.setBackgroundResource(R.drawable.findpoint);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Tools.dip2px(context,6),Tools.dip2px(context,6));
                    if(i==0) {
                        point.setEnabled(true);
                    }else {
                        point.setEnabled(false);
                        params.leftMargin=Tools.dip2px(context,10);
                    }
                    point.setLayoutParams(params);
                    ll_point.addView(point);
                }
                viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
                FindFragment.handler.sendEmptyMessageDelayed(1, 3000);
            }


        }

        class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int realposition=position%VPData.size();
                //设置上一个点的enable为false
                //ll_group_point.getChildAt(position) --->ImageView
                ll_point.getChildAt(currentPoint).setEnabled(false);
                //设置当前点的enable为true
                ll_point.getChildAt(realposition).setEnabled(true);
                //把当前的值赋值给
                currentPoint=realposition;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }
    }

    /**
     * 发现下部分type8的Holder
     */
    class EightHolder extends RecyclerView.ViewHolder{

        private TextView tv_title,tv_viewCount;
        private ImageView iv_left,iv_righttop,iv_rightbom;
        public EightHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_viewCount = (TextView) itemView.findViewById(R.id.tv_viewCount);
            iv_left = (ImageView) itemView.findViewById(R.id.iv_left);
            iv_righttop = (ImageView) itemView.findViewById(R.id.iv_righttop);
            iv_rightbom = (ImageView) itemView.findViewById(R.id.iv_rightbom);
        }
    }

    /**
     * 发现下部分type4的Holder
     */
    class FourHolder extends RecyclerView.ViewHolder{

        private ImageView iv_icon;
        private TextView tv_title,tv_nickName,tv_viewCount;
        public FourHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_nickName = (TextView) itemView.findViewById(R.id.tv_nickName);
            tv_viewCount = (TextView) itemView.findViewById(R.id.tv_viewCount);
        }
    }

    /**
     * 发现下部分type7的Holder
     */
    class SevenHolder extends RecyclerView.ViewHolder{

        private ImageView iv_icon;
        private TextView tv_title,tv_nickName,tv_viewCount;
        public SevenHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_nickName = (TextView) itemView.findViewById(R.id.tv_nickName);
            tv_viewCount = (TextView) itemView.findViewById(R.id.tv_viewCount);
        }
    }

    /**
     * 发现下部分type2的Holder
     */
    class TwoHolder extends RecyclerView.ViewHolder{

        private TextView tv_title,tv_nickName,tv_viewCount;
        private ImageView iv_image1,iv_image2,iv_image3;
        public TwoHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_nickName = (TextView) itemView.findViewById(R.id.tv_nickName);
            tv_viewCount = (TextView) itemView.findViewById(R.id.tv_viewCount);
            iv_image1 = (ImageView) itemView.findViewById(R.id.iv_image1);
            iv_image2 = (ImageView) itemView.findViewById(R.id.iv_image2);
            iv_image3 = (ImageView) itemView.findViewById(R.id.iv_image3);

        }
    }

    /**
     * 头部RadioButton的Holder
     */
    class FindRadioButtn extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView iv_topic,iv_information,iv_movielib,iv_boxoffice;
        private TextView tv_topic,tv_information,tv_movielib,tv_boxoffice;
        private LinearLayout ll_topic,ll_information,ll_movielib,ll_boxoffice;

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

            ll_topic = (LinearLayout) itemView.findViewById(R.id.ll_topic);
            ll_information = (LinearLayout) itemView.findViewById(R.id.ll_information);
            ll_movielib = (LinearLayout) itemView.findViewById(R.id.ll_movielib);
            ll_boxoffice = (LinearLayout) itemView.findViewById(R.id.ll_boxoffice);

            ll_topic.setOnClickListener(this);
            ll_information.setOnClickListener(this);
            ll_movielib.setOnClickListener(this);
            ll_boxoffice.setOnClickListener(this);

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

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, WebViewAcitivy.class);
            Tools.showRoundProcessDialog(context);
            switch (v.getId()){
                case R.id.ll_topic://话题
                    intent.putExtra("url", Constant.FindTopic);
                    break;

                case R.id.ll_information://资讯
                    intent.putExtra("url", Constant.FindInformation);
                    break;

                case R.id.ll_movielib://影库
                    Toast.makeText(context, "影库", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.ll_boxoffice://票房
                    intent.putExtra("url",Constant.FindBoxoffice);
                    break;
            }
            context.startActivity(intent);
        }
    }




    static class VPAdapter extends PagerAdapter{

        private final Context context;
        private final List<Map<String, Object>> vpData;

        public VPAdapter(Context context, List<Map<String, Object>> vpData) {
            this.context=context;
            this.vpData=vpData;
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
            int realposition=position%vpData.size();//得到实际的下标
            Map<String, Object> map = vpData.get(realposition);
            ImageView imageView=new ImageView(context);
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


}
