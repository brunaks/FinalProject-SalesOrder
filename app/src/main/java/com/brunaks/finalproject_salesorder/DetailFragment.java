package com.brunaks.finalproject_salesorder;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brunaks.finalproject_salesorder.R;

import org.json.JSONObject;

public class DetailFragment extends ListFragment {

    public JSONObject data;

    public DetailFragment() {
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)  {
        super.onActivityCreated(savedInstanceState);
        CustomDetailAdapter adapter = new CustomDetailAdapter(getActivity(), data);
        setListAdapter(adapter);
    }
}
