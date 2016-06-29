package com.brunaks.finalproject_salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListSumsToReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sums_to_receive);

        ListView sumsToReceive = (ListView) findViewById(R.id.sumsToReceive);
        SumsToReceiveAdapter sumsToReceiveAdapter = new SumsToReceiveAdapter(this);
        sumsToReceive.setAdapter(sumsToReceiveAdapter);
    }
}
