package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ECshopActivity;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout ecshop;
    public MyFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context,R.layout.my,null);
        ecshop = (RelativeLayout) view.findViewById(R.id.ecshop);
        ecshop.setOnClickListener(this);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i("TAG", "MyFragment");
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.ecshop:
                Tools.showRoundProcessDialog(context);
                intent=new Intent(context, ECshopActivity.class);
                break;
        }
     context.startActivity(intent);
    }
}
