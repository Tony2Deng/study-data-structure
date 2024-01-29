package com.tony.one.test;

import java.util.Arrays;

public class CollectionDemo {
    public static void main(String[] args) {
        String[] arr = new String[]{"abc", "245"};
        Collection<String> objectCollection = new Collection<String>(arr);
        System.out.println(">>>>>>>>>>>>>>>>>1");
        System.out.println(objectCollection.getSize());
        System.out.println(Arrays.toString(objectCollection.getArr()));
        objectCollection.insert("1");
        System.out.println(">>>>>>>>>>>>>>>>>1.1");
        System.out.println(objectCollection.getSize());
        System.out.println(Arrays.toString(objectCollection.getArr()));
        objectCollection.insert("2");
        objectCollection.insert("3");
        System.out.println(">>>>>>>>>>>>>>>>>2");
        System.out.println(objectCollection.getSize());
        System.out.println(Arrays.toString(objectCollection.getArr()));
        objectCollection.remove("1");
        System.out.println(">>>>>>>>>>>>>>>>>2.1");
        System.out.println(objectCollection.getSize());
        System.out.println(Arrays.toString(objectCollection.getArr()));
        objectCollection.remove("3");
        System.out.println(">>>>>>>>>>>>>>>>>2.2");
        System.out.println(objectCollection.getSize());
        System.out.println(Arrays.toString(objectCollection.getArr()));
        objectCollection.remove("abc");
        System.out.println(">>>>>>>>>>>>>>>>>3");
        System.out.println(objectCollection.getSize());
        System.out.println(Arrays.toString(objectCollection.getArr()));
        System.out.println(">>>>>>>>>>>>>>>>>4");
        System.out.println(objectCollection.isPresent("245"));
        System.out.println(objectCollection.isPresent("1"));
    }
}

class Collection<T> {

    private Object[] arr;
    private int size = 0;

    public Collection(T[] arr) {
        this.size = arr.length;
        this.arr = arr;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void makeEmpty() {
        this.size = 0;
        this.arr = new Object[]{};
    }

    public void insert(T t) {
        if (this.size < this.arr.length) {
            this.arr[this.size] = t;
        } else {
            Object[] temp = new Object[this.size * 2];
            System.arraycopy(this.arr, 0, temp, 0, this.arr.length);
            this.arr = temp;
            this.arr[this.size] = t;
        }
        this.size++;
    }

    public void remove(T t) {
        for (int i = 0; i < this.size; i++) {
            if (t.equals(this.arr[i])) {
//                if (i == this.size - 1) {
//                    this.arr[i] = null;
//                } else {
//                    System.arraycopy(this.arr, i + 1, this.arr, i, this.size - (i + 1));
//                    this.arr[this.size - 1] = null;
//                }
                System.arraycopy(this.arr, i + 1, this.arr, i, this.size - (i + 1));
                this.arr[this.size - 1] = null;
                this.size--;
            }
        }
        if (this.size <= this.arr.length / 2) {
            Object[] temp = new Object[this.arr.length / 2];
            System.arraycopy(arr, 0, temp, 0, size);
            this.arr = temp;
        }
    }

    public int isPresent(T t) {
        for (int i = 0; i < this.size; i++) {
            if (t.equals(this.arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}