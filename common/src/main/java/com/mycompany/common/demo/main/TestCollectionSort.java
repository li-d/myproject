package com.mycompany.common.demo.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestCollectionSort {


    public static void main(String[] args) throws InterruptedException {

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("a");
        stringList2.add("aed");
        stringList2.add("ab");
        System.out.println("原数组:" + stringList2);
        stringList2.sort(Comparator.comparingInt(String::length));
        System.out.println("正序排序:" + stringList2);
        stringList2.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("倒序排序:" + stringList2);

        //集合转数组
        String[] strings = stringList2.toArray(new String[stringList2.size()]);
        System.out.println(Arrays.toString(strings));

        //数组转集合
        String[] strs = new String[]{"121", "21313", "12313"};
        List<String> stringList = Arrays.asList(strs);
        System.out.println(stringList.toString());

        //测试数组截取
        List<String> stringList3 = new ArrayList<>();
        stringList3.add("a");
        stringList3.add("aed");
        stringList3.add("ab");
        stringList3.add("a2");
        stringList3.add("aed2");
        stringList3.add("ab3");
        stringList3.add("aed4");
        stringList3.add("ab5");
        List<String> newList = stringList3.subList(2, 5);
        System.out.println(newList);
        Thread.sleep(2000);
    }
}
