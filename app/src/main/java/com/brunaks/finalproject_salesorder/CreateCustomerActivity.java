package com.brunaks.finalproject_salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class CreateCustomerActivity extends AppCompatActivity {

    private JSONObject customerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer);

        //Button registerButton = (Button) findViewById(R.id.create_customer);
        //assert registerButton != null;
        //registerButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        AsyncHttpClient client = new AsyncHttpClient();
        //        String url = "bruna-webstore.herokuapp.com/registerCustomer";
        //        createCustomerData();
        //        StringEntity entity = null;
        //        try {
        /*            entity = new StringEntity(CreateCustomerActivity.this.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                client.post(CreateCustomerActivity.this, url, entity, "application/json", new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast toast = new Toast(CreateCustomerActivity.this);
                        toast.makeText(CreateCustomerActivity.this, R.string.customer_create_success, Toast.LENGTH_SHORT);
                        finish();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        String response = responseBody.toString();
                        Toast.makeText(CreateCustomerActivity.this, response, Toast.LENGTH_LONG);
                    }
                });
            }
        });*/
    }

    public void createCustomerData() {
        /*EditText name = (EditText) findViewById(R.id.addCustomerName);
        EditText cpf = (EditText) findViewById(R.id.addCustomerCpf);
        EditText phone = (EditText) findViewById(R.id.addCustomerPhone);
        EditText address = (EditText) findViewById(R.id.addCustomerAddress);

        this.customerData = new JSONObject();
        try {
            customerData.put("name", name.getText().toString());
            customerData.put("cpf", cpf.getText().toString());
            customerData.put("telephoneNumber", phone.getText().toString());
            customerData.put("address", address.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}
