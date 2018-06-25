package com.example.wangweijun.text_process2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testTextview(View v) {
        startActivity(new Intent(getApplicationContext(), ProcessTextviewActivity.class));
    }

    public void testWebview(View v) {
        startActivity(new Intent(getApplicationContext(), ProcessWebviewActivity.class));
    }

}
