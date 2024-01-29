package com.tony.one.simplerecursive;

public class SimpleRecursive {
    private static int recursiveFunction(int x) {
        if (x == 0) {
            return 0;
        } else {
            return recursiveFunction(x - 1) * 2 + (int) Math.pow(x, 2);
        }
    }

    private static void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }
        System.out.println(n % 10);
    }

    public static void main(String[] args) {
        printOut(363365);
        System.out.println("函数:" + recursiveFunction(5));
    }
}
