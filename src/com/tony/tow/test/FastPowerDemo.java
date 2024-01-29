package com.tony.tow.test;

public class FastPowerDemo {
    public static void main(String[] args) {
        System.out.println(fastPower(2, 9));
        System.out.println(getcount(62));
    }

    private static long fastPower(long x, long power) {
        if (power == 1L) {
            return x;
        }
        if (power == 0L) {
            return 1L;
        }
        long fastPower = fastPower(x, power / 2);
        if (power % 2L == 0L) {
            return fastPower * fastPower;
        } else {
            return fastPower * fastPower * x;
        }
    }

    private static int getcount(int x) {
        if (x < 0) {
            return -1;
        }
        int log = 0;
        int findOne = 0;
        int i = 1;
        do {
            int temp = x & 1;
            if (temp == 1){
                findOne++;
            }
            x = x>>1;
            temp = x & Integer.MAX_VALUE;
            if (temp != 0) {
                log ++;
            }
            i++;
        } while (i < 32);
        return log + findOne - 1;

    }
}
