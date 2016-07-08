package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.bean.USListBean;
import maoyan.pjs.com.maoyan.bean.WaitExpctBean;
import maoyan.pjs.com.maoyan.bean.WaitListBean;
import maoyan.pjs.com.maoyan.util.Tools;

/**
 * Created by pjs984312808 on 2016/6/22.
 */


public class WaitFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
                                 implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder>{

    private final Context mContext;
    private LayoutInflater inflater;

    public static RecomAdapter recomAdapter;

    //模拟数据

    private List<WaitListBean.DataBean.ComingBean> comingData;

    private List<WaitExpctBean.DataBean.MoviesBean> moviesData;
    private List<USListBean.DataBean.ComingBean> recomData;

    public WaitFragmentAdapter(Context context, List<USListBean.DataBean.ComingBean> recomData,
                               List<WaitExpctBean.DataBean.MoviesBean> moviesData,
                               List<WaitListBean.DataBean.ComingBean> comingData) {
        this.mContext = context;
        this.recomData=recomData;
        this.moviesData=moviesData;
        this.comingData=comingData;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_wait_title, parent, false);
            return new HeaderHolder(view);
        } else if (viewType == 1) {
            View view = inflater.inflate(R.layout.item_wait_recommend, parent, false);
            return new RecommendHolder(view);
        } else if (viewType == 2) {
            View view = inflater.inflate(R.layout.item_wait_expct, parent, false);
            return new ExpctHolder(view);
        }else if(viewType==3) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_wait, parent, false);
            return new ContentHolder(view);
        }
        else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            return;
        } else if (getItemViewType(position) == 1) {

            return;
        } else if (position == 2) {
            return;
        }

        if (holder instanceof ContentHolder) {
            if (comingData != null && comingData.size() > 0) {
                WaitListBean.DataBean.ComingBean itemData = comingData.get(position - 3);
                ((ContentHolder) holder).tv_nm.setText(itemData.getNm());
                ((ContentHolder) holder).tv_scm.setText(itemData.getScm());
                ((ContentHolder) holder).tv_desc.setText(itemData.getDesc());
                ((ContentHolder) holder).tv_wish.setText(itemData.getWish() + "");

                if (itemData.getHeadLinesVO() != null & itemData.getHeadLinesVO().size() > 0) {
                    ((ContentHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                    ((ContentHolder) holder).recyclerView.setAdapter(new WaitSpecialAdapter(mContext, itemData.getHeadLinesVO()));
                }


               /* //是否显示标题
                String rt = itemData.getRt();
                for (int i = 0; i < comingData.indexOf(itemData); i++) {
                    if (rt.equals(comingData.get(i).getRt())) {
                        ((ContentHolder) holder).tv_data.setVisibility(View.GONE);
                        break;
                    }
                    ((ContentHolder) holder).tv_data.setVisibility(View.VISIBLE);
                }
                if (comingData.indexOf(itemData) == 0) {
                    ((ContentHolder) holder).tv_data.setVisibility(View.VISIBLE);
                }
                //显示日期
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日 E");
                Date date = null;//提取格式中的日期
                try {
                    date = sdf1.parse(rt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                rt = sdf2.format(date);

                ((ContentHolder) holder).tv_data.setText(rt);*/


                String imaUrl = itemData.getImg();
                imaUrl = imaUrl.replace("w.h", "165.220");
                Tools.loadImage(mContext,imaUrl,((ContentHolder) holder).iv_img);
            }

        }
    }

    private int parseDate(String strDate) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日 E");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
        Date date = null;//提取格式中的日期
        try {
            date = sdf1.parse(strDate);
            String strDate1 = sdf3.format(date);
            int intDate = Integer.parseInt(strDate1);
            testDate = sdf2.format(date);
            return intDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private TextView commonTitle;
    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
            commonTitle = (TextView) view;
        }
    }

    @Override
    public long getHeaderId(int position) {
        if(comingData!=null&&comingData.size()>0) {
//            if (position == 0) {
//                return -1;
//            }else if(position==1) {
//                return -1;
//            }else if(position==2) {
//                return -1;
//            }
            if(position>3) {
                return parseDate(comingData.get(position-3).getRt());
            }
            return -1;
        }
            return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false);
        return new HeaderViewHolder(view);
    }

    private String testDate;
    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getHeaderId(position) == parseDate(comingData.get(position-3).getRt())) {
            commonTitle.setText(testDate);
        }else if (getHeaderId(position) == -1) {
            commonTitle.setVisibility(View.GONE);
        }
//        else if(getHeaderId(position)==-2) {
//            commonTitle.setVisibility(View.VISIBLE);
//            commonTitle.setText("预告片推荐11");
//        }else if(getHeaderId(position)==-3) {
//            commonTitle.setVisibility(View.VISIBLE);
//            commonTitle.setText("近期最受期待22");
//        }
    }

    @Override
    public int getItemCount() {
        if (comingData != null && comingData.size() > 0) {
            return comingData.size() + 3;
        }
        return 0;
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

    /**
     * 搜索框Item
     */
    class HeaderHolder extends RecyclerView.ViewHolder {

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 横向预告片推荐
     */
    class RecommendHolder extends RecyclerView.ViewHolder {

        private RecyclerView recom_recyclerview;

        public RecommendHolder(View itemView) {
            super(itemView);
            recomAdapter = new RecomAdapter(mContext,recomData);
            recom_recyclerview = (RecyclerView) itemView.findViewById(R.id.recom_recyclerview);
            recom_recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            recom_recyclerview.setAdapter(recomAdapter);
        }
    }

    /**
     * 横向最受欢迎
     */
    class ExpctHolder extends RecyclerView.ViewHolder {

        private RecyclerView expct_recyclerview;

        public ExpctHolder(View itemView) {
            super(itemView);
            expct_recyclerview = (RecyclerView) itemView.findViewById(R.id.expct_recyclerview);
//            if (moviesData != null && moviesData.size() > 0) {
                expct_recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                expct_recyclerview.setAdapter(new ExpctAdapter(mContext, moviesData));
//            }
        }
    }


    /**
     * 竖向recycler
     */
    public class ContentHolder extends RecyclerView.ViewHolder {

        private ImageView iv_img;
        public TextView tv_nm, tv_3d, tv_imax, tv_scm, tv_desc, tv_wish, tv_state, tv_data;
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
//            tv_data = (TextView) itemView.findViewById(R.id.tv_data);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);

        }
    }

    /**
     * 下部分数据
     */
    class WaitSpecialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final Context mContext;
        private final List<WaitListBean.DataBean.HeadLinesVO> headLinesVO;

        public WaitSpecialAdapter(Context mContext, List<WaitListBean.DataBean.HeadLinesVO> headLinesVO) {
            this.mContext = mContext;
            this.headLinesVO = headLinesVO;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SpeciaHolder(LayoutInflater.from(mContext).inflate(R.layout.item_special, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (headLinesVO != null && headLinesVO.size() > 0) {
                WaitListBean.DataBean.HeadLinesVO headLinesVO = this.headLinesVO.get(position);
                ((SpeciaHolder) holder).tv_special_title.setText(headLinesVO.getType());
                ((SpeciaHolder) holder).tv_special_content.setText(headLinesVO.getTitle());
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


    /**
     * 近期最受期待
     */
    class ExpctAdapter extends RecyclerView.Adapter<ExpctAdapter.ExpctHolder> {
        private final Context context;
        private final List<WaitExpctBean.DataBean.MoviesBean> moviesData;

        public ExpctAdapter(Context mContext, List<WaitExpctBean.DataBean.MoviesBean> moviesData) {
            this.context = mContext;
            this.moviesData = moviesData;
        }

        @Override
        public ExpctHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ExpctHolder(LayoutInflater.from(context).inflate(R.layout.item_expct, parent, false));
        }

        @Override
        public void onBindViewHolder(ExpctHolder holder, int position) {
            if (moviesData != null && moviesData.size() > 0) {
                WaitExpctBean.DataBean.MoviesBean moviesList = moviesData.get(position);
                holder.tv_rt.setText(moviesList.getRt());
                holder.tv_nm.setText(moviesList.getNm());
                holder.tv_wish.setText(moviesList.getWish() + "想看");
                String img = moviesList.getImg();
                img=img.replace("w.h","165.220");
                Tools.loadImage(context,img,holder.iv_img);
            }
        }

        @Override
        public int getItemCount() {
            if (moviesData != null && moviesData.size() > 0) {
                return moviesData.size();
            }
            return 0;
        }

        class ExpctHolder extends RecyclerView.ViewHolder {
            private TextView tv_rt, tv_nm, tv_wish;
            private ImageView iv_img, iv_islike;

            public ExpctHolder(View itemView) {
                super(itemView);
                tv_rt = (TextView) itemView.findViewById(R.id.tv_rt);
                tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);
                tv_wish = (TextView) itemView.findViewById(R.id.tv_wish);
                iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
                iv_islike = (ImageView) itemView.findViewById(R.id.iv_islike);
            }
        }
    }

    /**
     * 预告片adapter
     */
    class RecomAdapter extends RecyclerView.Adapter<RecomAdapter.RecomItem> {

        private final Context context;
        private List<USListBean.DataBean.ComingBean> recomData;

        public RecomAdapter(Context mContext, List<USListBean.DataBean.ComingBean> recomData) {
            this.context = mContext;
            this.recomData=recomData;
        }


        @Override
        public RecomItem onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecomItem(LayoutInflater.from(context).inflate(R.layout.item_recom, parent, false));
        }

        @Override
        public void onBindViewHolder(RecomItem holder, int position) {
            if (recomData != null && recomData.size() > 0) {
                USListBean.DataBean.ComingBean recomList = recomData.get(position);
                holder.tv_nm.setText(recomList.getNm());
                holder.tv_videoName.setText(recomList.getVideoName());
                String img = recomList.getImg();
                img=img.replace("w.h","165.220");
                Tools.loadImage(context,img,holder.iv_icon);
            }
        }

        @Override
        public int getItemCount() {
            if (recomData != null && recomData.size() > 0) {
                return recomData.size();
            }
            return 0;
        }

        class RecomItem extends RecyclerView.ViewHolder {

            private ImageView iv_icon;
            private TextView tv_nm, tv_videoName;

            public RecomItem(View itemView) {
                super(itemView);
                iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
                tv_nm = (TextView) itemView.findViewById(R.id.tv_nm);
                tv_videoName = (TextView) itemView.findViewById(R.id.tv_videoName);
            }
        }
    }
}