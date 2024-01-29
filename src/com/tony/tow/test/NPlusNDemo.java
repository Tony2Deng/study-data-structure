package com.tony.tow.test;

public class NPlusNDemo {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {7, 8, 9, 10}, {13, 14, 16, 17}, {14, 16, 17, 18}};
        System.out.println(findNumber(arr, 11));
    }

    private static boolean findNumber(int[][] arr, int number) {
        int maxIndex = arr.length - 1;
        if (number < arr[0][0] || number > arr[maxIndex][maxIndex]) {
            return false;
        }
        int form = 0;
        int to = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i] < number) {
                form = i;
            }else if (arr[i][i] == number) {
                return true;
            }else {
                to = i;
                break;
            }
        }
        for (int i = 0; i <= maxIndex; i++) {
            if (i < to && arr[to][i] == number) {
                return true;
            }else if (i > form && arr[form][i] == number) {
                return true;
            }
        }
        return false;
    }
}
