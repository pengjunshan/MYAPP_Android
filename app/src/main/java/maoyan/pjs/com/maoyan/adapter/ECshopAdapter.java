package maoyan.pjs.com.maoyan.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ECshopActivity;
import maoyan.pjs.com.maoyan.activity.ShopTypeActivity;
import maoyan.pjs.com.maoyan.activity.WebViewAcitivy;
import maoyan.pjs.com.maoyan.bean.ShopgrideBean;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.SpacesItemDecoration;

/**
 * Created by pjs984312808 on 2016/7/1.
 */
public class ECshopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static Context context;
    private static List<Map<String, Object>> mapList;
    private LayoutInflater inflater;
    private  List<ShopgrideBean.DataBean.ListBean> listBeen;

    public ECshopAdapter(Context context, List<Map<String, Object>> mapList) {
        this.context=context;
        this.mapList=mapList;
        inflater=LayoutInflater.from(context);
        try {
            ShopgrideBean shopgrideBean = new Gson().fromJson(Constant.ecshop_gride, ShopgrideBean.class);
            listBeen = shopgrideBean.getData().getList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0) {
            return new HeardHolder(inflater.inflate(R.layout.item_ecshop_vp,parent,false));
        }else if(viewType==1) {
           return new SaleHolder(inflater.inflate(R.layout.item_ecshop_sale,parent,false));
        }
        else {
            return new LickHolder(inflater.inflate(R.layout.item_ecshop_gride,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HeardHolder) {
            if(mapList!=null&&mapList.size()>0) {
                ((HeardHolder)holder).viewpager.setAdapter(new cinemaVPAdapter(context,mapList));
                //设置显示在最大值的中间
                int centitem = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mapList.size();
                ((HeardHolder)holder).viewpager.setCurrentItem(centitem);
                ECshopActivity.handler.sendEmptyMessageDelayed(0, 3000);
            }
        }else if(getItemViewType(position)==1) {
            if(position==1) {
                ((SaleHolder)holder).tv_title01.setText(Constant.saletitle01[0]);
                ((SaleHolder)holder).tv_title02.setText(Constant.saletitle01[1]);
                ((SaleHolder)holder).tv_title03.setText(Constant.saletitle01[2]);
                Tools.loadImage(context,Constant.saleimg01[0], ((SaleHolder)holder).iv_one);
                Tools.loadImage(context,Constant.saleimg01[1], ((SaleHolder)holder).iv_two);
                Tools.loadImage(context,Constant.saleimg01[2], ((SaleHolder)holder).iv_three);
                ((SaleHolder)holder).ll_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,WebViewAcitivy.class);
                        intent.putExtra("url",Constant.shopOne01);
                        Log.i("TAG", "url******="+Constant.shopOne01);
                        context.startActivity(intent);
                    }
                });
                ((SaleHolder)holder).ll_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,WebViewAcitivy.class);
                        intent.putExtra("url",Constant.shopOne02);
                        context.startActivity(intent);
                    }
                });
                ((SaleHolder)holder).ll_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,WebViewAcitivy.class);
                        intent.putExtra("url",Constant.shopOne03);
                        context.startActivity(intent);
                    }
                });


            }
            if(position==2) {
                ((SaleHolder)holder).tv_title01.setText(Constant.saletitle02[0]);
                ((SaleHolder)holder).tv_title02.setText(Constant.saletitle02[1]);
                ((SaleHolder)holder).tv_title03.setText(Constant.saletitle02[2]);
                Tools.loadImage(context,Constant.saleimg02[0], ((SaleHolder)holder).iv_one);
                Tools.loadImage(context,Constant.saleimg02[1], ((SaleHolder)holder).iv_two);
                Tools.loadImage(context,Constant.saleimg02[2], ((SaleHolder)holder).iv_three);

                ((SaleHolder)holder).ll_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,WebViewAcitivy.class);
                        intent.putExtra("url",Constant.shopTow01);
                        context.startActivity(intent);
                    }
                });
                ((SaleHolder)holder).ll_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,WebViewAcitivy.class);
                        intent.putExtra("url",Constant.shopTow02);
                        context.startActivity(intent);
                    }
                });
                ((SaleHolder)holder).ll_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,WebViewAcitivy.class);
                        intent.putExtra("url",Constant.shopTow03);
                        context.startActivity(intent);
                    }
                });

            }
            if(position==3) {
                ((SaleHolder)holder).tv_title01.setText(Constant.saletitle03[0]);
                ((SaleHolder)holder).tv_title02.setText(Constant.saletitle03[1]);
                ((SaleHolder)holder).tv_title03.setText(Constant.saletitle03[2]);
                Tools.loadImage(context,Constant.saleimg03[0], ((SaleHolder)holder).iv_one);
                Tools.loadImage(context,Constant.saleimg03[1], ((SaleHolder)holder).iv_two);
                Tools.loadImage(context,Constant.saleimg03[2], ((SaleHolder)holder).iv_three);
            }
        }
        else {

        }
    }

    @Override
    public int getItemCount() {
        return listBeen.size()+4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return 0;
        }else if(position==1) {
            return 1;
        }else if(position==2) {
            return 1;
        }else if(position==3) {
            return 1;
        }
        return 4;
    }

    /**
     * gride
     */
    class LickHolder extends RecyclerView.ViewHolder{

        private RecyclerView recyclerview;
        public LickHolder(View itemView) {
            super(itemView);
            recyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview);
            recyclerview.setAdapter(new ShopGrideAdapter(context,listBeen));
            recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            //设置item之间的间隔
            SpacesItemDecoration decoration=new SpacesItemDecoration(Tools.dip2px(context,6));
            recyclerview.addItemDecoration(decoration);
        }
    }

    /**
     * 每月特价
     */
    class SaleHolder extends RecyclerView.ViewHolder{

        private ImageView iv_one,iv_two,iv_three;
        private TextView tv_title01,tv_title02,tv_title03;
        private LinearLayout ll_one,ll_two,ll_three;
        public SaleHolder(View itemView) {
            super(itemView);
            iv_one = (ImageView) itemView.findViewById(R.id.iv_one);
            iv_two = (ImageView) itemView.findViewById(R.id.iv_two);
            iv_three = (ImageView) itemView.findViewById(R.id.iv_three);
            tv_title01 = (TextView) itemView.findViewById(R.id.tv_title01);
            tv_title02 = (TextView) itemView.findViewById(R.id.tv_title02);
            tv_title03 = (TextView) itemView.findViewById(R.id.tv_title03);
            ll_one = (LinearLayout) itemView.findViewById(R.id.ll_one);
            ll_two = (LinearLayout) itemView.findViewById(R.id.ll_two);
            ll_three = (LinearLayout) itemView.findViewById(R.id.ll_three);
        }
    }

    /**
     * 头部viewpager和十个专题
     */
    public static class HeardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public static LinearLayout ll_ecshop01;
        public static ViewPager viewpager;
        private LinearLayout ll_01,ll_02,ll_03,ll_04,ll_05,ll_06,ll_07,ll_08,ll_09,ll_10;
        @TargetApi(Build.VERSION_CODES.M)
        public HeardHolder(View itemView) {
            super(itemView);
            viewpager = (ViewPager) itemView.findViewById(R.id.viewpager);
            ll_ecshop01 = (LinearLayout) itemView.findViewById(R.id.ll_ecshop01);
            ll_01 = (LinearLayout) itemView.findViewById(R.id.ll_01);
            ll_02 = (LinearLayout) itemView.findViewById(R.id.ll_02);
            ll_03 = (LinearLayout) itemView.findViewById(R.id.ll_03);
            ll_04 = (LinearLayout) itemView.findViewById(R.id.ll_04);
            ll_05 = (LinearLayout) itemView.findViewById(R.id.ll_05);
            ll_06 = (LinearLayout) itemView.findViewById(R.id.ll_06);
            ll_07 = (LinearLayout) itemView.findViewById(R.id.ll_07);
            ll_08 = (LinearLayout) itemView.findViewById(R.id.ll_08);
            ll_09 = (LinearLayout) itemView.findViewById(R.id.ll_09);
            ll_10 = (LinearLayout) itemView.findViewById(R.id.ll_10);
            ll_01.setOnClickListener(this);
            ll_02.setOnClickListener(this);
            ll_03.setOnClickListener(this);
            ll_04.setOnClickListener(this);
            ll_05.setOnClickListener(this);
            ll_06.setOnClickListener(this);
            ll_07.setOnClickListener(this);
            ll_08.setOnClickListener(this);
            ll_09.setOnClickListener(this);
            ll_10.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context, ShopTypeActivity.class));
            Tools.showRoundProcessDialog(context);
            switch (v.getId()){
                case R.id.ll_01:
                    HttpUtils.getShopNum(context,Constant.shop01,1);
                    break;
                case R.id.ll_02:
                    HttpUtils.getShopNum(context,Constant.shop02,2);
                    break;
                case R.id.ll_03:
                    HttpUtils.getShopNum(context,Constant.shop03,3);
                    break;
                case R.id.ll_04:
                    HttpUtils.getShopNum(context,Constant.shop04,4);
                    break;
                case R.id.ll_05:
                    HttpUtils.getShopNum(context,Constant.shop05,5);
                    break;
                case R.id.ll_06:
                    HttpUtils.getShopNum(context,Constant.shop06,6);
                    break;
                case R.id.ll_07:
                    HttpUtils.getShopNum(context,Constant.shop07,7);
                    break;
                case R.id.ll_08:
                    HttpUtils.getShopNum(context,Constant.shop08,8);
                    break;
                case R.id.ll_09:
                    HttpUtils.getShopNum(context,Constant.shop09,9);
                    break;
                case R.id.ll_10:
                    HttpUtils.getShopNum(context,Constant.shop10,10);
                    break;

            }
        }
    }

    /**
     * veiwpager适配器
     */
    static class cinemaVPAdapter extends PagerAdapter {

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
            Tools.loadImage(context,map.get("imgUrl").toString(),imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class ShopGrideAdapter extends RecyclerView.Adapter<ShopGrideAdapter.ShopGriHolder>{


        private final Context context;
        private final List<ShopgrideBean.DataBean.ListBean> listData;

        public ShopGrideAdapter(Context context, List<ShopgrideBean.DataBean.ListBean> listBeen) {
            this.context=context;
            this.listData=listBeen;
            initData();
        }
        private List<Integer> random;
        private void initData() {
            random=new ArrayList<>();
            for (int i=0; i<listData.size();i++){
                random.add((int) (200+Math.random()*200));
            }
        }

        @Override
        public ShopGriHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ShopGriHolder(inflater.inflate(R.layout.item_ecshop_lick,parent,false));
        }

        @Override
        public void onBindViewHolder(ShopGriHolder holder, int position) {

            ViewGroup.LayoutParams layoutParams = holder.iv_icon.getLayoutParams();
            layoutParams.height=random.get(position);
            holder.iv_icon.setLayoutParams(layoutParams);

            ShopgrideBean.DataBean.ListBean listBean = listData.get(position);
            holder.tv_title.setText(listBean.getTitle());
            holder.tv_price.setText(listBean.getPrice()+"");
            holder.tv_value.setText(listBean.getValue()+"元");
            Tools.loadImage(context,listBean.getPic(), holder.iv_icon);
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }

        class ShopGriHolder extends RecyclerView.ViewHolder{
            private ImageView iv_icon;
            private TextView tv_title,tv_price,tv_value;
            public ShopGriHolder(View itemView) {
                super(itemView);
                iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
                tv_title = (TextView) itemView.findViewById(R.id.tv_title);
                tv_price = (TextView) itemView.findViewById(R.id.tv_price);
                tv_value = (TextView) itemView.findViewById(R.id.tv_value);
                tv_value.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        }
    }
}
