package com.brunaks.finalproject_salesorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    public ListView list;
    public String[] items = new String[5];

    public Integer[] images = new Integer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        items = getResources().getStringArray(R.array.menuItens);
        images[0] = R.mipmap.add_customer;
        images[1] = R.mipmap.add_product;
        images[2] = R.mipmap.sales_order;
        images[3] = R.mipmap.purchase_order;
        images[4] = R.mipmap.financials;

        CustomMenuAdapter adapter = new CustomMenuAdapter(this, items, images);

        list = (ListView) findViewById(R.id.menuItens);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem= items[position];

                switch (position) {
                    case 0:
                        Intent customerIntent = new Intent(MainMenu.this, MainCustomerActivity.class);
                        startActivity(customerIntent);
                        break;
                    case 1:
                        Intent productIntent = new Intent(MainMenu.this, MainProductActivity.class);
                        startActivity(productIntent);
                        break;
                }
            }
        });
    }
}
