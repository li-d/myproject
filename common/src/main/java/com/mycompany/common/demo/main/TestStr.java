package com.mycompany.common.demo.main;

public class TestStr {
    public static void main(String[] args) {
        String str = "325_16";
        String a = str.substring(str.indexOf("_") + 1);
        System.out.println(a);
    }
}
