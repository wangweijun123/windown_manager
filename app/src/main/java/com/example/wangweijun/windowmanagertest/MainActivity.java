package com.example.wangweijun.windowmanagertest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = null;

    String permission = Manifest.permission.SYSTEM_ALERT_WINDOW;// ;  // Manifest.permission.WRITE_EXTERNAL_STORAGE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (addPermission(this, permission)) {//
            ActivityCompat.requestPermissions(this,
                    new String[]{permission}, 1);
        }


        mHandler = new Handler();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        WindowUtils.showPopupWindow(MainActivity.this);

                    }
                }, 1000 * 3);

            }
        });
    }


    private boolean addPermission(Activity activity, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    @SuppressLint("Override")
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 如果被允许了，就开始请求下一个

                } else {
                    // 如果被拒绝了，就弹此权限的拒绝弹窗
                }
                break;
        }
    }

}
