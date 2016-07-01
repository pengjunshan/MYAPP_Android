package maoyan.pjs.com.maoyan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.util.Constant;
import maoyan.pjs.com.maoyan.util.HttpUtils;

/**
 * 引导页面
 */
public class GuideActivity extends AppCompatActivity {

    public static GuideActivity ac;
    private ImageView iv_welcome;
    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    ac.setAnimotion();
                    break;
                case 1:
                    ac.startActivity(new Intent(ac, MainActivity.class));
                    ac.finish();
                    break;

            }
        }
    };


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        ac = this;
        iv_welcome = (ImageView) findViewById(R.id.iv_welcome);
        String url = Constant.GuideUrl;
        HttpUtils.getGuideImage(url, iv_welcome,this);
    }

    public void setAnimotion() {
        ScaleAnimation sa = new ScaleAnimation(1, 1.2f, 1, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(4000);
        sa.setFillAfter(true);

        iv_welcome.setAnimation(sa);

        sa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                ac.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
