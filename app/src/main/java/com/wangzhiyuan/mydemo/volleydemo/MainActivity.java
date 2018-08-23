package com.wangzhiyuan.mydemo.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wangzhiyuan.mydemo.R;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private String mUrl = "https://www.baidu.com/";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequestQueue = Volley.newRequestQueue(this);
        mTextView = findViewById(R.id.text);
    }

    public void requestVolley(View v){
        StringRequest stringRequest = new StringRequest(mUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(error + "");
            }
        });
        mRequestQueue.add(stringRequest);
    }
}
