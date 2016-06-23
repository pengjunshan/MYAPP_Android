package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cjj.MaterialRefreshLayout;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.TextAdapter;

public class TextActivity extends AppCompatActivity {


    private MaterialRefreshLayout mRefresh;
    private RecyclerView mRecyclerView;

    private TextAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        mRefresh = (MaterialRefreshLayout)findViewById(R.id.refresh);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        adapter=new TextAdapter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mRecyclerView.setAdapter(adapter);

    }
}
