package com.brunaks.finalproject_salesorder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainCustomerActivity extends AppCompatActivity {

    public ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_customer);

        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();

        ListCustomersAdapter adapter = new ListCustomersAdapter(this, progress);

        list = (ListView) findViewById(R.id.listCustomers);
        list.setAdapter(adapter);
    }
}
