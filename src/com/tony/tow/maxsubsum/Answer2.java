package com.tony.tow.maxsubsum;
//对暴力算法的简单优化
public class Answer2 {
    public static int method2(int[] arr) {
        int maxSum = 0;
        int[] index = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int thisSum = 0;
            for (int j = i; j < arr.length; j++) {
                thisSum += arr[j];
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
