package com.tony.tow.maxsubsum;

//递归方法
public class Answer3 {
    public static int method3(int[] arr, int left, int rigth) {
        //终止条件
        if (left == rigth) {
            return arr[left] > 0 ? arr[left] : 0;
        }

        //求出左右两子串的MaxSubSum
        int center = (left + rigth) / 2;
        int leftMax = method3(arr, left, center);
        int rigthMax = method3(arr, center + 1, rigth);

        //求maxBorderSum;

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= rigth; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max(leftMax, rigthMax, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max(int number1, int number2, int number3) {
        number2 = number1 > number2 ? number1 : number2;
        return number2 > number3 ? number2 : number3;
    }
}
