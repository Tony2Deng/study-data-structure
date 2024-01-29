package com.tony.one.selectionproblem;

import java.util.Arrays;
import java.util.Random;

public class SelectMaxK {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = randomArr(10);
        System.out.println(Arrays.toString(arr));
        int result = selectK2(k, arr);
        System.out.println("结果为：" + result);
    }

    private static int[] randomArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(5);
        }
        return arr;
    }

    private static int selectK1(int k, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[k];
    }

    private static int selectK2(int k, int[] arr) {
        int[] resultArr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                resultArr[i] = arr[i];
                for (int j = 0; j < i; j++) {
                    if (resultArr[i] > resultArr[j]) {
                        int temp = resultArr[j];
                        resultArr[j] = resultArr[i];
                        resultArr[i] = temp;
                    }
                }
            } else {
                int temp = arr[i];
                for (int j = 0; j < resultArr.length; j++) {
                    if (temp > resultArr[j]) {
                        int resultArrTemp = resultArr[j];
                        resultArr[j] = temp;
                        temp = resultArrTemp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(resultArr));
        return resultArr[k - 1];
    }
}
