package com.soft.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater inflater;
    private LinearLayout mainLayout;
    private View listViewLayout;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = LayoutInflater.from(this);
        mainLayout = (LinearLayout) inflater.inflate(R.layout.main, null);
        setListLayout(R.layout.goods, R.id.listViewGoods, new GoodsAdapter(this));
        setContentView(mainLayout);
        Button titleButtonLeft = (Button) findViewById(R.id.titleButtonLeft);
        assert titleButtonLeft != null;
        titleButtonLeft.setOnClickListener(v->{
            if (lv.getId() == R.id.listViewGoods) {
                setListLayout(R.layout.saledb, R.id.listViewSaleDb, new SaleDBAdapter(this));
            } else {
                setListLayout(R.layout.goods, R.id.listViewGoods, new GoodsAdapter(this));
            }
        });
        Button titleButtonRight = (Button) findViewById(R.id.titleButtonRight);
        assert titleButtonRight != null;
        titleButtonRight.setOnClickListener(v->finish());
    }

    protected void setListLayout(int layoutId, int listViewId, DataAdapter adapter) {
        if (listViewLayout != null)
            mainLayout.removeView(listViewLayout);
        listViewLayout = inflater.inflate(layoutId, null);
        assert listViewLayout != null;
        mainLayout.addView(listViewLayout);
        lv = (ListView) listViewLayout.findViewById(listViewId);
        assert lv != null;
        lv.setAdapter(adapter);
    }
}
