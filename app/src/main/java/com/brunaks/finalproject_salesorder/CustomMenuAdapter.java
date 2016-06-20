package com.brunaks.finalproject_salesorder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bruna Koch Schmitt on 19/06/2016.
 */
public class CustomMenuAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;
    private final Integer[] imageId;

    public CustomMenuAdapter(Activity context, String[] itemName, Integer[] imageId) {
        super(context, R.layout.main_menu, itemName);

        this.context = context;
        this.itemName = itemName;
        this.imageId = imageId;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.main_menu, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(itemName[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    };
}
