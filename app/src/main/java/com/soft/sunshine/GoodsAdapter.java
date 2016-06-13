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
            map.put("id", i + "");
            map.put("sj", (i + 10) + ".00");
            map.put("sl", "9");
            map.put("zq", 1 + ".00");
            mData.add(map);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.goods_item, parent);
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.Goods_id);
            holder.sj = (TextView) convertView.findViewById(R.id.Goods_sj);
            holder.sl = (TextView) convertView.findViewById(R.id.Goods_sl);
            holder.zq = (TextView) convertView.findViewById(R.id.Goods_zq);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Map<String, String> map = mData.get(position);
        holder.id.setText(map.get("id"));
        holder.sj.setText(map.get("sj"));
        holder.sl.setText(map.get("sl"));
        holder.zq.setText(map.get("zq"));
        return convertView;
    }

    private static class ViewHolder {
        TextView id,sj,sl,zq;
    }
}
