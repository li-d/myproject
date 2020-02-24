package com.mycompany.common.demo.IO;

import java.io.File;
import java.io.InputStreamReader;

public class TestIO {

    public static void main(String[] args) {
        try {
            File file = new File("d/test/1.png");
            //file.getName();

            System.out.println(file.getName());

            System.out.println(file.delete());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
