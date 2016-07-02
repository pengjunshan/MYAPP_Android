package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import maoyan.pjs.com.maoyan.R;

/**
 * 发现模块-影库
 */
public class MovieLibActivity extends AppCompatActivity {

    private MovieLibActivity ac;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_lib);
        ac=this;
        initFindView();
        initData();
    }

    private void initFindView() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
    }

    private void initData() {
    }

}
