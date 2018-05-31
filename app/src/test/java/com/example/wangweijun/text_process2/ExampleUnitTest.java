package com.example.wangweijun.text_process2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

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

    @Test
    public void test3(){
        ArrayList list = new ArrayList();        //创建集合对象
        list.add(new Person("张三", 23));
        list.add(new Person("张三", 23));
        list.add(new Person("李四", 24));
        list.add(new Person("李四", 24));
        list.add(new Person("李四", 24));
        list.add(new Person("李四", 24));
        ArrayList newList = getSingle(list);      //调用方法去除重复
        System.out.println(newList);
//        list.remove(new Person("张三", 23));
//        System.out.println(list);
    }

    public static ArrayList getSingle(ArrayList list) {
        ArrayList tempList = new ArrayList<>();          //1,创建新集合
        Iterator it = list.iterator();              //2,根据传入的集合(老集合)获取迭代器
        while(it.hasNext()) {                  //3,遍历老集合
            Object obj = it.next();                //记录住每一个元素
            if(!tempList.contains(obj)) {            //如果新集合中不包含老集合中的元素
                tempList.add(obj);                //将该元素添加
            }
        }
        return tempList;
    }

}