package com.wangzhiyuan.mydemo.arouterdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wangzhiyuan.mydemo.R;

public class ArouterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);
    }

    public void onClick(View v){
        if(v.getId() == R.id.activity1){
            ARouter.getInstance().build("/test/activity").navigation();
        } else if(v.getId() == R.id.activity_module){
            ARouter.getInstance().build("/module1/activity").navigation();
        } else if (v.getId() == R.id.activity_init){
            ARouter.init(getApplication());
        }
    }

}
