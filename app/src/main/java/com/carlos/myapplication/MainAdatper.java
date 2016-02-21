package com.carlos.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlos on 15/12/8.
 */
public class MainAdatper extends BaseAdapter {
    private List<MianModel> datas;
    private Context context;

    public MainAdatper(Context context, List<MianModel> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(((MianModel) datas.get(position)).string + position);
        return convertView;
    }
}
