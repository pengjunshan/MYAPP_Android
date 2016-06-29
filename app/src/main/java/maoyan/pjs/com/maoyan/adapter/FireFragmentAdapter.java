package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
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
import java.util.Map;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.FireListBean;
import maoyan.pjs.com.maoyan.fragment.FireFragment;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class FireFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    private static List<Map<String, Object>> listVP;

    private LayoutInflater mLayoutInflater;
    private static Context mContext;
    private int mHeaderCount = 1;//头部View个数
    //list下的数据
    private List<FireListBean.DataBean.HotBean> moviesData;

    public FireFragmentAdapter(Context context, Handler handler) {
        mContext = context;
        this.handler = handler;

        mLayoutInflater = LayoutInflater.from(context);
    }

    //内容长度
    public int getContentItemCount() {
        if (moviesData != null && moviesData.size() > 0) {
            return moviesData.size();
        }
        return 0;
    }

    //判断当前item是否是HeadView
    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    //判断当前item类型
    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount != 0 && position < mHeaderCount) {
//头部View
            return ITEM_TYPE_HEADER;
        } else {
//内容View
            return ITEM_TYPE_CONTENT;
        }
    }

    /**
     * 得到头部viewpager数据
     *
     * @param listVP
     */
    public void setViewPagerData(List<Map<String, Object>> listVP) {
        this.listVP = listVP;
    }

    /**
     * 获取下部分数据
     *
     * @param moviesData
     */
    public void setListData(List<FireListBean.DataBean.HotBean> moviesData) {
        this.moviesData = moviesData;
    }


    //内容 ViewHolder
    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_icon;
        private Button btn_bay, btn_per;
        public TextView tv_title, tv_3d, tv_imax, tv_scm, tv_showInfo, tv_sc, tv_state;

        private RecyclerView recyclerView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            btn_bay = (Button) itemView.findViewById(R.id.btn_bay);
            btn_per = (Button) itemView.findViewById(R.id.btn_per);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_3d = (TextView) itemView.findViewById(R.id.tv_3d);
            tv_imax = (TextView) itemView.findViewById(R.id.tv_imax);
            tv_scm = (TextView) itemView.findViewById(R.id.tv_scm);
            tv_showInfo = (TextView) itemView.findViewById(R.id.tv_showInfo);
            tv_sc = (TextView) itemView.findViewById(R.id.tv_sc);
            tv_state = (TextView) itemView.findViewById(R.id.tv_state);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);

        }
    }

    //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public static ViewPager fire_viewpager;

        public HeaderViewHolder(View itemView) {
            super(itemView);

            fire_viewpager = (ViewPager) itemView.findViewById(R.id.fire_viewpager);
            if (listVP != null && listVP.size() > 0) {

                fire_viewpager.setAdapter(new FireViewPagerAdapter(mContext, listVP));
                //设置显示在最大值的中间
                int centitem = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % listVP.size();
                fire_viewpager.setCurrentItem(centitem);

                FireFragment.handler.sendEmptyMessageDelayed(2, 3000);
            }
        }
    }

    /**
     * 根据getItemViewType返回的position不同
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.item_fire_title, parent, false));
        } else if (viewType == mHeaderCount) {
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_fire, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof ContentViewHolder) {
            if (moviesData != null && moviesData.size() > 0) {
                FireListBean.DataBean.HotBean moviesBean = moviesData.get(position - 1);
                ((ContentViewHolder) holder).tv_title.setText(moviesBean.getNm());
                Log.i("TAG", "isValue3d=" + moviesBean.getVer());
                if (!moviesBean.getVer().toString().contains("3D")) {
                    ((ContentViewHolder) holder).tv_3d.setVisibility(View.GONE);
                } else {
                    ((ContentViewHolder) holder).tv_3d.setVisibility(View.VISIBLE);
                }
                if (!moviesBean.getVer().toString().contains("IMAX")) {
                    ((ContentViewHolder) holder).tv_imax.setVisibility(View.GONE);
                } else {
                    ((ContentViewHolder) holder).tv_imax.setVisibility(View.VISIBLE);
                }
                ((ContentViewHolder) holder).tv_scm.setText(moviesBean.getScm());
                ((ContentViewHolder) holder).tv_showInfo.setText(moviesBean.getShowInfo());

                if (moviesBean.getSc() != 0) {
                    ((ContentViewHolder) holder).tv_sc.setText(moviesBean.getSc() + "");
                    ((ContentViewHolder) holder).tv_state.setText("分");
                } else {
                    ((ContentViewHolder) holder).tv_sc.setText(moviesBean.getWish() + "");
                    ((ContentViewHolder) holder).tv_state.setText("人想看");
                }

                if (moviesBean.getPreSale() == 0) {
                    ((ContentViewHolder) holder).btn_bay.setVisibility(View.VISIBLE);
                    ((ContentViewHolder) holder).btn_per.setVisibility(View.GONE);
                } else if (moviesBean.getPreSale() == 1) {
                    ((ContentViewHolder) holder).btn_per.setVisibility(View.VISIBLE);
                    ((ContentViewHolder) holder).btn_bay.setVisibility(View.GONE);
                }
        if(moviesBean.getHeadLinesVO()!=null&&moviesBean.getHeadLinesVO().size()>0) {
//            moviesBean.getHeadLinesVO().get(position-1).getTitle();
            ((ContentViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            ((ContentViewHolder) holder).recyclerView.setAdapter(new FireSpecialAdapter(mContext, moviesBean.getHeadLinesVO()));
        }else {
//            Log.i("TAG", "没有");
        }
                String imaUrl = moviesBean.getImg();
                imaUrl = imaUrl.replace("w.h", "165.220");
                Glide.with(mContext).load(imaUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                        .placeholder(R.mipmap.vp3)//加载过程中的图片
                        .error(R.mipmap.vp3)//加载失败的时候显示的图片
                        .into(((ContentViewHolder) holder).iv_icon);//请求成功后把图片设置到的控件

            }
        }


    }

    @Override
    public int getItemCount() {
//        return mHeaderCount + getContentItemCount();
        return mHeaderCount + getContentItemCount();
    }

    class FireSpecialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final Context mContext;
        private final List<FireListBean.DataBean.HotBean.HeadLinesVOBean> headLinesVO;

        public FireSpecialAdapter(Context mContext, List<FireListBean.DataBean.HotBean.HeadLinesVOBean> headLinesVO) {
            this.mContext=mContext;
            this.headLinesVO=headLinesVO;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SpeciaHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fire_special, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (headLinesVO != null && headLinesVO.size() > 0) {
                FireListBean.DataBean.HotBean.HeadLinesVOBean headLinesVOBean = this.headLinesVO.get(position);
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