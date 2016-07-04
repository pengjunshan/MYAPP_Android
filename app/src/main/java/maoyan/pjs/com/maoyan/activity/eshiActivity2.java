package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.view.ObservableScrollView;
import maoyan.pjs.com.maoyan.view.YRecycleview;

public class eshiActivity2 extends AppCompatActivity{


    private ObservableScrollView scrollview;
    private YRecycleview recyclerView;

    private Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshi2);

        scrollview = (ObservableScrollView)findViewById(R.id.scrollview);
        recyclerView = (YRecycleview)findViewById(R.id.recyclerView);
        mToolBar = (Toolbar)findViewById(R.id.toolbar);

    }

}
