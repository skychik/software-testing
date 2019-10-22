package ru.ifmo.cs.software_testing.lab2.math;

public class MyMath {

    public static long factorial(long n) {
        if (n <= 1) return 1;

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double mod(double x, double y) {
        double result = x % y;

        if (result < 0)
            result += y;

        return result;
    }
}
