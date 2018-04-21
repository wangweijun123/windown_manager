package com.example.wangweijun.windowmanagertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wangweijun on 2018/4/21.
 */

public class SecondActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("SecondActivity", "SecondActivity");

        setContentView(R.layout.popupwindow);
    }
}
