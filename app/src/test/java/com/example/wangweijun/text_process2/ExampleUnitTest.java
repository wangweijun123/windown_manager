package com.example.wangweijun.text_process2;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

//        DES.main();
    // packagename_classname全名_qiku_process_text_enhance
        String s = "com.example.text_process2_"+"com.example.wangweijun.text_process2.ACustomTextProcessingActivity"+"_qiku_process_text_enhance";
        System.out.println(s);
        String re = DES.encryptDES(s);
        System.out.println(re);
    }

    @Test
    public void testStringBuilder() throws Exception {
        StringBuilder contentDescription = new StringBuilder();
//        contentDescription.append("xxxx").append("#").append(1).append("#").append("adsf");


        System.out.println(contentDescription.toString());

        System.out.println(contentDescription.delete(0, contentDescription.length()));

        System.out.println("clear :" + contentDescription.toString());


        contentDescription.append("netxt time");

        System.out.println(contentDescription.toString());




    }

    @Test
    public void testStringBuilder2(){
        String secretkey ="ceRgWyYtfvSlJE4AAE8CqQ==";
        String computemd5="ceRgWyYtfvSlJE4AAE8CqQ==";
        System.out.println(secretkey.equals(computemd5));

//        secretkey :ceRgWyYtfvSlJE4AAE8CqQ==, computemd5 :ceRgWyYtfvSlJE4AAE8CqQ==
    }



}