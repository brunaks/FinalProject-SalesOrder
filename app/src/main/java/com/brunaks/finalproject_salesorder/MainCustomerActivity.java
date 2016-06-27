package com.brunaks.finalproject_salesorder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainCustomerActivity extends AppCompatActivity {

    public ListView list;
    private JSONArray customersData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_customer);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createCustomer = new Intent(MainCustomerActivity.this, CreateCustomerActivity.class);
                startActivity(createCustomer);
            }
        });*/

        Button button = (Button) findViewById(R.id.floatingButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createCustomer = new Intent(MainCustomerActivity.this, CreateCustomerActivity.class);
                startActivity(createCustomer);
            }
        });

        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();

        ListCustomersAdapter adapter = new ListCustomersAdapter(this, progress);

        list = (ListView) findViewById(R.id.listCustomers);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    JSONObject customerData = customersData.getJSONObject(position);
                    Intent customerDetail = new Intent(MainCustomerActivity.this, CustomerDetailActivity.class);
                    customerDetail.putExtra(CustomerDetailActivity.CUSTOMER_DATA, customerData.toString());
                    startActivity(customerDetail);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setCustomersData(JSONArray customersData) {
        this.customersData = customersData;
    }
}
