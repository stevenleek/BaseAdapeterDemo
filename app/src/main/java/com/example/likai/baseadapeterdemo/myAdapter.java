package com.example.likai.baseadapeterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by likai on 15/4/29.
 */
//创建适配器，并从数据源中获取数据，通常通过创建构造方法对数据进行初始化来实现获取数据；
public class myAdapter extends BaseAdapter {
    //创建成员变量mList用来保存传递进来的数据源数据;
    private List<ItemBean> mList;

    private LayoutInflater inflater;
    //将数据元与数据适配器进行关联:
    public myAdapter(Context context, List<ItemBean> list) {
        mList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = inflater.inflate(R.layout.items, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.image);
//        TextView textView = (TextView) view.findViewById(R.id.title);
//        TextView textView1 = (TextView) view.findViewById(R.id.content);
//        return view;
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.items, null);

            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ItemBean bean = mList.get(position);
        viewHolder.imageView.setImageResource(bean.ItemImageId);
        viewHolder.title.setText(bean.ItemTitle);
        viewHolder.content.setText(bean.ItemContent);
        return convertView;
    }

    //创建内部类viewholder；
    class ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
