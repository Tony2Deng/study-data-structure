package com.tony.tow.test;

public class FindMasterEleDemo {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2};
        System.out.println(findMasterEle(arr));
    }

    private static int findMasterEle(int[] arr) {
        int candidate = arr[0];
        int count = 0;
        for (int i : arr) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                if (i == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i : arr) {
            if (i == candidate)
                count++;
        }
        if (count > arr.length / 2) {
            return candidate;
        } else {
            throw new RuntimeException("没有主元素");
        }
    }
}
