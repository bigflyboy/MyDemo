package com.wangzhiyuan.mydemo.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wangzhiyuan.lib_annotation.BindView;
import com.wangzhiyuan.mydemo.R;

public class AnnotationActivity extends AppCompatActivity {

    @BindView(R.id.text0)
    TextView tv;

    @BindView(R.id.text1)
    TextView tv1;

    @BindView(R.id.text2)
    TextView tv2;

    @BindView(R.id.text3)
    TextView tv3;

    @BindView(R.id.text4)
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
    }
}
