package maoyan.pjs.com.maoyan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.fragment.CinemaFragment;
import maoyan.pjs.com.maoyan.fragment.FindFragment;
import maoyan.pjs.com.maoyan.fragment.MovieFragment;
import maoyan.pjs.com.maoyan.fragment.MyFragment;
import maoyan.pjs.com.maoyan.util.Tools;

public class MainActivity extends FragmentActivity {

    private MainActivity ac;
    private List<BaseFragment> listFragment;
    private FrameLayout top_frameLayout;
    private RadioGroup btm_radiogroup;
    private RadioButton rb_movie;
    private int currentPosition=0;

    public static int screenWidth;
    public static int screenHeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac=this;
        initFind();
        initData();

    }

    private void initFind() {
        top_frameLayout = (FrameLayout)findViewById(R.id.top_frameLayout);
        btm_radiogroup = (RadioGroup)findViewById(R.id.btm_radiogroup);
        rb_movie = (RadioButton)findViewById(R.id.rb_movie);
        btm_radiogroup.check(currentPosition);
        rb_movie.setChecked(true);

        screenWidth = Tools.getScreenWidth(ac);
        screenHeight = Tools.getScreenHeight(ac);
    }

    private void initData() {
        listFragment=new ArrayList<>();
        listFragment.add(new MovieFragment(ac));
        listFragment.add(new CinemaFragment(ac));
        listFragment.add(new FindFragment(ac));
        listFragment.add(new MyFragment(ac));


        btm_radiogroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        setFragment();
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                case R.id.rb_movie:
                    currentPosition=0;
                    break;

                case R.id.rb_cinema:
                    currentPosition=1;
                    break;

                case R.id.rb_find:
                    currentPosition=2;
                    break;

                case R.id.rb_my:
                    currentPosition=3;
                    break;
            }
            setFragment();
        }
    }


    private void setFragment() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.top_frameLayout,new Fragment(){
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                BaseFragment fragment=getFragment();
                if(fragment!=null) {
                    return fragment.rootView;
                }
                return null;
            }
        });
        transaction.commit();
    }

    public BaseFragment getFragment() {
        BaseFragment frament=listFragment.get(currentPosition);
        if(frament!=null) {
            if(!frament.isFragment) {
                frament.isFragment=true;
                frament.initData();
            }
            return frament;
        }
        return null;
    }
    private long mEixtTime;
    @Override
    public void onBackPressed() {

        if(System.currentTimeMillis()-mEixtTime>2000) {
            Toast.makeText(MainActivity.this, "再按一下退出", Toast.LENGTH_SHORT).show();
            mEixtTime= System.currentTimeMillis();
        }else {
            ac.finish();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode==LoginActivity.RESULT_OK){
                    String nickName = data.getStringExtra("nickName");
                    String userIcon = data.getStringExtra("userIcon");
                    Log.i("TAG", "me名字="+nickName);
                    Log.i("TAG", "me头像="+userIcon);
                    MyFragment.tv_nickName.setText(nickName);

                    Glide.with(ac).load(userIcon)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                            .placeholder(R.mipmap.backgroud_logo02)//加载过程中的图片
                            .error(R.mipmap.backgroud_logo02)//加载失败的时候显示的图片
                            .into(MyFragment.iv_icon);//请求成功后把图片设置到的控件
                break;
        }}
    }
}
