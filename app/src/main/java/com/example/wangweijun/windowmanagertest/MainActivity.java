package com.example.wangweijun.windowmanagertest;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText custom_memu_edittext, custom_memu_edittext2;
    private TextView custom_memu_textview, custom_memu_textview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom_memu_edittext=(EditText)findViewById(R.id.custom_memu_edittext);
        custom_memu_edittext2=(EditText)findViewById(R.id.custom_memu_edittext2);
        custom_memu_textview = (TextView)findViewById(R.id.custom_memu_textview);
        custom_memu_textview2 = (TextView)findViewById(R.id.custom_memu_textview2);
        initCallback();
        initCallback2();

    }

    private void initCallback() {
        ActionMode.Callback2 textSelectionActionModeCallback;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            textSelectionActionModeCallback = new ActionMode.Callback2() {
                @Override
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {// onCreateActionMode 与 onPrepareActionMode一起改
//                    MenuInflater menuInflater = actionMode.getMenuInflater();
//                    menuInflater.inflate(R.menu.selection_action_menu,menu);
//                    return true;//返回false则不会显示弹窗

                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
//                    return false;

                    MenuInflater menuInflater = actionMode.getMenuInflater();
                    menu.clear();
                    menuInflater.inflate(R.menu.selection_action_menu,menu);
                    return true;
                }

                @Override
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
                    //根据item的ID处理点击事件
                    switch (item.getItemId()){
                        case R.id.Informal22:
                            Toast.makeText(MainActivity.this, "点击的是22", Toast.LENGTH_SHORT).show();
                            actionMode.finish();//收起操作菜单
                            break;
                        case R.id.Informal33:
                            Toast.makeText(MainActivity.this, "点击的是33", Toast.LENGTH_SHORT).show();
                            actionMode.finish();
                            break;
                    }
                    return false;// UI都是自定义的菜单加上系统的菜单,只是点击作用问题
//                    return true;//返回true则系统的"复制"、"搜索"之类的item将无效，只有自定义item有响应
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {

                }

                @Override
                public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
                    //可选  用于改变弹出菜单的位置
                    super.onGetContentRect(mode, view, outRect);
                }
            };
            custom_memu_edittext.setCustomSelectionActionModeCallback(textSelectionActionModeCallback);
            custom_memu_textview.setCustomSelectionActionModeCallback(textSelectionActionModeCallback);
        }
    }


    private void initCallback2() {
        ActionMode.Callback2 textSelectionActionModeCallback;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            textSelectionActionModeCallback = new ActionMode.Callback2() {
                @Override
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {// onCreateActionMode 与 onPrepareActionMode一起改
//                    MenuInflater menuInflater = actionMode.getMenuInflater();
//                    menuInflater.inflate(R.menu.selection_action_menu,menu);
                    return true;//返回false则不会显示弹窗

//                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;

//                    MenuInflater menuInflater = actionMode.getMenuInflater();
//                    menu.clear();
//                    menuInflater.inflate(R.menu.selection_action_menu,menu);
//                    return true;
                }

                @Override
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
                    //根据item的ID处理点击事件
                    switch (item.getItemId()){
                        case R.id.Informal22:
                            Toast.makeText(MainActivity.this, "点击的是22", Toast.LENGTH_SHORT).show();
                            actionMode.finish();//收起操作菜单
                            break;
                        case R.id.Informal33:
                            Toast.makeText(MainActivity.this, "点击的是33", Toast.LENGTH_SHORT).show();
                            actionMode.finish();
                            break;
                    }
                    return false;// UI都是自定义的菜单加上系统的菜单,只是点击作用问题
//                    return true;//返回true则系统的"复制"、"搜索"之类的item将无效，只有自定义item有响应
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {

                }

                @Override
                public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
                    //可选  用于改变弹出菜单的位置
                    super.onGetContentRect(mode, view, outRect);
                }
            };
            custom_memu_textview2.setCustomSelectionActionModeCallback(textSelectionActionModeCallback);
            custom_memu_edittext2.setCustomSelectionActionModeCallback(textSelectionActionModeCallback);
        }
    }
}
