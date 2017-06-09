package com.hdl.eloglibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hdl.elog.ELog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ELog.e(System.currentTimeMillis());
        ELog.e(this);
        ELog.file("log","打印日志到文件中.....");
        ELog.setIsDebug(false);
    }
}



















