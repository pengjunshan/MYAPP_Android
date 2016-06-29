package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class MyFragment extends BaseFragment {

    public MyFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context,R.layout.my,null);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i("TAG", "MyFragment");
    }
}
