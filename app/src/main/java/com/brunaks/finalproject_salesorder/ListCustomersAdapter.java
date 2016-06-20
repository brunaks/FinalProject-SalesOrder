package com.brunaks.finalproject_salesorder;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Bruna Koch Schmitt on 19/06/2016.
 */
public class ListCustomersAdapter extends ArrayAdapter {

    public final Activity context;
    JSONArray response;

    public ListCustomersAdapter(Activity context) {
        super(context, R.layout.list_customers);

        this.context = context;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/listCustomers", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                ListCustomersAdapter.super.addAll(response);
                ListCustomersAdapter.this.response =  response;
                ListCustomersAdapter.super.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.list_customers, null, true);

        JSONObject customer = new JSONObject();
        final TextView customerName = (TextView) rowView.findViewById(R.id.customerName);
        try {
            customer = response.getJSONObject(position);
            customerName.setText(customer.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowView;
    };

}
