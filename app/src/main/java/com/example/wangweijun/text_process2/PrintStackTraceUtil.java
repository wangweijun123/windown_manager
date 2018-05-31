package com.example.wangweijun.text_process2;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintStackTraceUtil {

    /**
     * debug
     */
    public static void printStackTrace() {
        Exception e = new Exception();
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        Log.d("wangweijun", "show action menu stack trace : " + sw.toString());
    }
}
