package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.USListBean;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class USAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private final Context context;
    private List<USListBean.DataBean.ComingBean> comingData2;

    public USAdapter(Context context, List<USListBean.DataBean.ComingBean> comingData2) {
        this.context=context;
        this.comingData2=comingData2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new USWaitHolder(LayoutInflater.from(context).inflate(R.layout.item_uswait,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(comingData2!=null&&comingData2.size()>0){
            USListBean.DataBean.ComingBean comData2 = comingData2.get(position);
            ((USWaitHolder)holder).tv_nm.setText(comData2.getNm());

            if(!TextUtils.isEmpty(comData2.getVer())) {
                if(comData2.getVer().contains("3D")) {
                    ((USWaitHolder)holder).tv_3d.setVisibility(View.VISIBLE);
                }else {
                    ((USWaitHolder)holder).tv_3d.setVisibility(View.GONE);
                }

                if(comData2.getVer().contains("IMAX")) {
                    ((USWaitHolder)holder).tv_imax.setVisibility(View.VISIBLE);
                }else {
                    ((USWaitHolder)holder).tv_imax.setVisibility(View.GONE);
                }
            }

            ((USWaitHolder)holder).tv_overseaTime.setText(comData2.getOverseaTime());

            ((USWaitHolder)holder).tv_desc.setText(comData2.getDesc());

            ((USWaitHolder)holder).tv_wish.setText(comData2.getWish()+"");

            String imaUrl = comData2.getImg();
            imaUrl = imaUrl.replace("w.h", "165.220");
            Tools.loadImage(context,imaUrl,((USWaitHolder) holder).iv_icon);
        }

    }

    @Override
    public int getItemCount() {
        if(comingData2!=null&&comingData2.size()>0) {
            return comingData2.size();
        }
        return 0;
    }

    class USWaitHolder extends RecyclerView.ViewHolder{

        private ImageView iv_icon;
        private TextView tv_nm,tv_3d,tv_imax,tv_overseaTime,tv_desc,tv_wish;

        public USWaitHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);
            tv_3d = (TextView) itemView.findViewById(R.id.tv_3d);
            tv_imax = (TextView) itemView.findViewById(R.id.tv_imax);
            tv_overseaTime = (TextView) itemView.findViewById(R.id.tv_overseaTime);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            tv_wish = (TextView) itemView.findViewById(R.id.tv_wish);
        }
    }

}
