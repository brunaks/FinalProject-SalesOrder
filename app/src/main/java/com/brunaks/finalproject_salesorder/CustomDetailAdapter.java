package com.brunaks.finalproject_salesorder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brunaks.finalproject_salesorder.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Bruna Koch Schmitt on 26/06/2016.
 */
public class CustomDetailAdapter extends ArrayAdapter {

    public Activity context;
    public JSONObject data;
    public JSONArray array = new JSONArray();

    public CustomDetailAdapter(Activity context, JSONObject data) {
        super(context, R.layout.detail);

        this.context = context;
        this.data = data;
        try {
            Iterator<String> keys = this.data.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = this.data.getString(key);
                JSONObject object = new JSONObject();
                object.put(key, value);
                array.put(object);
            }
            for (int i = 0; i < array.length(); i++) {
                super.add(array.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.detail, null, true);

        JSONObject dataObject = new JSONObject();
        TextView label = (TextView) rowView.findViewById(R.id.label);
        TextView text = (TextView) rowView.findViewById(R.id.text);

        try {
            dataObject = this.array.getJSONObject(position);
            Iterator<String> keys = dataObject.keys();
            String key = keys.next().toString();

            int resourceId = getContext().getResources().getIdentifier(key, "string", getContext().getPackageName());
            String labelText = getContext().getResources().getString(resourceId);
            label.setText(labelText);

            text.setText(dataObject.getString(key));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowView;
    };
}
