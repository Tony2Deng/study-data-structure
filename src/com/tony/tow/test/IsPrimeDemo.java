package com.tony.tow.test;

public class IsPrimeDemo {
    public static void main(String[] args) {
        System.out.println(isPrime(5971849));
    }

    private static boolean isPrime(int number) {
        if (number <= 0 || number % 2 == 0 || number % 3 == 0 || (number % 6 != 1 && number % 6 != 5)) {
            return false;
        }
        int n = (int) (Math.sqrt(number) +1)/6;
        for (int i = 1; i <= n; i++) {
            int factor1 = i * 6 + 1;
            if (number % factor1 == 0) {
                System.out.println(factor1);
                return false;
            }
            int factor2 = i * 6 - 1;
            if (number % factor2 == 0) {
                System.out.println(factor2);
                return false;
            }
        }
        return true;
    }
}
