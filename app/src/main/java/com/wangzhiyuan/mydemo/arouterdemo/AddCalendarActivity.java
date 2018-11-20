package com.wangzhiyuan.mydemo.arouterdemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.wangzhiyuan.mydemo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddCalendarActivity extends Activity {

    private static final int REQUEST_CALENDAR = 195;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calendar);
    }

    public void addEvent(View v){
        fetchPermission(REQUEST_CALENDAR);
    }

    public void deleteEvent(View v){

    }

    public void fetchPermission(int requestCode) {
        int checkSelfPermission;
        try {
            checkSelfPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return;
        }

        // 如果有授权，走正常插入日历逻辑
        if (checkSelfPermission == PackageManager.PERMISSION_GRANTED) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
            Date remindDate;
            // 指定一个日期
            try {
                remindDate = dateFormat.parse("2018-9-27 13:24:16");
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }
            CalendarReminderUtils.addCalendarEvent(this, "主题","描述",
                    remindDate,1);
            return;
        } else {
            // 如果没有授权，就请求用户授权
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_CALENDAR,
                    Manifest.permission.READ_CALENDAR}, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALENDAR) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
                Date remindDate;
                // 指定一个日期
                try {
                    remindDate = dateFormat.parse("2018-9-27 13:24:16");
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
                CalendarReminderUtils.addCalendarEvent(this, "主题","描述",
                        remindDate,1);
            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_CALENDAR)) {
                    // 如果用户不是点击了拒绝就跳转到系统设置页

                }
            }
        }
    }

}
