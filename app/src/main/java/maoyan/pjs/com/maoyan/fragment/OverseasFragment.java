package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.base.BaseFragment;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 海外
 */
public class OverseasFragment extends BaseFragment {

    public static ViewPager fl_viewpager;
    public static TabLayout overseas_topictile;
    public static List<Map<String,Object>> mapList = new ArrayList<>();

    public static List<BaseFragment> fragmentList;

    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    setTabViewPager();
                    break;
            }
        }
    };

    public OverseasFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.movie_overseas, null);
        fl_viewpager = (ViewPager) view.findViewById(R.id.fl_viewpager);
        overseas_topictile = (TabLayout) view.findViewById(R.id.overseas_topictile);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        /**
         * 请求国家名称
         */
        HttpUtils.getCountryData(Constant.CountryUrl);
        init();
    }

    private void init() {
        fragmentList=new ArrayList<>();
        fragmentList.add(new USFragment(context));
        fragmentList.add(new KRFragmnet(context));
        fragmentList.add(new JPFragment(context));
        setTabViewPager();
    }

    private static void setTabViewPager() {
        //关联viewpagetr 适配器
        fl_viewpager.setAdapter(new MyViewPagerAdapter());

        //关联toblayout 和viewpager
        overseas_topictile.setupWithViewPager(fl_viewpager);

        //设置默认第一个
        HttpUtils.getUSData(Constant.USUrl,context);
        fl_viewpager.setCurrentItem(0,false);
        fragmentList.get(0).initData();

        //监听tablayou改变
        overseas_topictile.setOnTabSelectedListener(new MyOnTabSelectedListener());

        //监听viewpager改变
        fl_viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
    }

   static class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            fragmentList.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

   static class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            fl_viewpager.setCurrentItem(tab.getPosition());
            switch (tab.getPosition()){
                case 0://联网请求美国数据
                    HttpUtils.getUSData(Constant.USUrl,context);
                    Tools.showRoundProcessDialog(context);
                    break;

                case 1://联网请求韩国数据
                    HttpUtils.getKRData(Constant.KRUrl,context);
                    Tools.showRoundProcessDialog(context);
                    break;

                case 2://联网请求日本数据
                    HttpUtils.getJPSData(Constant.JPUrl,context);
                    Tools.showRoundProcessDialog(context);
                    break;

            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

   static class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public CharSequence getPageTitle(int position) {
            return (CharSequence) mapList.get(position).get("name");
        }

        @Override
        public int getCount() {
            return mapList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BaseFragment fragment = fragmentList.get(position);
//            fragment.initData();
            View view = fragment.rootView;
            //把布局添加进viewpager
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
