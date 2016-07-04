package maoyan.pjs.com.maoyan.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public abstract class BaseFragment extends Fragment {

    public static Context context;

    public View rootView;
    public boolean isFragment;

    public BaseFragment() {
    }

    public BaseFragment(Context context){

       this.context=context;
       rootView=initView();
       isFragment=false;
   }


    public abstract View initView();

    public void initData(){

    }
}
