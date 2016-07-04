package maoyan.pjs.com.maoyan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.adapter.PayShopAdapter;
import maoyan.pjs.com.maoyan.bean.ShoppingCart;
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
//                pay();
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
}
