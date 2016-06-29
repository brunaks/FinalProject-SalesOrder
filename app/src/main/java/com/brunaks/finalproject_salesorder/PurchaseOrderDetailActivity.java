package com.brunaks.finalproject_salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseOrderDetailActivity extends AppCompatActivity {

    public static final String DATA = "purchaseOrderData";
    JSONObject purchaseOrderData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_order_detail);

        try {
            purchaseOrderData = new JSONObject(getIntent().getStringExtra(DATA));
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.setData(purchaseOrderData);

            ListView itemsList = (ListView) findViewById(R.id.items_list);
            ItemsAdapter itemsAdapter = new PurchaseOrderItemsAdapter(this, purchaseOrderData);
            itemsList.setAdapter(itemsAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
