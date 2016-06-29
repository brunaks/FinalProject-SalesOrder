package com.brunaks.finalproject_salesorder;

import android.annotation.TargetApi;
import android.app.Activity;
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

import cz.msebera.android.httpclient.Header;

/**
 * Created by Bruna Koch Schmitt on 29/06/2016.
 */
public class SumsToPayAdapter extends ArrayAdapter{

    public final Activity context;
    JSONArray response;

    public SumsToPayAdapter(Activity context ) {
        super(context, R.layout.list);

        this.context = context;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/listSumsToPay", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                for (int index = 0; index < response.length(); index++) {
                    try {
                        SumsToPayAdapter.super.addAll(response.get(index));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                SumsToPayAdapter.this.response =  response;
                SumsToPayAdapter.super.notifyDataSetChanged();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.list, null, true);

        JSONObject sumToReceive = new JSONObject();
        TextView sum = (TextView) rowView.findViewById(R.id.name);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        image.setImageResource(R.mipmap.financials);

        try {
            sumToReceive = response.getJSONObject(position);
            sum.setText(sumToReceive.getString("payDate").concat(" R$").concat(sumToReceive.getString("sumToPay")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowView;
    };
}
