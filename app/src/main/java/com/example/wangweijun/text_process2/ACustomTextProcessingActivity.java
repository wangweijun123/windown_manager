package com.example.wangweijun.text_process2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ACustomTextProcessingActivity extends Activity {

    private static final String EXTRA_REMOVABLE =
            "qiku.intent.text_process_enhance.extra.REMOVABLE";
    private static final String EXTRA_SOURCE_PACKAGE =
            "qiku.intent.text_process_enhance.extra.SOURCE_PACKAGE";
    private static final String EXTRA_SOURCE_ACTIVITY =
            "qiku.intent.text_process_enhance.extra.SOURCE_ACTIVITY";
    private static final String EXTRA_POSITION =
            "qiku.intent.text_process_enhance.extra.POSITION";
    private static final String EXTRA_MENU_TITLE =
            "qiku.intent.text_process_enhance.extra.MENU_TITLE";

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
            boolean removable = intent.getBooleanExtra(EXTRA_REMOVABLE, false);
            CharSequence text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
            String sourcepkg = intent.getStringExtra(EXTRA_SOURCE_PACKAGE);
            String sourceActivity = intent.getStringExtra(EXTRA_SOURCE_ACTIVITY);
            String title = intent.getStringExtra(EXTRA_MENU_TITLE);
            int position = intent.getIntExtra(EXTRA_POSITION, -1);
            sb.append(text).append(", sourcepkg: ").append(sourcepkg)
                    .append(", sourceActivity: ").append(sourceActivity)
                    .append(", position:").append(position)
                    .append(", title:").append(title).append(", removable:"+removable);

            Log.i("wangweijun", "sb:"+sb.toString());
        }
        ((TextView)findViewById(R.id.content)).setText(sb.toString());
    }
}
