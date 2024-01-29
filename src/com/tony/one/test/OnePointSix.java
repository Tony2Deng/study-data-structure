package com.tony.one.test;

public class OnePointSix {
    public static void main(String[] args) {
        String str = "abc";
        permute(str);
    }

    public static void permute(String str) {
        char[] chars = str.toCharArray();
        permute(chars,0,chars.length);
    }

    private static void permute(char[] str, int low, int high) {
        if (low == high) {
            System.out.println(str);
        }else {
            for (int i = low; i < high ; i++) {
                swap(str,low,i);
                permute(str,low + 1,high);
                swap(str,low,i);
            }
        }
    }

    private static void swap(char[] str, int j, int k) {
        char temp = str[j];
        str[j] = str[k];
        str[k] = temp;
    }
}
