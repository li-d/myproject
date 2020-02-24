package com.mycompany.common.demo.main;


import com.mycompany.common.demo.core.BubbleSort;

import java.util.Calendar;
import java.util.Date;

public class TestTwo {

    public static void main(String[] args) {
        System.out.println(new Date());

        System.out.println(Calendar.getInstance().getTime());

        System.out.println(new Date() == Calendar.getInstance().getTime());

        System.out.println(new Date().equals(Calendar.getInstance().getTime()));

        System.out.println(new Date().equals(""));

        Object object = new Object();

        BubbleSort b = new BubbleSort();


        Long age = -400000000000000000l;

    }
}
