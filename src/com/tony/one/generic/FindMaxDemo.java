package com.tony.one.generic;

import java.util.Objects;

public class FindMaxDemo {
    private static Comparable findMax(Comparable[] arr) {
        Comparable maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(maxValue) > 0) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Student[] arr = {new Student("小明",20),new Student("小红",15),new Student("小花",18)};
        System.out.println(findMax(arr));
    }
}

class Student implements Comparable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.age - s.age;
    }
}