package com.brunaks.finalproject_salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListSumsToPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sums_to_pay);

        ListView sumsToPay = (ListView) findViewById(R.id.sumsToPay);
        SumsToPayAdapter sumsToPayAdapter = new SumsToPayAdapter(this);
        sumsToPay.setAdapter(sumsToPayAdapter);
    }
}
