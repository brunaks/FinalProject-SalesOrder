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
 * Created by Bruna Koch Schmitt on 28/06/2016.
 */
public class ListProductsAdapter extends ArrayAdapter{

    public final Activity context;
    public final MainProductActivity productActivity;
    JSONArray response;

    public ListProductsAdapter(Activity context, final ProgressDialog progressDialog) {
        super(context, R.layout.list);

        this.context = context;
        this.productActivity = (MainProductActivity) context;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bruna-webstore.herokuapp.com/products", new JsonHttpResponseHandler() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                ListProductsAdapter.this.productActivity.setProductsData(response);
                for (int index = 0; index < response.length(); index++) {
                    try {
                        ListProductsAdapter.super.addAll(response.get(index));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ListProductsAdapter.this.response =  response;
                progressDialog.dismiss();
                ListProductsAdapter.super.notifyDataSetChanged();
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

        JSONObject product = new JSONObject();
        TextView productName = (TextView) rowView.findViewById(R.id.name);
        ImageView productImage = (ImageView) rowView.findViewById(R.id.image);
        productImage.setImageResource(R.mipmap.add_product);

        try {
            product = response.getJSONObject(position);
            productName.setText(product.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowView;
    };

}
