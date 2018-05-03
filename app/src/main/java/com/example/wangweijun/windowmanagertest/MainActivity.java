package com.example.wangweijun.windowmanagertest;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = null;

    String permission = Manifest.permission.SYSTEM_ALERT_WINDOW;// ;  // Manifest.permission.WRITE_EXTERNAL_STORAGE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (addPermission(this, permission)) {//
//            ActivityCompat.requestPermissions(this,
//                    new String[]{permission}, 1);
//        }


        mHandler = new Handler();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        WindowUtils.showPopupWindow(MainActivity.this);
//                    }
//                }, 1000 * 3);

//                Intent intent = new Intent("com.example.activity.ACTION_START");
//                intent.addCategory("xxxxxxxxxx");
//                startActivity(intent);

                TestReflect.testReflect();
                Log.i(TAG, "#########################");
                TestPrivateConstructorReflect.test();
                Log.i(TAG, "#########################");
                TestReflect.testReflectActivityThread();
                Log.i(TAG, "#########################");
                TestReflect.testReflectActivityInOtherApp();
                Log.i(TAG, "+++++++++++++++++++");
                TestReflect.testReflectActivityInOtherApp2();
            }
        });
    }
    public static final String TAG = "MainActivity";

}
