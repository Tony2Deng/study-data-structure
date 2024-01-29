package com.tony.tow.test;

import java.util.Arrays;
import java.util.Random;

public class Eight {
    public static void main(String[] args) {
        method1(10);
        method2(10);
        method3(10);
    }

    private static void method1(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int anInt = randInt(0, n) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] == anInt) {
                    anInt = -1;
                }
            }
            if (anInt == -1) {
                i--;
            } else {
                arr[i] = anInt;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void method2(int n) {
        int[] arr = new int[n];
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < arr.length; i++) {
            int anInt = randInt(0, n) + 1;
            if (used[anInt]) {
                i--;
            } else {
                arr[i] = anInt;
                used[anInt] = true;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void method3(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int aInt = randInt(0, i);
            int temp = arr[i];
            arr[i] = arr[aInt];
            arr[aInt] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int randInt(int i, int j) {
        if (i == j){
            return 0;
        }
        Random random = new Random();
        return random.nextInt(j - i ) + i;
    }
}
