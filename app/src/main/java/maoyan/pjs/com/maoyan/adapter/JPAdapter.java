package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.JPListBean;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class JPAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private List<JPListBean.DataBean.HotBean> hotBeen;
    private LayoutInflater inflater;

    public JPAdapter(Context context, List<JPListBean.DataBean.HotBean> hotBeen) {
        this.context=context;
        this.hotBeen=hotBeen;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JPSpecialAdapter(inflater.inflate(R.layout.item_jp,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(hotBeen!=null&&hotBeen.size()>0) {
            JPListBean.DataBean.HotBean hotData = hotBeen.get(position);

            ((JPSpecialAdapter)holder).tv_nm.setText(hotData.getNm());
            ((JPSpecialAdapter)holder).tv_cat.setText(hotData.getCat());
            ((JPSpecialAdapter)holder).tv_desc.setText(hotData.getDesc());

            ((JPSpecialAdapter)holder).tv_sc.setText(hotData.getSc()+"");

            if(hotData.getVer().contains("3D")) {
                ((JPSpecialAdapter)holder).tv_3d.setVisibility(View.VISIBLE);
            }else {
                ((JPSpecialAdapter)holder).tv_3d.setVisibility(View.GONE);
            }

            if(hotData.getVer().contains("IMAX")) {
                ((JPSpecialAdapter)holder).tv_imax.setVisibility(View.VISIBLE);
            }else {
                ((JPSpecialAdapter)holder).tv_imax.setVisibility(View.GONE);
            }

            if(hotData.getHeadLinesVO()!=null&&hotData.getHeadLinesVO().size()>0) {
                ((JPSpecialAdapter) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                ((JPSpecialAdapter) holder).recyclerView.setAdapter(new FireSpecialAdapter(context,hotData.getHeadLinesVO()));
            }
            String imaUrl = hotData.getImg();
            imaUrl = imaUrl.replace("w.h", "165.220");
            Tools.loadImage(context,imaUrl,((JPSpecialAdapter) holder).iv_img);
        }
    }

    @Override
    public int getItemCount() {
        if(hotBeen!=null&&hotBeen.size()>0) {
            return hotBeen.size();
        }
        return 0;
    }

    class JPSpecialAdapter extends RecyclerView.ViewHolder{

        private ImageView iv_img;
        private RecyclerView recyclerView;
        private TextView tv_nm,tv_cat,tv_desc,tv_3d,tv_imax,tv_sc;
        public JPSpecialAdapter(View itemView) {
            super(itemView);

            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);//电影图片
            tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);//电影名字
            tv_cat = (TextView) itemView.findViewById(R.id.tv_cat);//电影类型
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);//电影主演
            tv_3d = (TextView) itemView.findViewById(R.id.tv_3d);//是否是3D
            tv_imax = (TextView) itemView.findViewById(R.id.tv_imax);//是否是IMAX
            tv_sc = (TextView) itemView.findViewById(R.id.tv_sc);//评分

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);

        }
    }




    class FireSpecialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final Context mContext;
        private final List<JPListBean.DataBean.HotBean.HeadLinesVOBean> headLinesVO;

        public FireSpecialAdapter(Context context, List<JPListBean.DataBean.HotBean.HeadLinesVOBean> headLinesVO) {
            this.mContext=context;
            this.headLinesVO=headLinesVO;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SpeciaHolder(LayoutInflater.from(mContext).inflate(R.layout.item_jp_special, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (headLinesVO != null && headLinesVO.size() > 0) {
                JPListBean.DataBean.HotBean.HeadLinesVOBean headLinesVOBean = this.headLinesVO.get(position);
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
