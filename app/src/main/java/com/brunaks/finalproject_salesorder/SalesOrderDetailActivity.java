package com.brunaks.finalproject_salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

public class SalesOrderDetailActivity extends AppCompatActivity {

    public static final String DATA = "salesOrderData";
    JSONObject salesOrderData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_detail);

        try {
            salesOrderData = new JSONObject(getIntent().getStringExtra(DATA));
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.setData(salesOrderData);

            ListView itemsList = (ListView) findViewById(R.id.items_list);
            ItemsAdapter itemsAdapter = new SalesOrderItemsAdapter(this, salesOrderData);
            itemsList.setAdapter(itemsAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
