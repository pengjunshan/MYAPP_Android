package maoyan.pjs.com.maoyan.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.activity.ShopDetailsActivity;
import maoyan.pjs.com.maoyan.adapter.ShopTypeAdapter;
import maoyan.pjs.com.maoyan.base.BaseSlideFragment;
import maoyan.pjs.com.maoyan.bean.ECshopBean;
import maoyan.pjs.com.maoyan.bean.ShoppingCart;

/**
 * <b>Project:</b> SlideDetailsLayout<br>
 * <b>Create Date:</b> 16/1/26<br>
 * <b>Author:</b> Gordon<br>
 * <b>Description:</b> <br>
 */
public class ScrollViewFragment extends BaseSlideFragment {

    public static TextView tv_title,tv_aldprice;
    public static ImageView iv_icon,iv_bay,iv_shape;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.scroll_fragment, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
        iv_bay = (ImageView) view.findViewById(R.id.iv_bay);
        tv_aldprice = (TextView) view.findViewById(R.id.tv_aldprice);
        tv_aldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        iv_bay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.得到当前物品的对象
                ECshopBean.DataBean.ListBean listBean = ShopTypeAdapter.listData.get(ShopDetailsActivity.position);
                //2.转换成CartProvider对象
                ShoppingCart cart = ShopTypeAdapter.cartProvider.conversion(listBean);
                //3.把CartProvider保存到
                ShopTypeAdapter.cartProvider.putCart(cart);
            }
        });

        /**
         * 商品分享
         */
        iv_shape = (ImageView) view.findViewById(R.id.iv_shape);
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(getActivity());
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle("猫眼电影分享");
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://image.so.com/v?q=%E9%AB%98%E5%9C%86%E5%9C%86&src=famous&fromurl=http%3A%2F%2Fwww.7kmn.com%2Farticle%2F34%2F1545.html#q=%E9%AB%98%E5%9C%86%E5%9C%86&src=famous&fromurl=http%3A%2F%2Fwww.7kmn.com%2Farticle%2F34%2F1545.html&lightboxindex=5&id=e54fdedddc3ef4024305feb0d4078b2b&multiple=1&itemindex=0&dataindex=8");
                // text是分享文本，所有平台都需要这个字段
                //1.得到当前物品的对象
                ECshopBean.DataBean.ListBean listBean = ShopTypeAdapter.listData.get(ShopDetailsActivity.position);
                oks.setText(listBean.getTitle());
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://www.360kan.com/tv/PbRran7kSWDtNX.html");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite(getString(R.string.app_name));
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://www.360kan.com/tv/PbRran7kSWDtNX.html");

// 启动分享GUI
                oks.show(getActivity());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
