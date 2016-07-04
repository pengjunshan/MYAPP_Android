package maoyan.pjs.com.maoyan.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import maoyan.pjs.com.maoyan.R;
import maoyan.pjs.com.maoyan.util.ConstantOb;

/**
 * Created by pjs984312808 on 2016/7/2.
 */
public class CinemaSeverPopWindow extends PopupWindow implements View.OnClickListener {


    private final Context context;
    private LayoutInflater inflater;
    private ListView lv_severleft,lv_severcontent,lv_metro_left,lv_metro_left_content;
    private LinearLayout ll_title;
    private ServerleftAdapter serverAdapter;

    private ContentAdapter contentAdapter;
    private int currentPosition=0;

    //地铁适配器
    private MetroleftAdapter metroleftAdapter;
    private MetroContentAdapter metrocontntAdapter;

    public CinemaSeverPopWindow(Context context) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        initView(context);

        setOnclickListner();
    }

    private void setOnclickListner() {
    }

    @SuppressWarnings("deprecation")
    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.pop_cinema, null);
        ll_title = (LinearLayout) rootView.findViewById(R.id.ll_title);
        lv_severleft = (ListView) rootView.findViewById(R.id.lv_severleft);
        lv_severcontent = (ListView) rootView.findViewById(R.id.lv_severcontent);
        lv_metro_left = (ListView) rootView.findViewById(R.id.lv_metro_left);
        lv_metro_left_content = (ListView) rootView.findViewById(R.id.lv_metro_left_content);
        setContentView(rootView);
        //设置背景为透明色
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        setBackgroundDrawable(dw);
        setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        setFocusable(true);
        setTouchable(true);
        rootView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int height = v.findViewById(R.id.ll_title).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y > height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        initData();
    }

    private void initData() {
        serverAdapter =new ServerleftAdapter(context, ConstantOb.leftStrings);
        lv_severleft.setAdapter(serverAdapter);

        contentAdapter=new ContentAdapter(context,ConstantOb.adminis);
        lv_severcontent.setAdapter(contentAdapter);

        lv_severleft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] contents=null;
                currentPosition=position;
                serverAdapter.notifyDataSetChanged();
                switch (position){
                    case 0:
                        contents=ConstantOb.adminis;
                        setVisibiliti();
                        notifyData(contents);
                        break;
                    case 1:
                        //隐藏
                        lv_severcontent.setVisibility(View.GONE);
                        //显示地铁内容
                        lv_metro_left.setVisibility(View.VISIBLE);
                        lv_metro_left_content.setVisibility(View.VISIBLE);
                        metroleftAdapter=new MetroleftAdapter(context,ConstantOb.metrolefts);
                        lv_metro_left.setAdapter(metroleftAdapter);
                        metrocontntAdapter=new MetroContentAdapter(context,ConstantOb.metrocontents);
                        lv_metro_left_content.setAdapter(metrocontntAdapter);
                        break;
                    case 2:
                        contents=ConstantOb.specials;
                        setVisibiliti();
                        notifyData(contents);
                        break;
                    case 3:
                        contents=ConstantOb.brands;
                        setVisibiliti();
                        notifyData(contents);
                        break;
                    case 4:
                        contents=ConstantOb.serverces;
                        setVisibiliti();
                        notifyData(contents);
                        break;
                }

            }
        });

        lv_metro_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                }
            }
        });
    }

    private void notifyData(String[] contents) {
        contentAdapter.setData(contents);
        contentAdapter.notifyDataSetChanged();
    }

    private void setVisibiliti() {
        //显示
        lv_severcontent.setVisibility(View.VISIBLE);
        //隐藏地铁内容
        lv_metro_left.setVisibility(View.GONE);
        lv_metro_left_content.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View v) {

    }

    /**
     * 地铁适配器头
     */
    class MetroleftAdapter extends BaseAdapter{

        private final Context context;
        private final String[] metrolefts;

        public MetroleftAdapter(Context context, String[] metrolefts) {
            this.context=context;
            this.metrolefts=metrolefts;
        }

        @Override
        public int getCount() {
            return metrolefts.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(convertView==null) {
                viewHolder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.item_cinemapopcontent,parent,false);
                viewHolder.iv_title= (TextView) convertView.findViewById(R.id.iv_title);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            viewHolder.iv_title.setText(metrolefts[position]);
            return convertView;
        }
        class ViewHolder{
         TextView iv_title;
        }
    }

    /**
     * 地铁内容适配器
     */
    class MetroContentAdapter extends BaseAdapter{

        private final Context context;
        private final String[] metrocontents;

        public MetroContentAdapter(Context context, String[] metrocontents) {
            this.context=context;
            this.metrocontents=metrocontents;
        }

        @Override
        public int getCount() {
            return metrocontents.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(convertView==null) {
                viewHolder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.item_cinemapopcontent,parent,false);
                viewHolder.iv_title= (TextView) convertView.findViewById(R.id.iv_title);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            viewHolder.iv_title.setText(metrocontents[position]);
            return convertView;
        }
        class ViewHolder{
            TextView iv_title;
        }
    }

    /**
     * 服务内容适配器
     */
    class ContentAdapter extends BaseAdapter{


        private final Context context;
        private String[] contents;

        public ContentAdapter(Context context, String[] contents) {
            this.context=context;
            this.contents=contents;
        }

        @Override
        public int getCount() {
            return contents.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null) {
                holder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.item_cinemapopcontent,parent,false);
                holder.iv_title= (TextView) convertView.findViewById(R.id.iv_title);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }


            holder.iv_title.setText(contents[position]);
            return convertView;
        }

        public void setData(String[] contents) {
            this.contents=contents;
        }

        class ViewHolder{
            TextView iv_title;
        }
    }

    /**
     * 服务类型适配器
     */
    class ServerleftAdapter extends BaseAdapter {

        private final Context context;
        private final String[] leftData;

        public ServerleftAdapter(Context context, String[] leftStrings) {
            this.context=context;
            this.leftData=leftStrings;
        }

        @Override
        public int getCount() {
            return leftData.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null) {
                holder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.item_left,parent,false);
                holder.iv_title= (TextView) convertView.findViewById(R.id.iv_title);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            if(currentPosition==position) {
                holder.iv_title.setEnabled(true);
                holder.iv_title.setTextColor(Color.RED);
                convertView.setBackgroundColor(Color.WHITE);
                holder.iv_title.setBackgroundColor(Color.WHITE);
            }else {
                holder.iv_title.setEnabled(false);
                holder.iv_title.setTextColor(Color.BLACK);
                convertView.setBackgroundColor(Color.parseColor("#FAFAFA"));
                holder.iv_title.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
            holder.iv_title.setText(leftData[position]);
            return convertView;
        }

        class ViewHolder{
            TextView iv_title;
        }
    }


}
