package com.example.wangweijun.text_process2;

import android.util.Base64;

import java.security.MessageDigest;

public class MD5Util {


    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(s.getBytes("utf-8"));
            return Base64.encodeToString(md5, Base64.DEFAULT);
        } catch (Exception e) {
            return null;
        }
    }
}
