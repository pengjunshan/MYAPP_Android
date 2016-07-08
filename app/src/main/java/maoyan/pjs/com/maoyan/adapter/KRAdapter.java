package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.KRListBean;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class KRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private LayoutInflater inflater;
    private List<KRListBean.DataBean.HotBean> hotBean;

    public KRAdapter(Context context, List<KRListBean.DataBean.HotBean> hotData) {
        this.mContext=context;
        this.hotBean=hotData;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FireHolder(inflater.inflate(R.layout.item_kr,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (hotBean != null && hotBean.size() > 0) {
            KRListBean.DataBean.HotBean hotData = hotBean.get(position);
            ((FireHolder) holder).tv_nm.setText(hotData.getNm());
            Log.i("TAG", "isValue3d=" + hotData.getVer());
            if (!hotData.getVer().toString().contains("3D")) {
                ((FireHolder) holder).tv_3d.setVisibility(View.GONE);
            } else {
                ((FireHolder) holder).tv_3d.setVisibility(View.VISIBLE);
            }
            if (!hotData.getVer().toString().contains("IMAX")) {
                ((FireHolder) holder).tv_imax.setVisibility(View.GONE);
            } else {
                ((FireHolder) holder).tv_imax.setVisibility(View.VISIBLE);
            }
            ((FireHolder) holder).tv_cat.setText(hotData.getCat());
            ((FireHolder) holder).tv_showInfo.setText(hotData.getDesc());

            if (hotData.getSc() != 0) {
                ((FireHolder) holder).tv_sc.setText(hotData.getSc() + "");
                ((FireHolder) holder).tv_state.setText("分");
            } else {
                ((FireHolder) holder).tv_sc.setText(hotData.getWish() + "");
                ((FireHolder) holder).tv_state.setText("人想看");
            }


            if(hotData.getHeadLinesVO()!=null&&hotData.getHeadLinesVO().size()>0) {
                ((FireHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                ((FireHolder) holder).recyclerView.setAdapter(new FireSpecialAdapter(mContext,hotData.getHeadLinesVO()));
            }else {
            }


            String imaUrl = hotData.getImg();
            imaUrl = imaUrl.replace("w.h", "165.220");
            Tools.loadImage(mContext,imaUrl,((FireHolder) holder).iv_icon);
        }
    }

    @Override
    public int getItemCount() {
        if(hotBean!=null&&hotBean.size()>0) {
            return hotBean.size();
        }
        return 0;
    }

   /* public void setkrList(List<KRListBean.DataBean.HotBean> hotBean) {
        this.hotBean=hotBean;
        notifyItemRangeChanged(0,hotBean.size());
    }*/


    class FireHolder extends RecyclerView.ViewHolder{
        private ImageView iv_icon;
        private Button btn_bay, btn_per;
        public TextView tv_nm, tv_3d, tv_imax, tv_cat, tv_showInfo, tv_sc, tv_state;

        private RecyclerView recyclerView;
        public FireHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            btn_bay = (Button) itemView.findViewById(R.id.btn_bay);
            btn_per = (Button) itemView.findViewById(R.id.btn_per);
            tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);
            tv_3d = (TextView) itemView.findViewById(R.id.tv_3d);
            tv_imax = (TextView) itemView.findViewById(R.id.tv_imax);
            tv_cat = (TextView) itemView.findViewById(R.id.tv_cat);
            tv_showInfo = (TextView) itemView.findViewById(R.id.tv_showInfo);
            tv_sc = (TextView) itemView.findViewById(R.id.tv_sc);
            tv_state = (TextView) itemView.findViewById(R.id.tv_state);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }


    class FireSpecialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final Context mContext;
        private final List<KRListBean.DataBean.HotBean.HeadLinesVOBean> headLinesVO;

        public FireSpecialAdapter(Context mContext, List<KRListBean.DataBean.HotBean.HeadLinesVOBean> headLinesVO) {
            this.mContext=mContext;
            this.headLinesVO=headLinesVO;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SpeciaHolder(LayoutInflater.from(mContext).inflate(R.layout.item_kr_special, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (headLinesVO != null && headLinesVO.size() > 0) {
                KRListBean.DataBean.HotBean.HeadLinesVOBean headLinesVOBean = this.headLinesVO.get(position);
                Log.i("TAG", "headLinesVO.getTitle()=" + headLinesVOBean.getTitle());
                ((SpeciaHolder) holder).tv_special_title.setText(headLinesVOBean.getType());
                ((SpeciaHolder) holder).tv_special_content.setText(headLinesVOBean.getTitle());
            }

        }

        @Override
        public int getItemCount() {
            if (headLinesVO != null && headLinesVO.size() > 0) {
                return headLinesVO.size();
            }
            return 0;
        }

        class SpeciaHolder extends RecyclerView.ViewHolder {

            private TextView tv_special_title, tv_special_content;

            public SpeciaHolder(View itemView) {
                super(itemView);
                tv_special_title = (TextView) itemView.findViewById(R.id.tv_special_title);
                tv_special_content = (TextView) itemView.findViewById(R.id.tv_special_content);
            }
        }

    }
}
