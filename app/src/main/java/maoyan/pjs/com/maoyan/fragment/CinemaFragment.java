package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class CinemaFragment extends BaseFragment {

    private TextView textView;
    public CinemaFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView=new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("CinemaFragment");
        Log.i("TAG", "CinemaFragment");
    }
}
