package com.example.wangweijun.text_process2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }


    private void init() {
        Intent intent = getIntent();
        StringBuilder sb = new StringBuilder();
        if (intent != null) {
            CharSequence text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
            String packageName = intent.getStringExtra(Intent.EXTRA_PACKAGE_NAME);
            boolean fromweb = intent.getBooleanExtra("from_web", false);
            sb.append(text).append(", pkg: ").append(packageName).append(", from web ? ").append(fromweb);
            Log.i("wang", "sb:"+sb.toString());
        }
        ((TextView)findViewById(R.id.content)).setText(sb.toString());
    }
}
