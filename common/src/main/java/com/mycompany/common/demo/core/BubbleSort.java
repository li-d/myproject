package com.mycompany.common.demo.core;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sortAsc(int[] arr) {
        int temp; //临时变量
        boolean flag;

        for (int i = 0; i < arr.length - 1; i++) { //表示趟数，一共 arr.length-1 次
            flag = false; //每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) { //选出该趟排序的最大值往后移动
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;    //只要有发生了交换，flag就置为true
                }
            }

            // 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
            if (!flag) break;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sortDesc(int[] arr) {
        int temp; //临时变量
        boolean flag;

        for (int i = 0; i < arr.length - 1; i++) { //循环次数
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
