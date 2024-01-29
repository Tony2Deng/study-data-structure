package com.tony.tow.test;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {1, -1, -9, -8, -4, -3, -9, 9, 3, 6, -8};
        System.out.println(minSubSum(arr));
        System.out.println(minPositiveSubSum(arr));
        double[] arr1 = {2, 0.5, -3, 4, 0.5, 5};
        double maxPositiveSubProduct = maxPositiveSubProduct(arr1);
        System.out.println(maxPositiveSubProduct);
    }

    public static int minSubSum(int[] arr) {
        int minSum = 0;
        int thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum < minSum) {
                minSum = thisSum;
            } else if (thisSum > 0) {
                thisSum = 0;
            }
        }
        return minSum;
    }

    public static int minPositiveSubSum(int[] arr) {
        int minSum = 0;
        int thisSum = 0;
        //int[] arr = {1,-1,-9,-8,-4,-5,-9,9,3,6,-8};
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];

            if (thisSum < minSum) {
                minSum = thisSum;
            } else if (thisSum > 0) {
                thisSum = 0;
            }
            //else if 只会走一条，连续if 每条都会走
            if (i < arr.length - 1 && arr[i + 1] <= arr[i]) {
                thisSum = 0;
            }
        }
        return minSum;
    }

    public static double maxPositiveSubProduct(double[] arr) {
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp = i;
            }
        }
        double maxPro = 1;
        double thisPro = 1;
        //int[] arr = {1,-1,-9,-8,-4,-5,-9,9,3,6,-8};
        for (int i = 0; i < arr.length; i++) {
            thisPro *= arr[i];

            if (thisPro > maxPro) {
                maxPro = thisPro;
            } else if (Math.abs(thisPro) < 1) {
                thisPro = 1;
            }

            if (i == temp && thisPro < 0) {
                thisPro = 1;
            }
        }
        return maxPro;
    }
}
