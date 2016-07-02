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
import android.widget.RelativeLayout;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ShopTypeActivity;

/**
 * Created by Administrator on 2015/12/1 0001.
 */
public class GoodsClassifyPopWindow extends PopupWindow implements View.OnClickListener {

    private LayoutInflater inflater;
    private ShopTypeActivity ac;
    private TextView id_newupdate_new,id_newupdate_sell,id_newupdate_commission,
            id_newupdate_price,id_newupdate_collection;

    private TextView id_goods_classify_title;
    private ImageView  id_goods_classify_image;
    private int category_id;
    private RelativeLayout goods_classfiy;
    public GoodsClassifyPopWindow(Activity activity,TextView textView,ImageView imageView) {
        super(activity);
        ac=(ShopTypeActivity)activity;
        this.category_id=category_id;
        this.id_goods_classify_title=textView;
        this.id_goods_classify_image=imageView;
        inflater = LayoutInflater.from(ac);
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
        View rootView = LayoutInflater.from(context).inflate(R.layout.goods_classify, null);
        goods_classfiy = (RelativeLayout) rootView.findViewById(R.id.goods_classfiy);



        id_newupdate_new= (TextView) rootView.findViewById(R.id.id_newupdate_new);
        id_newupdate_sell= (TextView) rootView.findViewById(R.id.id_newupdate_sell);
        id_newupdate_commission= (TextView) rootView.findViewById(R.id.id_newupdate_commission);
        id_newupdate_price= (TextView) rootView.findViewById(R.id.id_newupdate_price);
        id_newupdate_collection= (TextView) rootView.findViewById(R.id.id_newupdate_collection);
        //初始话适配器,让选中的那个分类变为红色
        //重置按钮，变为全部分类

        setContentView(rootView);
        //设置背景为透明色
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        setBackgroundDrawable(dw);
        setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        setFocusable(true);
        setTouchable(true);
        rootView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int height = v.findViewById(R.id.goods_classfiy).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y > height) {
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
                id_goods_classify_title.setText("默认排序");
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
                id_goods_classify_title.setText("销售排序");
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
                id_goods_classify_title.setText("佣金排序");
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
                id_goods_classify_title.setText("售价排序");
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
                id_goods_classify_title.setText("收藏排序");
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
