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
 */
public class MovieFragment extends BaseFragment {

    private TabLayout movie_topictile;
    private String[] mTitle = new String[]{"热映", "待映", "海外"};

    private ViewPager movie_topicViewpager;
    
    private List<BaseFragment> listFragment;


    public MovieFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view=View.inflate(context, R.layout.moviefragment,null);
        movie_topictile = (TabLayout) view.findViewById(R.id.movie_topictile);
        movie_topicViewpager = (ViewPager) view.findViewById(R.id.movie_topicViewpager);
        return view;
    }


    @Override
    public void initData() {
        super.initData();
        Log.i("TAG", "MovieFragment");
        init();

    }

    private void init() {
        listFragment=new ArrayList<>();
        listFragment.add(new FireFragment(context));
        listFragment.add(new WaitFragment(context));
        listFragment.add(new OverseasFragment(context));

        //关联viewpager适配器
        movie_topicViewpager.setAdapter(new MyPagerAdapter());
        //TabLayout关联viewpager
        movie_topictile.setupWithViewPager(movie_topicViewpager);

        //设置滾動模式
        movie_topictile.setTabMode(TabLayout.MODE_SCROLLABLE);

        //默认选中第一个
        movie_topicViewpager.setCurrentItem(0);
        listFragment.get(0).initData();

        //监听tabLayout
        movie_topictile.setOnTabSelectedListener(new MyOnTabSelectedListener());

        //监听viewpager
        movie_topicViewpager.addOnPageChangeListener(new MyOnPageChangeListener());
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        listFragment.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            movie_topicViewpager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            BaseFragment fragment = listFragment.get(position);
            View rootView = fragment.rootView;
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }



   /* private FragmentPagerAdapter adapter=new FragmentPagerAdapter(fm) {
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    };*/
}
