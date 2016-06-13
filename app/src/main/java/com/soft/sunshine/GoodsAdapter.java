package com.soft.sunshine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class GoodsAdapter extends DataAdapter {
    public GoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void initData() {
        SQLiteHelper helper = new SQLiteHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select sj,sl,zq from goods", null);
        int index = 0;
        while (cursor.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", ++index + "");
            map.put("sj", cursor.getInt(0) + ".00");
            map.put("sl", cursor.getInt(1) + "");
            map.put("zq", cursor.getFloat(2)+".00");
            mData.add(map);
        }
        if(index==0){
            Toast.makeText(mContext,"Table goods has no data",Toast.LENGTH_SHORT).show();
        }
        cursor.close();
        db.close();
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
