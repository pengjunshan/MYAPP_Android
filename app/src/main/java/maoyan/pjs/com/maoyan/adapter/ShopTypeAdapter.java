package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.ECshopBean;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/7/1.
 */
public class ShopTypeAdapter extends RecyclerView.Adapter<ShopTypeAdapter.ContentHolder> {
    private final Context context;
    private final List<ECshopBean.DataBean.ListBean> listData;


    public ShopTypeAdapter(Context ac, List<ECshopBean.DataBean.ListBean> listData) {
        this.context=ac;
        this.listData=listData;
    }

    @Override
    public ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_shoptype, null);
        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentHolder holder, int position) {
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
        private ImageView iv_icon;
        private TextView tv_title,tv_price,tv_value;
        public ContentHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_value = (TextView) itemView.findViewById(R.id.tv_value);
            tv_value.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}
