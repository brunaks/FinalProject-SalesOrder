package com.brunaks.finalproject_salesorder;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bruna Koch Schmitt on 29/06/2016.
 */
public class SalesOrderItemsAdapter extends ItemsAdapter {

    public SalesOrderItemsAdapter(Activity context, JSONObject salesOrderData) {
        super(context, salesOrderData);
    }

    @Override
    public String getUrl() {
        String parameter = null;
        try {
            parameter = this.data.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://bruna-webstore.herokuapp.com/showSalesOrderItems?" + parameter;
    }
}
