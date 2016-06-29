package com.brunaks.finalproject_salesorder;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bruna Koch Schmitt on 29/06/2016.
 */
public class PurchaseOrderItemsAdapter extends ItemsAdapter{

    public PurchaseOrderItemsAdapter(Activity context, JSONObject purchaseOrderData) {
        super(context, purchaseOrderData);
    }

    public String getUrl() {
        String parameter = null;
        try {
            parameter = data.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "http://bruna-webstore.herokuapp.com/showPurchaseOrderItems?" + parameter;
    }
}
