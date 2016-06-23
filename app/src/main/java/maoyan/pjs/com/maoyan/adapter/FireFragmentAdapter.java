package maoyan.pjs.com.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;

/**
 * Created by pjs984312808 on 2016/6/21.
 */
public class FireFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    //模拟数据
    public String [] texts={"java","python","C++","Php",".NET","js","Ruby","Swift","OC"};

    private int[] vpImage=new int[]{
            R.mipmap.vp3,
            R.mipmap.vp5
    };

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mHeaderCount=1;//头部View个数
    public FireFragmentAdapter(Context context) {
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
        int dataItemCount = getContentItemCount();
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
            textView=(TextView)itemView.findViewById(R.id.tv_title);
        }
    }
    //头部 ViewHolder
    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        private ViewPager fire_viewpager;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            fire_viewpager = (ViewPager) itemView.findViewById(R.id.fire_viewpager);
            fire_viewpager.setAdapter(new MyViewPager());
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==ITEM_TYPE_HEADER) {
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
            ((ContentViewHolder) holder).textView.setText(texts[position - mHeaderCount]);
        }
    }
    @Override
    public int getItemCount() {
//        return mHeaderCount + getContentItemCount() + mBottomCount;
        return mHeaderCount + getContentItemCount();
    }


     class MyViewPager extends PagerAdapter {

        @Override
        public int getCount() {
            return vpImage.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int id= vpImage[position];
            ImageView image=new ImageView(mContext);
            image.setBackgroundResource(id);
            container.addView(image);
            return image;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
/*public class FireFragmentAdapter extends RecyclerView.Adapter<FireFragmentAdapter.MyViewHolder>{


    private final Context context;

    public FireFragmentAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder= new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fire,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_title;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}*/
