package com.wangzhiyuan.mydemo.arouterdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wangzhiyuan.mydemo.R;

public class ArouterActivity extends Activity {

    private static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);

        activity = this;
    }

    public void onClick(View v){
        if(v.getId() == R.id.activity1){
            ARouter.getInstance().build("/test/activity").navigation();
        } else if(v.getId() == R.id.activity_module){
            ARouter.getInstance().build("/module1/activity").navigation();
        } else if (v.getId() == R.id.activity_init){
            ARouter.getInstance().build("/module2/activity").navigation();
        } else if (v.getId() == R.id.open_module2_n){
            ARouter.getInstance().build("/module2/activityn").navigation();
        }
    }

    public static Activity getThis() {
        return activity;
    }
}
