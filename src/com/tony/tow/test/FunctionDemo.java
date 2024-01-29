package com.tony.tow.test;

public class FunctionDemo {
    public static void main(String[] args) {
        Function f = new Fuuction1();
        double zero = findZero(f, -25, 10);
        System.out.println("f(x)=" + f.domain(zero) + ",zero=" + zero);
    }

    static double findZero(Function<Double> f, double low, double high) {
        if (Math.abs(f.domain(high)) < 0.001) {
            return high;
        }
        if (Math.abs(f.domain(low)) < 0.001) {
            return low;
        }
        if (f.domain(low) > 0) {
            if (f.domain(high) < 0) {
                double temp = low;
                low = high;
                high = temp;
            } else {
                throw new RuntimeException("hhhhh");
            }
        } else {
            if (high < 0) {
                throw new RuntimeException("hhhhh");
            }
        }

        double center = (low + high) / 2;
        if (Math.abs(f.domain(center)) < 0.001) {
            return center;
        } else if (f.domain(center) > 0) {
            return findZero(f, low, center);
        } else {
            return findZero(f, center, high);
        }
    }
}

class Fuuction1 implements Function<Double> {

    @Override
    public Double domain(Double x) {
        return (x - 1) * (x - 2) * (x - 3) - 1;
    }
}

interface Function<T> {
    T domain(T t);
}