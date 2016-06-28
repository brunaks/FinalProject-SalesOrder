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

public class MainProductActivity extends AppCompatActivity {

    public ListView list;
    private JSONArray productsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product);

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

    public void setProductsData(JSONArray productsData) {
        this.productsData = productsData;
    }

    public void refreshAdapter() {

        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();

        ListProductsAdapter adapter = new ListProductsAdapter(this, progress);

        list = (ListView) findViewById(R.id.listProducts);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    JSONObject productData = productsData.getJSONObject(position);
                    Intent productDetail = new Intent(MainProductActivity.this, ProductDetailActivity.class);
                    productDetail.putExtra(ProductDetailActivity.PRODUCT_DATA, productData.toString());
                    startActivity(productDetail);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
