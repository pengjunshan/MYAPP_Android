package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ShopDetailsActivity;
import maoyan.pjs.com.maoyan.bean.ECshopBean;
import maoyan.pjs.com.maoyan.util.CartProvider;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/7/1.
 */


public class ShopTypeAdapter extends RecyclerView.Adapter<ShopTypeAdapter.ContentHolder> {
    private final Context context;
    public static  List<ECshopBean.DataBean.ListBean> listData;
    private List<Integer> random = new ArrayList<>();
    public static CartProvider cartProvider;

    public ShopTypeAdapter(Context ac, List<ECshopBean.DataBean.ListBean> listData) {
        this.context=ac;
        this.listData=listData;
        cartProvider=new CartProvider(context);
        random.clear();
        initData();
    }

    @Override
    public ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shoptype,parent,false);
        return new ContentHolder(view);
    }

    private void initData() {
        random=new ArrayList<>();
        for (int i=0; i<listData.size();i++){
            random.add((int) (200+Math.random()*200));
        }
    }

    @Override
    public void onBindViewHolder(ContentHolder holder, int position) {

        ViewGroup.LayoutParams layoutParams = holder.iv_icon.getLayoutParams();
        layoutParams.height=random.get(position);
        holder.iv_icon.setLayoutParams(layoutParams);

        ECshopBean.DataBean.ListBean listBean = listData.get(position);
        holder.tv_title.setText(listBean.getTitle());
        holder.tv_price.setText(listBean.getPrice()+"");
        holder.tv_value.setText(listBean.getValue()+"元");
        Tools.loadImage(context,listBean.getPic(),holder.iv_icon);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ContentHolder extends RecyclerView.ViewHolder{
        private ImageView iv_icon,iv_bay;
        private TextView tv_title,tv_price,tv_value;
        public ContentHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_value = (TextView) itemView.findViewById(R.id.tv_value);
            tv_value.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//            iv_bay = (ImageView) itemView.findViewById(R.id.iv_bay);

           /* iv_bay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //1.得到当前物品的对象
                    ECshopBean.DataBean.ListBean listBean = listData.get(getLayoutPosition()-1);
                    //2.转换成CartProvider对象
                    ShoppingCart cart = cartProvider.conversion(listBean);
                    //3.把CartProvider保存到
                    cartProvider.putCart(cart);
                }
            });*/

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, ShopDetailsActivity.class);
                    ECshopBean.DataBean.ListBean listBean = listData.get(getLayoutPosition()-1);
                    intent.putExtra("imgurl",listBean.getPic());
                    intent.putExtra("title",listBean.getTitle());
                    intent.putExtra("dealid",listBean.getDealid());
                    intent.putExtra("position",getLayoutPosition()-1);
                    context.startActivity(intent);
                }
            });

        }
    }

}
