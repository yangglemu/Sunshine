package com.soft.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DataAdapter extends BaseAdapter {
    protected ArrayList<HashMap<String, String>> mData;
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected int[] mColors;

    public DataAdapter(Context context) {
        mData = new ArrayList<>();
        mContext = context;
        mInflater = LayoutInflater.from(context);
        initData();
    }

    protected abstract void initData();

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
