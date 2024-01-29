package com.tony.tow.test;

public class GcdDemo {
    public static void main(String[] args) {
        int answer = gcd(1989, 1590);
        System.out.println(answer);
        System.out.println(gcd2(1989, 1590));
    }

    private static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (b == 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % 2 == 0) {
            if (b % 2 == 0) {
                return 2 * gcd(a / 2, b / 2);
            } else {
                return gcd(a / 2, b);
            }
        } else {
            if (b % 2 == 0) {
                return gcd(a, b / 2);
            } else {
                return gcd((a + b) / 2, (a - b) / 2);
            }
        }
    }

    private static int gcd2(int x,int y) {
        while (y != 0){
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
