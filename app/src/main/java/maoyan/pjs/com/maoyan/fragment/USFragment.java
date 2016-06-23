package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/22.
 */
public class USFragment extends BaseFragment {

    private TextView textView;
    public USFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("USFragment");
    }
}
