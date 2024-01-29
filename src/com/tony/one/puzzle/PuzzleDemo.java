package com.tony.one.puzzle;

public class PuzzleDemo {
    public static void main(String[] args) {
        char[][] charTable = {{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};
        String[] dictionary = {"this", "tow", "fat", "that","am","hi","was","have"};
        findWords(charTable,dictionary);
    }

    private static void findWords(char[][] arr,String[] words){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String substring = words[i].substring(0, 1);
            if (!stringBuilder.toString().contains(substring)){
                stringBuilder.append(substring);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (stringBuilder.toString().contains(arr[i][j]+"")){
                    for (int k = 0; k < 8; k++) {
                        String temp = "";
                        int iEnd = i;
                        int jEnd = j;
                        while(ijAvg(arr,iEnd,jEnd)){
                            temp+=arr[iEnd][jEnd];
                            printWord(temp,words,i,j,iEnd,jEnd);
                            if (k==0){
                                iEnd++;
                            }
                            if (k==1){
                                iEnd++;
                                jEnd++;
                            }
                            if (k==2){
                                jEnd++;
                            }
                            if (k==3){
                                iEnd--;
                                jEnd++;
                            }
                            if (k==4){
                                iEnd--;
                            }
                            if (k==5){
                                iEnd--;
                                jEnd--;
                            }
                            if (k==6){
                                jEnd--;
                            }
                            if (k==7){
                                iEnd++;
                                jEnd--;
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean ijAvg(char[][] arr, int iEnd, int jEnd) {
        if (iEnd>=0&&iEnd<arr.length){
            return jEnd>=0&&jEnd<arr[iEnd].length;
        }
        return false;
    }

    private static void printWord(String word,String[] words, int x, int y, int xEnd, int yEnd) {
        for (String s : words) {
            if (s.equals(word)){
                System.out.println("单词："+ s + "\t向量:" + "(" + (x + 1) + "," + (y + 1) + ")->(" + (xEnd + 1) + "," + (yEnd + 1) + ")");
            }
        }
    }


}
