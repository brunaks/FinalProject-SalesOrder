package com.brunaks.finalproject_salesorder;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainFinancialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_financials);

        FloatingActionButton sumsToReceive = (FloatingActionButton) findViewById(R.id.showSumsToReceive);
        sumsToReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createCustomer = new Intent(MainFinancialsActivity.this, ListSumsToReceiveActivity.class);
                startActivity(createCustomer);
            }
        });

        FloatingActionButton sumsToPay = (FloatingActionButton) findViewById(R.id.showSumsToPay);
        sumsToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createCustomer = new Intent(MainFinancialsActivity.this, ListSumsToPayActivity.class);
                startActivity(createCustomer);
            }
        });

        setTotalToReceive();
        setTotalToPay();
        setBalance();
    }

    public void setTotalToReceive() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/getTotalToReceive", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                TextView totalToReceiveTextView = (TextView) findViewById(R.id.totalToReceive);
                try {
                    String total = response.getString("totalToReceive");
                    totalToReceiveTextView.setText(total);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });
    }

    public void setTotalToPay() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/getTotalToPay", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                TextView totalToPayTextView = (TextView) findViewById(R.id.totalToPay);
                try {
                    String total = response.getString("totalToPay");
                    totalToPayTextView.setText(total);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });
    }

    public void setBalance() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/getBalance", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                TextView balanceTextView = (TextView) findViewById(R.id.balance);
                try {
                    String total = response.getString("balance");
                    balanceTextView.setText(total);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });
    }
}
