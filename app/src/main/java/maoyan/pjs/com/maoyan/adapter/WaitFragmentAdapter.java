package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/22.
 */


public class WaitFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final Context mContext;
    private LayoutInflater inflater;
    //模拟数据
    public String [] texts={"java","python","C++","Php",".NET","js","Ruby","Swift","OC"};

    public WaitFragmentAdapter(Context context) {
        this.mContext=context;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_wait_title, parent, false);
            return new HeaderHolder(view);
        }else if(viewType==1) {
            View view =inflater.inflate(R.layout.item_correcycler1,parent,false);
            return new CroRecyclerHolder1(view);
        }else if(viewType==2) {
            View view=inflater.inflate(R.layout.item_correcycler2,parent,false);
            return  new CroRecyclerHolder2(view);
        }

        View view =LayoutInflater.from(mContext).inflate(R.layout.item_wait, parent, false);
        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(position==0) {
            return;
        }else if(position==1) {
            return;
        }else if(position==2) {
            return;
        }
        ((ContentHolder) holder).tv_wait_title.setText(texts[position-3]);

    }

    @Override
    public int getItemCount() {
        return texts.length+3;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0) {
            return 0;
        }else if(position==1) {
            return 1;
        }else if(position==2) {
            return 2;
        }
            return 3;
    }

    /**
     * 搜索框Item
     */
    class HeaderHolder extends RecyclerView.ViewHolder{

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 横向recycler1
     */
    class CroRecyclerHolder1 extends RecyclerView.ViewHolder{

        public CroRecyclerHolder1(View itemView) {
            super(itemView);
        }
    }

    /**
     * 横向recycler1
     */
    class CroRecyclerHolder2 extends RecyclerView.ViewHolder{

        public CroRecyclerHolder2(View itemView) {
            super(itemView);
        }
    }


    /**
     * 竖向recycler
     */
   public class ContentHolder extends RecyclerView.ViewHolder{

        public TextView tv_wait_title;
        public ContentHolder(View itemView) {
            super(itemView);
            tv_wait_title = (TextView) itemView.findViewById(R.id.tv_wait_title);
        }
    }
    
}


/*public class WaitFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    //模拟数据
    public String [] texts={"java","python","C++","Php",".NET","js","Ruby","Swift","OC"};
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mHeaderCount=1;//头部View个数
    public WaitFragmentAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    //内容长度
    public int getContentItemCount(){
        return texts.length;
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
    //内容 ViewHolder
    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv_wait_title);
        }
    }
    //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.item_wait_title, parent, false));
        } else if (viewType == mHeaderCount) {
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_wait, parent, false));
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textView.setText(texts[position - mHeaderCount]);
        }
    }
    @Override
    public int getItemCount() {
//        return mHeaderCount + getContentItemCount() + mBottomCount;
        return mHeaderCount + getContentItemCount();
    }
}*/
