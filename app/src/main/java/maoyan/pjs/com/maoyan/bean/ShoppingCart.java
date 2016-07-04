package maoyan.pjs.com.maoyan.bean;

import java.io.Serializable;

/**
 * Created by pjs984312808 on 2016/7/4.
 */
public class ShoppingCart extends ECshopBean.DataBean.ListBean implements Serializable {

    private int count;
    private boolean isChecked;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
