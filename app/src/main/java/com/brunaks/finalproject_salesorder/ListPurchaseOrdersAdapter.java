package com.brunaks.finalproject_salesorder;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
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
public class ListPurchaseOrdersAdapter extends ArrayAdapter {

    public final Activity context;
    public final MainPurchaseOrderActivity purchaseOrderActivity;
    JSONArray response;

    public ListPurchaseOrdersAdapter(Activity context, final ProgressDialog progressDialog) {
        super(context, R.layout.list);

        this.context = context;
        this.purchaseOrderActivity = (MainPurchaseOrderActivity) context;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/listPurchaseOrders", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                ListPurchaseOrdersAdapter.this.purchaseOrderActivity.setPurchaseOrderData(response);
                for (int index = 0; index < response.length(); index++) {
                    try {
                        ListPurchaseOrdersAdapter.super.addAll(response.get(index));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ListPurchaseOrdersAdapter.this.response =  response;
                progressDialog.dismiss();
                ListPurchaseOrdersAdapter.super.notifyDataSetChanged();
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

        JSONObject order = new JSONObject();
        TextView orderText = (TextView) rowView.findViewById(R.id.name);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        image.setImageResource(R.mipmap.purchase_order);

        try {
            order = response.getJSONObject(position);
            String orderDateAndTotal = order.getString("date").concat(" ").concat("R$").concat(order.getString("total"));
            orderText.setText(orderDateAndTotal);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowView;
    };
}
