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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.WaitListBean;

/**
 * Created by pjs984312808 on 2016/6/22.
 */


public class WaitFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private LayoutInflater inflater;
    //模拟数据

    private List<WaitListBean.DataBean.ComingBean> comingData;

    public WaitFragmentAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_wait_title, parent, false);
            return new HeaderHolder(view);
        } else if (viewType == 1) {
            View view = inflater.inflate(R.layout.item_correcycler1, parent, false);
            return new CroRecyclerHolder1(view);
        } else if (viewType == 2) {
            View view = inflater.inflate(R.layout.item_correcycler2, parent, false);
            return new CroRecyclerHolder2(view);
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_wait, parent, false);
        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            return;
        } else if (position == 1) {
            return;
        } else if (position == 2) {
            return;
        }

        if(holder instanceof ContentHolder) {
        if(comingData!=null&&comingData.size()>0) {
            WaitListBean.DataBean.ComingBean itemData = comingData.get(position - 3);
            ((ContentHolder)holder).tv_nm.setText(itemData.getNm());
            ((ContentHolder)holder).tv_scm.setText(itemData.getScm());
            ((ContentHolder)holder).tv_desc.setText(itemData.getDesc());
            ((ContentHolder)holder).tv_wish.setText(itemData.getWish()+"");

            if(itemData.getHeadLinesVO()!=null&itemData.getHeadLinesVO().size()>0) {
                ((ContentHolder)holder).recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
                ((ContentHolder)holder).recyclerView.setAdapter(new SpecialAdapter(mContext,itemData.getHeadLinesVO()));
            }

            String imaUrl=itemData.getImg();
           imaUrl = imaUrl.replace("w.h","165.220");
            Glide.with(mContext).load(imaUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.mipmap.vp3)//加载过程中的图片
                    .error(R.mipmap.vp3)//加载失败的时候显示的图片
                    .into(((ContentHolder) holder).iv_img);//请求成功后把图片设置到的控件
        }

        }
    }

    @Override
    public int getItemCount() {
        if (comingData != null && comingData.size() > 0) {
            return comingData.size() + 3;
        }
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        }
        return 3;
    }

    public void setListData(List<WaitListBean.DataBean.ComingBean> comingData) {
        this.comingData = comingData;
    }

    /**
     * 搜索框Item
     */
    class HeaderHolder extends RecyclerView.ViewHolder {

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 横向recycler1
     */
    class CroRecyclerHolder1 extends RecyclerView.ViewHolder {

        public CroRecyclerHolder1(View itemView) {
            super(itemView);
        }
    }

    /**
     * 横向recycler1
     */
    class CroRecyclerHolder2 extends RecyclerView.ViewHolder {

        public CroRecyclerHolder2(View itemView) {
            super(itemView);
        }
    }


    /**
     * 竖向recycler
     */
    public class ContentHolder extends RecyclerView.ViewHolder {

        private ImageView iv_img;
        public TextView tv_nm, tv_3d, tv_imax, tv_scm, tv_desc, tv_wish, tv_state;
        private Button btn_bay, btn_per;
        private RecyclerView recyclerView;

        public ContentHolder(View itemView) {
            super(itemView);
            btn_per = (Button) itemView.findViewById(R.id.btn_per);
            tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);
            tv_3d = (TextView) itemView.findViewById(R.id.tv_3d);
            tv_imax = (TextView) itemView.findViewById(R.id.tv_imax);
            tv_scm = (TextView) itemView.findViewById(R.id.tv_scm);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            tv_wish = (TextView) itemView.findViewById(R.id.tv_wish);
            tv_state = (TextView) itemView.findViewById(R.id.tv_state);
            btn_bay = (Button) itemView.findViewById(R.id.btn_bay);
            btn_per = (Button) itemView.findViewById(R.id.btn_per);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);

        }
    }

    class SpecialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private final Context mContext;
        private final List<WaitListBean.DataBean.HeadLinesVO> headLinesVO;

        public SpecialAdapter(Context mContext, List<WaitListBean.DataBean.HeadLinesVO> headLinesVO) {
            this.mContext =mContext;
            this.headLinesVO=headLinesVO;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SpeciaHolder(LayoutInflater.from(mContext).inflate(R.layout.item_special,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if(headLinesVO!=null&&headLinesVO.size()>0) {
                WaitListBean.DataBean.HeadLinesVO headLinesVO = this.headLinesVO.get(position);
                Log.i("TAG", "headLinesVO.getTitle()="+headLinesVO.getTitle());
                ((SpeciaHolder)holder).tv_special_title.setText(headLinesVO.getType());
                ((SpeciaHolder)holder).tv_special_content.setText(headLinesVO.getTitle());
            }

        }

        @Override
        public int getItemCount() {
            if(headLinesVO!=null&&headLinesVO.size()>0) {
                return headLinesVO.size();
            }
            return 0;
        }

        class SpeciaHolder extends RecyclerView.ViewHolder{

            private TextView tv_special_title,tv_special_content;
            public SpeciaHolder(View itemView) {
                super(itemView);
                tv_special_title = (TextView) itemView.findViewById(R.id.tv_special_title);
                tv_special_content = (TextView) itemView.findViewById(R.id.tv_special_content);
            }
        }

    }

}