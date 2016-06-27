package com.brunaks.finalproject_salesorder;

import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class CustomerDetailActivity extends AppCompatActivity {

    public static final String CUSTOMER_DATA = "customerData";
    JSONObject customerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        try {
            customerData = new JSONObject(getIntent().getStringExtra(CUSTOMER_DATA));
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.setData(customerData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
