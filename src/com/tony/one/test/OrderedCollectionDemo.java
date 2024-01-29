package com.tony.one.test;


import java.util.ArrayList;
import java.util.List;

public class OrderedCollectionDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 2);
        Rectangle r2 = new Rectangle(1, 3);
        Rectangle r3 = new Rectangle(2, 2);
        Rectangle r4 = new Rectangle(6, 2);
        Rectangle r5 = new Rectangle(1, 9);
        Rectangle[] arr = {r1,r2};
        OrderedCollection<Rectangle> collection = new OrderedCollection<>(arr);
        Rectangle max = (Rectangle) collection.findMax();
        System.out.println(max.getArea());
        collection.insert(r3);
        max = (Rectangle) collection.findMax();
        System.out.println(max.getArea());
        collection.insert(r4);
        max = (Rectangle) collection.findMax();
        System.out.println(max.getArea());
        collection.insert(r5);
        max = (Rectangle) collection.findMax();
        System.out.println(max.getArea());
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        ArrayList<Area> areas = new ArrayList<>();
        areas.add(r1);
        hello(areas);
        hello(rectangles);
    }

    private static void hello(List<? extends Area> arr){
        System.out.println(arr);
    }
}

class OrderedCollection<E extends Comparable<? super E>> {
    private Comparable[] arr;
    private int size;

    public OrderedCollection(Comparable[] arr) {
        this.size = arr.length;
        this.arr = arr;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void makeEmpty() {
        this.size = 0;
        this.arr = new Comparable[1];
    }

    public void insert(E e) {
        if (this.size < this.arr.length) {
            this.arr[size] = e;
        } else {
            Comparable[] temp = new Comparable[this.size * 2];
            System.arraycopy(this.arr, 0, temp, 0, this.size);
            temp[this.size] = e;
            this.arr = temp;
        }
        this.size++;
    }

    public int remove(E e) {
        for (int i = 0; i < this.size; i++) {
            if (e.equals(this.arr[i])) {
                return this.remove(i);
            }
        }
        return -1;
    }

    public int remove(int index) {
        if (index >= this.size || index < 0) {
            return -1;
        } else {
            System.arraycopy(this.arr, index + 1, this.arr, index, this.size - (index + 1));
            this.arr[this.size - 1] = null;
            this.size--;
            if (this.size <= this.arr.length/2) {
                Comparable[] temp = new Comparable[this.arr.length / 2];
                System.arraycopy(arr,0,temp,0,size);
                this.arr = temp;
            }
            return index;
        }
    }

    public Comparable findMin() {
        if (this.size == 0) {
            return null;
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (this.arr[i].compareTo(this.arr[index]) < 0) {
                index = i;
            }
        }
        return (E) this.arr[index];
    }

    public Comparable findMax() {
        if (this.size == 0) {
            return null;
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (this.arr[i].compareTo(this.arr[index]) > 0) {
                index = i;
            }
        }
        return (E) this.arr[index];
    }

    public Comparable[] getArr() {
        return arr;
    }

    public void setArr(Comparable[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Rectangle implements Comparable<Area>, Area {
    private int length;
    private int width;

    public Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int compareTo(Area o) {
        return this.getArea() - ((Area) o).getArea();
    }

    @Override
    public int getArea() {
        return this.getLength() * this.getWidth();
    }
}

interface Area {
    int getArea();
}