package com.tony.tow.maxsubsum;

public class MaxSubSumDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, -5, 6, 42, -34, 56, 78, -31, 100, -34, -346, -234, 3, 4, 7, -23};
        System.out.println(Answer1.method1(arr));
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println(Answer2.method2(arr));
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println(Answer3.method3(arr, 0, arr.length - 1));
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println(Answer4.method4(arr));
    }
}
