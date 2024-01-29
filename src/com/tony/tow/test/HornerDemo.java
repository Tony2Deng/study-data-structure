package com.tony.tow.test;

public class HornerDemo {
    public static void main(String[] args) {
        int[] arr = {4,8,0,1,2};
        int x = 3;
        horner(arr,x);
    }

    private static void horner(int[] arr, int x) {
        int ploy = 0;
        for (int i = 0; i < arr.length; i++) {
            ploy = x * ploy + arr[i];
        }
        System.out.println("horner is ：" + ploy);
        ploy = 4*x*x*x*x + 8*x*x*x + x + 2;
        System.out.println("truth is :" + ploy);
    }
}
