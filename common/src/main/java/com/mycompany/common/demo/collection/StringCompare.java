package com.mycompany.common.demo.collection;


import com.mycompany.common.demo.entity.MyInterface;

import java.util.Comparator;

public class StringCompare implements Comparator<String>, MyInterface {

    @Override
    public int compare(String s, String t1) {
        return s.length() < t1.length() ? 1 : -1;
    }


    @Override
    public String getString() {
        return null;
    }
}
