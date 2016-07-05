package maoyan.pjs.com.maoyan.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.PayShopAdapter;
import maoyan.pjs.com.maoyan.bean.ShoppingCart;
import maoyan.pjs.com.maoyan.pay.PayResult;
import maoyan.pjs.com.maoyan.pay.SignUtils;
import maoyan.pjs.com.maoyan.util.CartProvider;

public class ShopCartActivity extends AppCompatActivity {

    /**
     * 付费状态
     */
    public static final String STATE_EDITE = "state_edite";
    /**
     * 删除状态
     */
    public static final String STATE_DELETE = "state_delete";
    private ShopCartActivity ac;
    private RecyclerView recyclerView;
    private CheckBox checkbox_all;
    private TextView tv_total_price,tv_edite,tv_total;
    private Button btn_order, btn_delete;
    private List<ShoppingCart> payDatas;

    private PayShopAdapter adapter;

    // 商户PID
    public static final String PARTNER = "2088911876712776";
    // 商户收款账号
    public static final String SELLER = "chenlei@atguigu.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALTWQN7pCkgo4pKf\n" +
            "hc6+91hgQKMw0oEDMsmKT7Jh6vnIfamAFDPOdbNHiGpxwdZ+DY8mP3u9LGKXYWSg\n" +
            "j3UdmW7WkLWSN4f8AwTrIp1Gwu0FVE9ZedZhB3O2J6TKIqPzGDdDJnWMvImu1+aW\n" +
            "AQwTJMeENmygH39lYhI2yH/GYVPJAgMBAAECgYB+sZjTU1uzwIk0hnS9q0cpcI34\n" +
            "hy0D3BTJ5I//fuCcTV3U0fnVbfFCQHyPbtGKD9g6EWbqr1eYX0yJrn+zYqBqPHzK\n" +
            "hBhaf2lq5fXrkTwjFqqNixBjtUw1hAuFfcCn+uvCJhAF4TpWUP3MwDqnM03GlCxl\n" +
            "kJFk969jKncU0W5I8QJBANqfJ5Mrp80uITu/Y9KVLGwvh0fFNoobXHd8LIc8MJyH\n" +
            "T6O6kZb+MU1d7XPIVmtiW9T6oQQWWdy9sZMAtBOlkJUCQQDTwUxsWBKyzfw0QkJO\n" +
            "j/UummKB88pr6WeJVNWYEMDlX4+gFBIeRr9PAQ2AOmWGMHtoYrVXUVMGI7ZJQUMs\n" +
            "UuVlAkAlCAJvFlz1D1RHx5KEEAqXRLG4gXpMiHfwMVNlkNd3HCBsTmTs25/ESB25\n" +
            "l/yzcdS2TcHKbHLKRkN28A6QqWHFAkBCHumuKxIrowZNiyMJRQpaMvrveSCL8aXS\n" +
            "zBqmERUqilxer+W4bn7uPHXqxFFPRXRDdA8L5Oj30c7psOc4v+nBAkEAugDrKI6N\n" +
            "4yCtgzzxk1fx1psiYuxrzIqLc9O4hAvI2RI4njum0QdC9qLuj04+AyuXYH0uKxkt\n" +
            "5iA/f/jfUxPzMQ==";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(ac, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(ac, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(ac, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);
        ac=this;
        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        checkbox_all = (CheckBox) findViewById(R.id.checkbox_all);//全选
        tv_total_price = (TextView) findViewById(R.id.tv_total_price);//总价格
        btn_order = (Button) findViewById(R.id.btn_order);//购买
        btn_delete = (Button) findViewById(R.id.btn_delete);//删除
        tv_edite = (TextView)findViewById(R.id.tv_edite);//编辑
        tv_total = (TextView)findViewById(R.id.tv_total);//文字

    }


    private void initData() {

        tv_edite.setVisibility(View.VISIBLE);
        tv_edite.setTag(STATE_EDITE);

        CartProvider cartProvider = new CartProvider(ac);
        payDatas = cartProvider.getAllData();

        adapter = new PayShopAdapter(ac, payDatas,tv_total_price,checkbox_all);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ac, LinearLayoutManager.VERTICAL, false));

        setOnClick();
    }
    private void setOnClick() {

        /**
         * 支付
         */
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });

        /**
         * 删除
         */
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.deleteData();
            }
        });

        /**
         * 编辑状态
         */
        tv_edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String btnTag = (String) tv_edite.getTag();
                if(btnTag==STATE_EDITE) {
                    //改变tag
                    tv_edite.setTag(STATE_DELETE);
                    tv_edite.setText("完成");
                    //隐藏付款按钮
                    btn_order.setVisibility(View.INVISIBLE);
                    //显示删除按钮
                    btn_delete.setVisibility(View.VISIBLE);

                    //全部设置非选中
                    adapter.setCheckBoxAll(false);
                    checkbox_all.setChecked(false);
                }else {
                    //改变tag
                    tv_edite.setTag(STATE_EDITE);
                    tv_edite.setText("编辑");
                    //隐藏付款按钮
                    btn_order.setVisibility(View.VISIBLE);
                    //显示删除按钮
                    btn_delete.setVisibility(View.INVISIBLE);

                    //全部设置选中
                    adapter.setCheckBoxAll(true);
                    checkbox_all.setChecked(true);
                }

            }
        });

        /**
         * 点击全选 非全选
         */
        checkbox_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setCheckBoxAll(checkbox_all.isChecked());
            }
        });

        /**
         * 点击某项 设置是否选中
         */
        adapter.setOnItemClickListener(new PayShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                boolean isCheck = payDatas.get(position).isChecked();
                adapter.setItemisCheck(position,!isCheck);
            }
        });
    }

    /**
     * call alipay sdk pay. 调用SDK支付
     *
     */
    public void pay() {
        if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }
        String orderInfo = getOrderInfo("猫眼眼睛亮瞎你的双眼", "全场两块,走过路过不要错过", "0.01");

        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息
         */
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(ac);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * create the order info. 创建订单信息
     *
     */
    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     *
     */
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content
     *            待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     *
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
    }


}
