package com.soft.sunshine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import javax.mail.Quota;

public class SaleDBAdapter extends DataAdapter {
    public SaleDBAdapter(Context context) {
        super(context);
    }

    @Override
    protected void initData() {
        SQLiteHelper helper = new SQLiteHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select sl,je,rq from sale_db", null);
        int index = 0;
        while (cursor.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", ++index + "");
            map.put("sl", cursor.getInt(0) + "");
            map.put("je", cursor.getInt(1) + ".00");
            map.put("rq", cursor.getString(2));
            mData.add(map);
            mColors[0]= mContext.getResources().getColor(R.color.colorRow0);
            mColors[1]=mContext.getResources().getColor(R.color.colorRow1);
        }
        if (index == 0) {
            Toast.makeText(mContext, "Table sale_db has no data", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
        db.close();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.saledb_item, null);
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
        convertView.setBackgroundColor(mColors[position % 2]);
        HashMap<String, String> map = mData.get(position);
        holder.id.setText(map.get("id"));
        holder.sl.setText(map.get("sl"));
        holder.je.setText(map.get("je"));
        holder.rq.setText(map.get("rq"));
        return convertView;
    }

    private static class ViewHolder {
        TextView id, sl, je, rq;
    }
}
