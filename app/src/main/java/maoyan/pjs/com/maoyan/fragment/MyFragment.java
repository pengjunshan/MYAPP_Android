package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ECshopActivity;
import maoyan.pjs.com.maoyan.activity.LoginActivity;
import maoyan.pjs.com.maoyan.activity.MainActivity;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    public static TextView tv_nickName;
    public static ImageView iv_icon;
    private RelativeLayout ecshop,rl_comlogin;
    public MyFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context,R.layout.my,null);
        tv_nickName = (TextView) view.findViewById(R.id.tv_nickName);
        rl_comlogin = (RelativeLayout) view.findViewById(R.id.rl_comlogin);
        iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
        ecshop = (RelativeLayout) view.findViewById(R.id.ecshop);
        rl_comlogin.setOnClickListener(this);
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
                context.startActivity(intent);
                break;
            case R.id.rl_comlogin:
                Log.i("TAG", "点击了");
                intent=new Intent(context, LoginActivity.class);
                ((MainActivity)context).startActivityForResult(intent,1);
                break;
        }
    }
}
