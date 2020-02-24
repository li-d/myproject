package com.mycompany.common.demo.main;


import com.mycompany.common.demo.collection.StringCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollection {

    List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ab");
        stringList.add("a");
        stringList.add("abcdef");
        stringList.add("abc");
        stringList.add("abcde");
        stringList.add("abcd");
        System.out.println(stringList);
        Collections.sort(stringList);
        System.out.println(stringList);

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("ab");
        stringList2.add("a");
        Collections.sort(stringList2, new StringCompare());
        System.out.println(stringList2);
    }
}
