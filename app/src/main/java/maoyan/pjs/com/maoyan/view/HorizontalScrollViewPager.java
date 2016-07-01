package maoyan.pjs.com.maoyan.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by pjs984312808 on 2016/6/6.
 */
public class HorizontalScrollViewPager extends ViewPager {
    public HorizontalScrollViewPager(Context context) {
        this(context, null);
    }

    public HorizontalScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     *
     * 1.竖直方向滑动
     getParent().requestDisallowInterceptTouchEvent(false);

     2.水平方向滑动

     2.1_从左向右滑动，并且是页面的第0个的时候，不拦截
     getParent().requestDisallowInterceptTouchEvent(false);
     if((endX - startX）>0){
     从左向右滑动
     }

     2.2_从右到左滑动，并且页面是最后一个的时候，不拦截

     getParent().requestDisallowInterceptTouchEvent(false);
     if((endX-startx < 0)){

     从右到左滑动
     }

     2.3-中间部分，反拦截，让事件传递给自己
     getParent().requestDisallowInterceptTouchEvent(true);
     * @param ev
     * @return
     */

    private float startX;
    private float startY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                //1.记录起始位置
                startX =ev.getX();
                startY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //2.结束的位置
                float endX = ev.getX();
                float endY = ev.getY();

                //2.计算偏移量
                float distanceX = endX - startX;
                float distanceY = endY - startY;

                //3.判断滑动方向
                if(Math.abs(distanceX) > Math.abs(distanceY)){
                    //水平方向滑动
//                    2.水平方向滑动
//
//                    2.1_从左向右滑动，并且是页面的第0个的时候，不拦截
//                    getParent().requestDisallowInterceptTouchEvent(false);
                    if(distanceX>0&&getCurrentItem()==0){
                        //从左向右滑动
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
//
//                    2.2_从右到左滑动，并且页面是最后一个的时候，不拦截
//
//                    getParent().requestDisallowInterceptTouchEvent(false);
                    else if((distanceX < 0)&& getCurrentItem()==getAdapter().getCount()-1){

                        //从右到左滑动
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
//
//                    2.3-中间部分，反拦截，让事件传递给自己
//                    getParent().requestDisallowInterceptTouchEvent(true);
                    else{
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }else{
                    //竖直方向滑动

                    getParent().requestDisallowInterceptTouchEvent(false);
                }



                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
