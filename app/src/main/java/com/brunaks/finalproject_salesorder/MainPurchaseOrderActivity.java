package com.brunaks.finalproject_salesorder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainPurchaseOrderActivity extends AppCompatActivity {

    public ListView list;
    private JSONArray purchaseOrderData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_purchase_order);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingButton);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createProduct = new Intent(MainProductActivity.this, CreateProductActivity.class);
                startActivity(createProduct);
            }
        });*/
    }

    @Override
    public void onResume() {
        super.onResume();

        this.refreshAdapter();
    }

    public void setPurchaseOrderData(JSONArray purchaseOrderData) {
        this.purchaseOrderData = purchaseOrderData;
    }

    public void refreshAdapter() {

        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();

        ListPurchaseOrdersAdapter adapter = new ListPurchaseOrdersAdapter(this, progress);

        list = (ListView) findViewById(R.id.listPurchaseOrders);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    JSONObject data = purchaseOrderData.getJSONObject(position);
                    Intent purchaseOrderDetail = new Intent(MainPurchaseOrderActivity.this, PurchaseOrderDetailActivity.class);
                    purchaseOrderDetail.putExtra(PurchaseOrderDetailActivity.DATA, data.toString());
                    startActivity(purchaseOrderDetail);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
