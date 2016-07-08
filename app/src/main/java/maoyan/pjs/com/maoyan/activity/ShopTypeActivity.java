package maoyan.pjs.com.maoyan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.ShopTypeAdapter;
import maoyan.pjs.com.maoyan.bean.ECshopBean;
import maoyan.pjs.com.maoyan.util.HttpUtils;
import maoyan.pjs.com.maoyan.util.Tools;
import maoyan.pjs.com.maoyan.view.GoodsClassifyPopWindow;
import maoyan.pjs.com.maoyan.view.GoodsNewupdatePopWindow;
import maoyan.pjs.com.maoyan.view.GoodsUnderwatyPopWindow;
import maoyan.pjs.com.maoyan.view.SpacesItemDecoration;
import maoyan.pjs.com.maoyan.view.YRecycleview;

public class ShopTypeActivity extends AppCompatActivity implements View.OnClickListener {

    private static ShopTypeActivity ac;
     public static YRecycleview ycl;
    public static ShopTypeAdapter adapter;
    public static  List<ECshopBean.DataBean.ListBean> listData=new ArrayList<>();
    private static TextView tv_theme,tv_unde,tv_sort;
    private static ImageView iv_themeimg,iv_undeimg,iv_sortimg,iv_finish,iv_totalcart;
    private RelativeLayout rl_theme,rl_unde,rl_sort;
    private LinearLayout ll_shop_type;
    private static String url;
    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    adapter = new ShopTypeAdapter(ac,listData);
                    url = (String) msg.obj;
                    ycl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                    ycl.setAdapter(adapter);

                    break;
                case 1:
                    Toast.makeText(ac, "刷新成功", Toast.LENGTH_SHORT).show();
                    ycl.setReFreshComplete();
                    adapter.notifyItemRangeChanged(0,listData.size());
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ac=this;
        setContentView(R.layout.activity_shop_type);
        ycl = (YRecycleview) findViewById(R.id.ycl);

        tv_theme = (TextView)findViewById(R.id.tv_theme);
        tv_unde = (TextView)findViewById(R.id.tv_unde);
        tv_sort = (TextView)findViewById(R.id.tv_sort);
        iv_themeimg = (ImageView)findViewById(R.id.iv_themeimg);
        iv_undeimg = (ImageView)findViewById(R.id.iv_undeimg);
        iv_sortimg = (ImageView)findViewById(R.id.iv_sortimg);
        ll_shop_type = (LinearLayout)findViewById(R.id.ll_shop_type);
        rl_theme = (RelativeLayout)findViewById(R.id.rl_theme);
        rl_unde = (RelativeLayout)findViewById(R.id.rl_unde);
        rl_sort = (RelativeLayout)findViewById(R.id.rl_sort);
        iv_finish = (ImageView)findViewById(R.id.iv_finish);
        iv_totalcart = (ImageView)findViewById(R.id.iv_totalcart);

        iv_finish.setOnClickListener(this);
        iv_totalcart.setOnClickListener(this);

        rl_theme.setOnClickListener(this);
        rl_unde.setOnClickListener(this);
        rl_sort.setOnClickListener(this);

        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(Tools.dip2px(ac,6));
        ycl.addItemDecoration(decoration);

        ycl.setRefreshAndLoadMoreListener(new YRecycleview.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                HttpUtils.getShopNum(ac,url,0);
            }

            @Override
            public void onLoadMore() {
                Log.i("加载更多","000");
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ycl.setloadMoreComplete();
                        ycl.setNoMoreData(true);
                        Toast.makeText(ac, "没有更多数据了...", Toast.LENGTH_SHORT).show();
                    }
                }, 2500);
            }
        });

    }

    public static void setType(int type) {
        switch (type){
            case 1:
                tv_theme.setText("系列/主题");
                tv_unde.setText("数码");
                break;

            case 2:
                tv_theme.setText("系列/主题");
                tv_unde.setText("高玩专区");
                break;

            case 3:
                tv_theme.setText("系列/主题");
                tv_unde.setText("玩具");
                break;

            case 4:
                tv_theme.setText("系列/主题");
                tv_unde.setText("生活");
                break;

            case 5:
                tv_theme.setText("系列/主题");
                tv_unde.setText("服饰");
                break;

            case 6:
                tv_theme.setText("超蝙");
                tv_unde.setText("分类");
                break;

            case 7:
                tv_theme.setText("机器猫");
                tv_unde.setText("分类");
                break;

            case 8:
                tv_theme.setText("魔兽");
                tv_unde.setText("分类");
                break;

            case 9:
                tv_theme.setText("美队");
                tv_unde.setText("分类");
                break;


            case 10:
                tv_theme.setText("星球大战");
                tv_unde.setText("分类");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.iv_finish:
                finish();
                break;

            case R.id.iv_totalcart:
                startActivity(new Intent(ac, ShopCartActivity.class));
                break;

            case R.id.rl_theme:
                GoodsUnderwatyPopWindow underwatyPopWindow=new GoodsUnderwatyPopWindow(ac,tv_theme,iv_themeimg);
                underwatyPopWindow.showAsDropDown(findViewById(R.id.ll_shop_type), 0, 0);
                underwatyPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        iv_themeimg.setImageResource(R.mipmap.down_shop_type);
                        iv_undeimg.setImageResource(R.mipmap.down);
                        iv_sortimg.setImageResource(R.mipmap.down);

                        tv_unde.setTextColor(Color.BLACK);
                        tv_sort.setTextColor(Color.BLACK);
                    }
                });
                tv_theme.setTextColor(Color.parseColor("#ff6666"));//颜色变红
                iv_themeimg.setImageResource(R.mipmap.up_shop_type);//图标向上

                break;

            case R.id.rl_unde:
                GoodsNewupdatePopWindow newupdatePopWindow=new GoodsNewupdatePopWindow(ac,tv_unde,iv_undeimg);
                newupdatePopWindow.showAsDropDown(findViewById(R.id.ll_shop_type), 0, 0);
                newupdatePopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        iv_undeimg.setImageResource(R.mipmap.down_shop_type);//图标向下
                        iv_themeimg.setImageResource(R.mipmap.down);
                        iv_sortimg.setImageResource(R.mipmap.down);

                        tv_theme.setTextColor(Color.BLACK);
                        tv_sort.setTextColor(Color.BLACK);
                    }
                });
                tv_unde.setTextColor(Color.parseColor("#FF6666"));//颜色变红
                iv_undeimg.setImageResource(R.mipmap.up_shop_type);//图标向上

                break;

            case R.id.rl_sort:
                GoodsClassifyPopWindow classifyPopWindow=new GoodsClassifyPopWindow(ac,tv_sort,iv_sortimg);
                classifyPopWindow.showAsDropDown(findViewById(R.id.ll_shop_type), 0, 5);
                classifyPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        /*if (category_id==-1){
                            id_goods_classify_title.setTextColor(Color.parseColor("#333333"));
                            id_goods_classify_image.setImageResource(R.mipmap.down);
                        }else {
                            id_goods_classify_title.setTextColor(Color.parseColor("#FF6666"));
                            id_goods_classify_image.setImageResource(R.mipmap.down_classify_red);
                        }*/
                        iv_sortimg.setImageResource(R.mipmap.down_shop_type);

                        iv_undeimg.setImageResource(R.mipmap.down);
                        iv_undeimg.setImageResource(R.mipmap.down);

                        tv_unde.setTextColor(Color.BLACK);
                        tv_unde.setTextColor(Color.BLACK);
                    }
                });
                //监听点击事件，点击其他位置，popupwindow小窗口消失
                //变为红色向上箭头
                tv_sort.setTextColor(Color.parseColor("#FF6666"));
                iv_sortimg.setImageResource(R.mipmap.up_shop_type);
//
                break;


        }
    }
}
