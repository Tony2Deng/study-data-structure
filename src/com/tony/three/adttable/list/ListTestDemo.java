package com.tony.three.adttable.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTestDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(16000);
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(makeList1(arrayList,16000));
        System.out.println(makeList1(linkedList,16000));
        System.out.println(makeList1(arrayList,16000));
        System.out.println(makeList1(linkedList,16000));
        System.out.println(sum(arrayList));
        System.out.println(sum((linkedList)));
//        removeEvenVer1(arrayList);
//        removeEvenVer1(linkedList);
//        removeEvenVer2(linkedList);    ConcurrentModificationException
        removeEvenVer3(arrayList);
        removeEvenVer3(linkedList);
    }

    public static long makeList1(List<Integer> list, int n){
        list.clear();
        long l = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        return l1 - l;
    }

    public static long makeList2(List<Integer> list, int n){
        list.clear();
        long l = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
        long l1 = System.currentTimeMillis();
        return l1 - l;
    }

    public static int sum(List<Integer> list) {
        int tatol = 0;
        long l = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            tatol += list.get(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        return tatol;
    }

    public static void removeEvenVer1(List<Integer> list) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    public static void removeEvenVer2(List<Integer> list) {
        long l = System.currentTimeMillis();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                list.remove(integer);
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    public static void removeEvenVer3(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        long l = System.currentTimeMillis();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0){
                iterator.remove();
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
