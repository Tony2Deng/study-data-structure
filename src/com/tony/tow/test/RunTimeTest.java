package com.tony.tow.test;

public class RunTimeTest {
    public static void main(String[] args) {
//        System.out.println("结果：" + towSevenOne(2000000000));
//        System.out.println("结果：" + towSevenTwo(200000));
//        System.out.println("结果：" + towSevenThree(1000));34
//        System.out.println("结果：" + towSevenFour(200000));
//        System.out.println("结果：" + towSevenFive(100));
//        System.out.println("结果：" + towSevenSix(1000));

    }

    private static long towSevenOne(int n) {
        long l0 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        long l1 = System.currentTimeMillis();
        System.out.println("2.7.1运行时间：" + (l1 - l0));
        return sum;
    }

    private static long towSevenTwo(int n) {
        long l0 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println("2.7.2运行时间：" + (l1 - l0));
        return sum;
    }

    private static long towSevenThree(int n) {
        long l0 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                sum++;
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println("2.7.3运行时间：" + (l1 - l0));
        return sum;
    }

    private static long towSevenFour(int n) {
        long l0 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println("2.7.4运行时间：" + (l1 - l0));
        return sum;
    }

    private static long towSevenFive(int n) {
        long l0 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i * i; j++) {
                for (int k = 0; k < j; k++) {
                    sum++;
                }
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println("2.7.5运行时间：" + (l1 - l0));
        return sum;
    }

    private static long towSevenSix(int n) {
        long l0 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i * i; j++) {
                if (j % i == 0) {
                    for (int k = 0; k < j; k++) {
                        sum++;
                    }
                }
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println("2.7.6运行时间：" + (l1 - l0));
        return l1 - l0;
    }


}
