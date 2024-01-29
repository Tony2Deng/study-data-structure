package com.tony.tow.test;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {300, 1, 2, 4, 11, 200, 191};
        System.out.println(Arrays.toString(maxPlus1(arr)));
        System.out.println(Arrays.toString(maxSub(arr)));
        System.out.println(Arrays.toString(maxSub1(arr)));
    }

    //除法同理，都是要让右边的最大，左边的最小；
    private static int[] maxSub(int[] arr) {
        int[] max = new int[3];
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            int minLeft = arr[0];
            int maxRight = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < minLeft) {
                    minLeft = arr[j];
                    l = j;
                }
            }
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                    r = j;
                }
            }
            //除法换成除号就好了
            if ((maxRight - minLeft) > max[0]) {
                max[0] = maxRight - minLeft;
                max[1] = l;
                max[2] = r;
            }
        }
        return max;
    }

    //乘法同理，都是找出最大的两个值，索引根据乘加满足交换律，可以交换的
    private static int[] maxPlus1(int[] arr) {
        int[] max = new int[3];
        int max1 = 0;
        int max2 = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                r = l;
                max1 = arr[i];
                l = i;
            } else if (arr[i] > max2) {
                max2 = arr[i];
                r = i;
            }
        }
        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }
        //乘法换成乘号就好了
        max[0] = max1 + max2;
        max[1] = l;
        max[2] = r;
        return max;
    }

    //减与除一种O（n）复杂度的算法；(除法要换成double参数与返回值)
    private static int[] maxSub1(int[] arr) {
        int[] arr2 = new int[arr.length - 1];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i + 1] - arr[i];
        }
        //接下来就是求最大子序列和问题了（除法的话是最大子序列积）
        int[] max = new int[4];
        int thisMax = 0;
        for (int i = 0; i < arr2.length; i++) {
            thisMax += arr2[i];
            if (thisMax > max[0]){
                max[0] = thisMax;
                max[1] = max[3];
                max[2] = i;
            } else if (thisMax <= 0) {
                thisMax = 0;
                max[3] = i + 1;
            }
        }
        return new int[]{max[0],max[1],max[2]+1};
    }
}
