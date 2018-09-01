package com.wangzhiyuan.module2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/module2/activityn")
public class Module2NActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2_n);
    }

    public void onClick(View v){
        ARouter.getInstance().build("/test/activity").navigation();
    }
}
