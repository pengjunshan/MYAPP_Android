package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Iterator;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.ShoppingCart;
import maoyan.pjs.com.maoyan.util.CartProvider;
import maoyan.pjs.com.maoyan.view.NumberAddSubView;

/**
 * Created by pjs984312808 on 2016/6/15.
 */
public class PayShopAdapter extends RecyclerView.Adapter<PayShopAdapter.MyViewHolder> {

    private final Context context;
    private final CheckBox checkboxall;
    private List<ShoppingCart> payDatas;
    private final TextView totalprice;
    private CartProvider cartProvider;

    public PayShopAdapter(Context context, List<ShoppingCart> payDatas, TextView totalprice, CheckBox checkbox_all) {
        this.context = context;
        this.payDatas = payDatas;
        this.totalprice = totalprice;
        this.checkboxall = checkbox_all;
        cartProvider = new CartProvider(context);

        totalPrice();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_paypager, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ShoppingCart shoppingCart = payDatas.get(position);

        holder.checkbox.setChecked(shoppingCart.isChecked());
        holder.tv_name.setText(shoppingCart.getTitle());
        holder.tv_price.setText(shoppingCart.getPrice() + "");

        int count = shoppingCart.getCount();
        if (count > NumberAddSubView.maxValue) {
            count = NumberAddSubView.maxValue;
        }
        holder.numberAddSubView.setValue(count);

        //使用Glide请求图片
        Glide.with(context).load(shoppingCart.getPic())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                .into(holder.iv_icon);//请求成功后把图片设置到的控件


        /**
         * 实现加减的接口
         */
        holder.numberAddSubView.setOnAddSubClickListener(new NumberAddSubView.OnAddSubClickListener() {
            //加
            @Override
            public void onAddClick(View v, int value) {
                shoppingCart.setCount(value);
                cartProvider.upData(shoppingCart);
                totalPrice();
                notifyItemChanged(position);
            }

            //减
            @Override
            public void onSubClick(View v, int value) {
                shoppingCart.setCount(value);
                cartProvider.upData(shoppingCart);
                totalPrice();
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return payDatas.size();
    }

    /**
     * 设置全部的checkBox是否选中
     *
     * @param checked
     */
    public void setCheckBoxAll(boolean checked) {
        if (payDatas != null && payDatas.size() > 0) {
            for (int i = 0; i < payDatas.size(); i++) {
                payDatas.get(i).setChecked(checked);
            }
            totalPrice();
            notifyItemRangeChanged(0, payDatas.size());
        }
    }

    /**
     * 设置某条Item是否选中
     *
     * @param position
     */
    public void setItemisCheck(int position, boolean isCheck) {
        payDatas.get(position).setChecked(isCheck);
        totalPrice();
        int num = 0;
        if (payDatas != null && payDatas.size() > 0) {

            for (int i = 0; i < payDatas.size(); i++) {
                ShoppingCart cart = payDatas.get(i);
                //只要有一个没有被选中就把全选设置为未勾选
                if (!cart.isChecked()) {
                    checkboxall.setChecked(false);
                } else {
                    num += 1;
                }
            }
            /**
             * 当选中的个数和集合相等时设置全选
             */
            if (payDatas.size() == num) {
                checkboxall.setChecked(true);
            }
        }
//        checkboxall.setChecked(checkboxall.isChecked());

        notifyItemChanged(position);

    }


    /**
     * 计算所有的商品价格总价
     */
    private void totalPrice() {
        if (payDatas != null && payDatas.size() > 0) {
            double totalPrice = 0;
            for (int i = 0; i < payDatas.size(); i++) {
                if (payDatas.get(i).isChecked()) {
                    totalPrice = totalPrice + payDatas.get(i).getPrice() * payDatas.get(i).getCount();
                }
            }
            totalprice.setText("¥" + totalPrice);
        }
    }

    /**
     * 删除数据
     */
    public void deleteData() {
        if (payDatas != null && payDatas.size() > 0) {
            for (Iterator iterator = payDatas.iterator(); iterator.hasNext(); ) {
                ShoppingCart cart = (ShoppingCart) iterator.next();
                if (cart.isChecked()) {
                    int position = payDatas.indexOf(cart);
                    iterator.remove();//移除数据
                    //不要再移除了 否则会报错
//                    payDatas.remove(position);
                    cartProvider.deletData(cart);
                    totalPrice();
                    notifyItemRemoved(position);//当移除的时候用这个刷新
                }
            }

        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkbox;
        private ImageView iv_icon;
        private TextView tv_name, tv_price;
        private NumberAddSubView numberAddSubView;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            numberAddSubView = (NumberAddSubView) itemView.findViewById(R.id.numberAddSubView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, getLayoutPosition());
                    }
                }
            });
        }
    }

    /**
     * 点击item的接口
     */
    public interface OnItemClickListener {

        void onItemClick(View v, int layoutPosition);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
