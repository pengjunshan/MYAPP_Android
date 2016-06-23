package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 * 电影 海外
 */
public class OverseasFragment extends BaseFragment {

    private ViewPager fl_viewpager;
    private TabLayout overseas_topictile;

    private String[] mTitle=new String[]{"美国","韩国","日本"};

    private List<BaseFragment> fragmentList;

    private int currentViewPager=0;

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
        Log.i("TAG", "OverseasFragment");
        init();
    }

    private void init() {
        fragmentList=new ArrayList<>();
        fragmentList.add(new USFragment(context));
        fragmentList.add(new KRFragmnet(context));
        fragmentList.add(new JPFragment(context));

        //关联viewpagetr 适配器
        fl_viewpager.setAdapter(new MyViewPagerAdapter());

        //关联toblayout 和viewpager
        overseas_topictile.setupWithViewPager(fl_viewpager);

        //设置模式
//        overseas_topictile.setTabMode(TabLayout.MODE_SCROLLABLE);

        //设置默认第一个
        fl_viewpager.setCurrentItem(currentViewPager);
        fragmentList.get(currentViewPager).initData();

        //监听tablayou改变
        overseas_topictile.setOnTabSelectedListener(new MyOnTabSelectedListener());

        //监听viewpager改变
        fl_viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            fragmentList.get(position).initData();
            currentViewPager=position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            fl_viewpager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }

        @Override
        public int getCount() {
            return mTitle.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BaseFragment fragment = fragmentList.get(position);
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
