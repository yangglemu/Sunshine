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
            map.put("id",i+"");
            map.put("sl", i + "");
            map.put("je", 297 + ".00");
            map.put("rq", "2016-01-01 12:22:39");
            mData.add(map);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.saledb_item, parent);
            assert convertView != null;
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.SaleDb_id);
            holder.sl = (TextView) convertView.findViewById(R.id.SaleDb_sl);
            holder.je = (TextView) convertView.findViewById(R.id.SaleDb_je);
            holder.rq = (TextView) convertView.findViewById(R.id.SaleDb_rq);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, String> map = mData.get(position);
        holder.id.setText(map.get("id"));
        holder.sl.setText(map.get("sl"));
        holder.je.setText(map.get("je"));
        holder.rq.setText(map.get("rq"));
        return convertView;
    }

    private static class ViewHolder {
        TextView id,sl,je,rq;
    }
}
