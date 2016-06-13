package com.soft.sunshine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class SaleDBAdapter extends DataAdapter {
    public SaleDBAdapter(Context context) {
        super(context);
    }

    @Override
    protected void initData() {
        for (int i = 1; i < 30; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("djh", "20160101122231019");
            map.put("sl", i + "");
            map.put("je", i + ".00");
            map.put("ss", i + ".00");
            map.put("zl", (3 + i) + ".00");
            mData.add(map);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.saledb_item, null);
            assert convertView != null;
            holder = new ViewHolder();
            holder.djh = (TextView) convertView.findViewById(R.id.SaleDb_djh);
            holder.sl = (TextView) convertView.findViewById(R.id.SaleDb_sl);
            holder.je = (TextView) convertView.findViewById(R.id.SaleDb_je);
            holder.ss = (TextView) convertView.findViewById(R.id.SaleDb_ss);
            holder.zl = (TextView) convertView.findViewById(R.id.SaleDb_zl);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, String> map = mData.get(position);
        holder.djh.setText(map.get("djh"));
        holder.sl.setText(map.get("sl"));
        holder.je.setText(map.get("je"));
        holder.ss.setText(map.get("ss"));
        holder.zl.setText(map.get("zl"));
        return convertView;
    }

    private static class ViewHolder {
        TextView djh, sl, je, ss, zl;
    }
}
