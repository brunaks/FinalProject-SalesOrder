package com.brunaks.finalproject_salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String PRODUCT_DATA = "productData";
    JSONObject productData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        try {
            productData = new JSONObject(getIntent().getStringExtra(PRODUCT_DATA));
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.setData(productData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
