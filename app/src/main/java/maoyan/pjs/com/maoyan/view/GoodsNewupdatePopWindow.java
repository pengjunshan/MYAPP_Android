package maoyan.pjs.com.maoyan.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ShopTypeActivity;

/**
 * Created by Administrator on 2015/12/1 0001.
 */
public class GoodsNewupdatePopWindow extends PopupWindow implements View.OnClickListener{

    private ShopTypeActivity ac;
    private TextView id_goods_newupdate_title,id_newupdate_new,id_newupdate_sell,id_newupdate_commission,
            id_newupdate_price,id_newupdate_collection;
    private ImageView id_goods_newupdate_image;
    private String orderBy;

    public GoodsNewupdatePopWindow(Activity activity,TextView textView,ImageView imageView) {
        super(activity);
        ac=(ShopTypeActivity)activity;
        this.id_goods_newupdate_title=textView;
        this.id_goods_newupdate_image=imageView;
        this.orderBy=orderBy;
        initView(activity);
        setOnclickListner();
    }

    private void setOnclickListner() {
        id_newupdate_new.setOnClickListener(this);
        id_newupdate_sell.setOnClickListener(this);
        id_newupdate_commission.setOnClickListener(this);
        id_newupdate_price.setOnClickListener(this);
        id_newupdate_collection.setOnClickListener(this);
    }
    @SuppressWarnings("deprecation")
    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.goods_newupdate, null);
        id_newupdate_new= (TextView) rootView.findViewById(R.id.id_newupdate_new);
        id_newupdate_sell= (TextView) rootView.findViewById(R.id.id_newupdate_sell);
        id_newupdate_commission= (TextView) rootView.findViewById(R.id.id_newupdate_commission);
        id_newupdate_price= (TextView) rootView.findViewById(R.id.id_newupdate_price);
        id_newupdate_collection= (TextView) rootView.findViewById(R.id.id_newupdate_collection);
        if ("new".equals(orderBy)){
            id_newupdate_new.setTextColor(Color.parseColor("#ff6666"));
        }else if ("csale".equals(orderBy)){
            id_newupdate_sell.setTextColor(Color.parseColor("#ff6666"));
        }else if("commision".equals(orderBy)){
            id_newupdate_commission.setTextColor(Color.parseColor("#ff6666"));
        }else if("price".equals(orderBy)){
            id_newupdate_price.setTextColor(Color.parseColor("#ff6666"));
        }else {
            id_newupdate_collection.setTextColor(Color.parseColor("#ff6666"));
        }
        setContentView(rootView);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        setBackgroundDrawable(dw);
        setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        setFocusable(true);
        setTouchable(true);
        rootView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = v.findViewById(R.id.goods_newupdate_re).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y > height) {
                        //id_goods_newupdate_title.setTextColor(Color.parseColor("#333333"));
                        //id_goods_newupdate_image.setImageResource(R.mipmap.down_classify_red);
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.id_newupdate_new:
                id_goods_newupdate_title.setText("数码");
                //id_goods_newupdate_title.setTextColor(Color.parseColor("#333333"));
                id_newupdate_new.setTextColor(Color.parseColor("#ff6666"));
                id_newupdate_sell.setTextColor(Color.parseColor("#333333"));
                id_newupdate_commission.setTextColor(Color.parseColor("#333333"));
                id_newupdate_price.setTextColor(Color.parseColor("#333333"));
                id_newupdate_collection.setTextColor(Color.parseColor("#333333"));
                //id_goods_newupdate_image.setImageResource(R.mipmap.down_classify_red);
//                ac.setOrderBy("new");
//                ac.initData(Constant.INITTYPE);
                dismiss();
                break;

            case R.id.id_newupdate_sell:
                id_goods_newupdate_title.setText("高玩专区");
                //id_goods_newupdate_title.setTextColor(Color.parseColor("#333333"));
                id_newupdate_new.setTextColor(Color.parseColor("#333333"));
                id_newupdate_sell.setTextColor(Color.parseColor("#ff6666"));
                id_newupdate_commission.setTextColor(Color.parseColor("#333333"));
                id_newupdate_price.setTextColor(Color.parseColor("#333333"));
                id_newupdate_collection.setTextColor(Color.parseColor("#333333"));
                //id_goods_newupdate_image.setImageResource(R.mipmap.down_classify_red);
//                ac.setOrderBy("csale");
//                ac.initData(Constant.INITTYPE);
                dismiss();
                break;

            case R.id.id_newupdate_commission:
                id_goods_newupdate_title.setText("玩具");
                //id_goods_newupdate_title.setTextColor(Color.parseColor("#333333"));
                id_newupdate_new.setTextColor(Color.parseColor("#333333"));
                id_newupdate_sell.setTextColor(Color.parseColor("#333333"));
                id_newupdate_commission.setTextColor(Color.parseColor("#ff6666"));
                id_newupdate_price.setTextColor(Color.parseColor("#333333"));
                id_newupdate_collection.setTextColor(Color.parseColor("#333333"));
                //id_goods_newupdate_image.setImageResource(R.mipmap.down_classify_red);
//                ac.setOrderBy("commision");
//                ac.initData(Constant.INITTYPE);
                dismiss();
                break;

            case R.id.id_newupdate_price:
                id_goods_newupdate_title.setText("生活");
                //id_goods_newupdate_title.setTextColor(Color.parseColor("#333333"));
                id_newupdate_new.setTextColor(Color.parseColor("#333333"));
                id_newupdate_sell.setTextColor(Color.parseColor("#333333"));
                id_newupdate_commission.setTextColor(Color.parseColor("#333333"));
                id_newupdate_price.setTextColor(Color.parseColor("#ff6666"));
                id_newupdate_collection.setTextColor(Color.parseColor("#333333"));
                //id_goods_newupdate_image.setImageResource(R.mipmap.down_classify_red);
//                ac.setOrderBy("price");
//                ac.initData(Constant.INITTYPE);
                dismiss();
                break;

            case R.id.id_newupdate_collection:
                id_goods_newupdate_title.setText("服饰");
                //id_goods_newupdate_title.setTextColor(Color.parseColor("#333333"));
                id_newupdate_new.setTextColor(Color.parseColor("#333333"));
                id_newupdate_sell.setTextColor(Color.parseColor("#333333"));
                id_newupdate_commission.setTextColor(Color.parseColor("#333333"));
                id_newupdate_price.setTextColor(Color.parseColor("#333333"));
                id_newupdate_collection.setTextColor(Color.parseColor("#ff6666"));
                //id_goods_newupdate_image.setImageResource(R.mipmap.down_classify_red);
//                ac.setOrderBy("distribution");
//                ac.initData(Constant.INITTYPE);
                dismiss();
                break;
        }
    }
}
