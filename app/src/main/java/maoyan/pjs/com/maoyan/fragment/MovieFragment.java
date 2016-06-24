package maoyan.pjs.com.maoyan.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.base.BaseFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class MovieFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout ll_point;
    private ImageView iv_point;
    private TextView tv_fire,tv_wait,tv_overseas;

//    private TabLayout movie_topictile;
//    private String[] mTitle = new String[]{"热映", "待映", "海外"};

    private ViewPager movie_topicViewpager;
    
    private List<BaseFragment> listFragment;

    /**
     * 两个标题的间距
     */
    private int leftMargin;

    public MovieFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view=View.inflate(context, R.layout.moviefragment,null);
//        movie_topictile = (TabLayout) view.findViewById(R.id.movie_topictile);
        movie_topicViewpager = (ViewPager) view.findViewById(R.id.movie_topicViewpager);
        ll_point = (LinearLayout) view.findViewById(R.id.ll_point);
        iv_point = (ImageView) view.findViewById(R.id.iv_point);

        tv_fire = (TextView) view.findViewById(R.id.tv_fire);
        tv_wait = (TextView) view.findViewById(R.id.tv_wait);
        tv_overseas = (TextView) view.findViewById(R.id.tv_overseas);

        tv_fire.setOnClickListener(this);
        tv_wait.setOnClickListener(this);
        tv_overseas.setOnClickListener(this);
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

        //默认选中第一个
        movie_topicViewpager.setCurrentItem(0);
        listFragment.get(0).initData();

        setOnClick();



       /* //TabLayout关联viewpager
        movie_topictile.setupWithViewPager(movie_topicViewpager);

        //设置滚动模式
        movie_topictile.setTabMode(TabLayout.MODE_SCROLLABLE);*/
    }

    private void setOnClick(){
        /**
         * 监听树
         */
        iv_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

        //监听viewpager
        movie_topicViewpager.addOnPageChangeListener(new MyOnPageChangeListener());


         /*  //监听tabLayout
        movie_topictile.setOnTabSelectedListener(new MyOnTabSelectedListener());*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_fire:
                movie_topicViewpager.setCurrentItem(0);
                break;

            case R.id.tv_wait:
                movie_topicViewpager.setCurrentItem(1);
                break;

            case R.id.tv_overseas:
                movie_topicViewpager.setCurrentItem(2);
                break;
        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        @Override
        public void onGlobalLayout() {
            //先移除
            iv_point.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            leftMargin = ll_point.getChildAt(1).getLeft()-ll_point.getChildAt(0).getLeft();
        }
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            //得到浮动块的移动距离
            int currstanceLeft= (int) ((position+positionOffset)*leftMargin);

            /**
             * 针对移动的距离来设置透明度
             */
            if(currstanceLeft>0&&currstanceLeft<leftMargin) {
                tv_fire.setAlpha(positionOffset);
                tv_wait.setAlpha(positionOffset);
            }else if(currstanceLeft>leftMargin&&currstanceLeft<leftMargin*2){
                tv_wait.setAlpha(positionOffset);
                tv_overseas.setAlpha(positionOffset);
            }else if(currstanceLeft==0||currstanceLeft==leftMargin||currstanceLeft==leftMargin*2){
                tv_fire.setAlpha(1);
                tv_wait.setAlpha(1);
                tv_overseas.setAlpha(1);
            }

            /**
             * 得到imageview的参数
             * 动态设置参数
             */
            iv_point.setLeft(currstanceLeft);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_point.getLayoutParams();
            params.leftMargin=currstanceLeft;//赋值
            iv_point.setLayoutParams(params);//重新设置
        }

        @Override
        public void onPageSelected(int position) {
        listFragment.get(position).initData();
            for (int i = 0; i <3 ; i++) {
                //先设置所有为白色
                ((TextView) (ll_point.getChildAt(i))).setTextColor(Color.WHITE);
            }
            //设置当前为红色
            ((TextView)ll_point.getChildAt(position)).setTextColor(Color.RED);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }



    /*class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

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
    }*/

    class MyPagerAdapter extends PagerAdapter {
/*

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
*/

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
            return listFragment.get(position);
        }
        @Override
        public int getCount() {
            return listFragment.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    };*/
}
