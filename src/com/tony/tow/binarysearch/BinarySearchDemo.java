package com.tony.tow.binarysearch;

public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 12, 13, 25, 35, 46, 52, 76, 90, 123, 256};
        int search = search(arr, 13);
        System.out.println(search + "......" + arr[search]);
        System.out.println(euclid(90, 25));
        System.out.println(pow(2,10));
    }

    private static int search(int[] arr, int number) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int center = (right + left) / 2;
            if (arr[center] < number) {
                left = center + 1;
            } else if (arr[center] > number) {
                right = center - 1;
            } else {
                return center;
            }
        }
        return -1;
    }

    public static int euclid(int a, int b) {
        do {
            int n = a % b;
            a = b;
            b = n;
        } while (b != 0);
        return a;
    }

    private static long pow(int x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return pow(x * x, n / 2) * x;
        } else {
            return pow(x * x, n / 2);
        }
    }
}
