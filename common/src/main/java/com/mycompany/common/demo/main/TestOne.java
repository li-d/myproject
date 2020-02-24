package com.mycompany.common.demo.main;

import com.mycompany.common.demo.thread.Ethread;


public class TestOne {

    public static void main(String[] args) {
       /* int[] arr= {3,4,1,3,4,86,5,66,77,43,6,70,346,76,432};
        BubbleSort.sortAsc(arr);*/

       /*Thread t = new Thread(new Mythread());
       t.setName("123");
       t.start();*/

        Ethread t = new Ethread();
        Thread thread = new Thread(t);
        thread.setName("AA");
        thread.start();

        //t.start();


    }

}
