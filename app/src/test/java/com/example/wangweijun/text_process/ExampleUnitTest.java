package com.example.wangweijun.text_process;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

    // packagename_classname全名_qiku_process_enhance
        String s = "com.example.text_process_"+"com.example.wangweijun.text_process.ACustomTextProcessingActivity"+"_qiku_process_text_enhance";
        System.out.println(s);
        String re = MD5Util.md5(s);
        System.out.println(re);
    }
}