package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import maoyan.pjs.com.maoyan.R;

public class SystemVideo extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_video);
        videoView = (VideoView)findViewById(R.id.videoView);
    }
}
