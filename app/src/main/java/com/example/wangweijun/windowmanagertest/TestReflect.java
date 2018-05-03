package com.example.wangweijun.windowmanagertest;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangweijun on 2018/4/21.
 */

/**
 * 反射只能反射自己apk中的类与系统中的class
 */
public class TestReflect {

    private int privateVar = 1;

    String defaultStr = "aaa";

    private String getPrivateStr(){
        return "bbbbbbbbbb";
    }

    private String getPrivateStr(String str){
        return str;
    }

    public static void testReflect() {
        try {
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            Log.i(MainActivity.TAG, "clazz : " + clazz);
            Method method = clazz.getDeclaredMethod("currentActivityThread");
            Log.i(MainActivity.TAG, "method : " + method);
            Object  activityThreadInstance =  method.invoke(null);
            Log.i(MainActivity.TAG, "activityThreadInstance : " + activityThreadInstance);

//            Object activityThread2 = Class.forName("android.app.ActivityThread").newInstance();
//            Log.i(TAG, "activityThread2 : " + activityThread2);

            Class clazzTestReflect = Class.forName("com.example.wangweijun.windowmanagertest.TestReflect");
            Object object =  clazzTestReflect.newInstance();// 如果是私有构造函数是不能这样new的
            Field field = clazzTestReflect.getDeclaredField("privateVar");
            field.setAccessible(true);// private属性必须设置
            int value = field.getInt(object);
            Field fieldDefaultStr = clazzTestReflect.getDeclaredField("defaultStr");
            String defaultStr = (String)fieldDefaultStr.get(object);
            Method method1 = clazzTestReflect.getDeclaredMethod("getPrivateStr");
            method1.setAccessible(true);// private方法必须设置
            String getPrivateStrReturn = (String)method1.invoke(object);

            Log.i(MainActivity.TAG, "object : " + object + ", privateVar:"+value + ", defaultStr:"+defaultStr+", getPrivateStrReturn():"+getPrivateStrReturn);
            Method method2 = clazzTestReflect.getDeclaredMethod("getPrivateStr", String.class);
            method2.setAccessible(true);
            String withparams = (String)method2.invoke(object, "with params in method");
            Log.i(MainActivity.TAG,"withparams:"+withparams);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public static void testReflectActivityThread() {
        try {
//            Class<?> clazz = Class.forName("android.app.ActivityThread");
//            Log.i(MainActivity.TAG, "clazz : " + clazz);
//            Method method = clazz.getDeclaredMethod("currentActivityThread");
//            Log.i(MainActivity.TAG, "method : " + method);
//            Object  activityThreadInstance =  method.invoke(null);
//            Log.i(MainActivity.TAG, "activityThreadInstance : " + activityThreadInstance);

            Class clazz = Class.forName("android.app.ActivityThread");
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object object = constructor.newInstance();
            Log.i(MainActivity.TAG, "object : " + object);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 不能反射其他app中的类，这也正常，系统肯定不知道app中类叫什么，而且可能同名的话
     * 系统怎么会去调用是吧
     */
    public static void testReflectActivityInOtherApp() {
        try {
            Class<?> clazz = Class.forName("hook.jason.com.androidhook.MainActivity");
            Log.i(MainActivity.TAG, "clazz : " + clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // .java

    public static void testReflectActivityInOtherApp2() {
        try {
            Class<?> clazz = Class.forName("android.content.pm.PackageManager");
            Method[] arr = clazz.getMethods();
            int size = arr.length;
            Log.i(MainActivity.TAG, "arr size: " + size);
            for (int i=0; i<size; i++) {
                Log.i(MainActivity.TAG, i+" : " + arr[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
