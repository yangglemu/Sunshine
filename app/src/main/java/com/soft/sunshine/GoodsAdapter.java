package com.soft.sunshine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GoodsAdapter extends DataAdapter {
    public GoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void initData() {
        for (int i = 1; i < 39; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("tm", "010102019");
            map.put("pm", "男款衬衣短袖");
            map.put("sj", "19.00");
            map.put("kc", "33");
            mData.add(map);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.goods_item, null);
            holder = new ViewHolder();
            holder.tm = (TextView) convertView.findViewById(R.id.Goods_tm);
            holder.pm = (TextView) convertView.findViewById(R.id.Goods_pm);
            holder.sj = (TextView) convertView.findViewById(R.id.Goods_sj);
            holder.kc = (TextView) convertView.findViewById(R.id.Goods_kc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Map<String, String> map = mData.get(position);
        holder.tm.setText(map.get("tm"));
        holder.pm.setText(map.get("pm"));
        holder.sj.setText(map.get("sj"));
        holder.kc.setText(map.get("kc"));
        return convertView;
    }

    private static class ViewHolder {
        TextView tm, pm, sj, kc;
    }
}
