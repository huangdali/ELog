package com.hdl.eloglibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hdl.elog.ELog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ELog.hdl("haha");
        ELog.file("mylog.txt","我是打印的具体内" +
                "容");
        ELog.hdl("打印完成了");
    }
}
