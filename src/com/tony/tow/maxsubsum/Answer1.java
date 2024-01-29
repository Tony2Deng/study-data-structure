package com.tony.tow.maxsubsum;

//暴力算法
public class Answer1 {
    public static int method1(int[] arr) {
        int maxSum = 0;
        int[] index = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += arr[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        System.out.println(index[0]+ ":" + arr[index[0]] + "------" + index[1] + ":" + arr[index[1]]);
        return maxSum;
    }
}
