package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import maoyan.pjs.com.maoyan.R;

public class LoadingProcessActivity extends AppCompatActivity {

    private ImageView loading_dialog_border;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_process);
        loading_dialog_border = (ImageView)findViewById(R.id.loading_dialog_border);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.loading_dialog);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        loading_dialog_border.startAnimation(animation);
    }
}
