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
public class GoodsUnderwatyPopWindow extends PopupWindow implements View.OnClickListener{

    private ShopTypeActivity ac;
    private TextView id_underwaty_ing,id_underwaty_noing;
    private TextView id_goods_underwaty_title;
    private ImageView id_goods_underwaty_image;
    private int publishType;
    public GoodsUnderwatyPopWindow(Activity activity, TextView textView1, ImageView imageView1) {
        super(activity);
        ac=(ShopTypeActivity)activity;
        this.id_goods_underwaty_title=textView1;
        this.id_goods_underwaty_image=imageView1;
        this.publishType=publishType;
        initView(activity);
        setOnclickListner();
    }

    private void setOnclickListner() {
        id_underwaty_ing.setOnClickListener(this);
        id_underwaty_noing.setOnClickListener(this);
    }

    @SuppressWarnings("deprecation")
    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.goods_underwaty, null);
        id_underwaty_ing= (TextView) rootView.findViewById(R.id.id_underwaty_ing);
        id_underwaty_noing= (TextView) rootView.findViewById(R.id.id_underwaty_noing);
        //根据选中的选项让字体变红
        if (publishType==1){
            id_underwaty_ing.setTextColor(Color.parseColor("#ff6666"));
        }else {
            id_underwaty_noing.setTextColor(Color.parseColor("#ff6666"));
        }
        setContentView(rootView);
        //把背景变成半透明的
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        setBackgroundDrawable(dw);
        setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        setFocusable(true);
        setTouchable(true);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                //popwindow的高度
                int height = v.findViewById(R.id.goods_underwaty_re).getBottom();
                //手指点击的高度
                int y = (int) event.getY();
                //手指点击到下面的透明的地方，就取消掉整个popwindow
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y > height) {
                        //恢复朝下
                        //id_goods_underwaty_title.setTextColor(Color.parseColor("#333333"));
                        //id_goods_underwaty_image.setImageResource(R.mipmap.down_classify_red);
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

            case R.id.id_underwaty_ing:
                id_goods_underwaty_title.setText("超蝙");
                id_underwaty_ing.setTextColor(Color.parseColor("#ff6666"));
                id_underwaty_noing.setTextColor(Color.parseColor("#333333"));
                dismiss();
                break;

            case R.id.id_underwaty_noing:
                id_goods_underwaty_title.setText("机器猫");
                id_underwaty_ing.setTextColor(Color.parseColor("#333333"));
                id_underwaty_noing.setTextColor(Color.parseColor("#ff6666"));
                dismiss();
                break;
        }
    }
}
