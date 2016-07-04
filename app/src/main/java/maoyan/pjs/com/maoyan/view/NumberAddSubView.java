package maoyan.pjs.com.maoyan.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/14.
 */
public class NumberAddSubView extends LinearLayout implements View.OnClickListener {

    private Button btn_sub,btn_add;
    private TextView tv_num;
    private Context context;

    private int value=1;
    private int minValue=1;
    public static int maxValue=10;

    public int getValue() {
       String val=tv_num.getText().toString();
        if(!TextUtils.isEmpty(val)) {
            value=Integer.parseInt(val);
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        tv_num.setText(value+"");
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public NumberAddSubView(Context context) {
        this(context,null);
    }

    public NumberAddSubView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NumberAddSubView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;

        initView(context);
    }

    private void initView(Context context) {
        //把当前view添加到这个上下文中
        View.inflate(context, R.layout.number_addsub,this);
        btn_sub = (Button)findViewById(R.id.btn_sub);
        btn_add = (Button)findViewById(R.id.btn_add);
        tv_num = (TextView)findViewById(R.id.tv_num);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_sub://减少
                subNumber();
                if(onAddSubClickListener!=null) {
                    onAddSubClickListener.onAddClick(v,value);
                }
                break;

            case R.id.btn_add://增加
                addNumber();
                if(onAddSubClickListener!=null) {
                    onAddSubClickListener.onSubClick(v,value);
                }
                break;
        }

    }

    private void addNumber() {
        if(value<maxValue) {
            value=value+1;
            setValue(value);

        }

    }

    private void subNumber() {
        if(value>minValue) {
            value=value-1;
            setValue(value);
        }

    }

    public interface OnAddSubClickListener{

        void onAddClick(View v, int value);

        void onSubClick(View v, int value);
    }

    private OnAddSubClickListener onAddSubClickListener;

    public void setOnAddSubClickListener(OnAddSubClickListener onAddSubClickListener) {
        this.onAddSubClickListener = onAddSubClickListener;
    }
}
