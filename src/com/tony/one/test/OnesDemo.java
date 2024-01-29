package com.tony.one.test;

public class OnesDemo {
    public static void main(String[] args) {
        int n = 124;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(ones(n));
    }

    private static int ones(int n){
        if (n<2){
            return n;
        }
        return ones(n/2) + n%2;
    }
}
