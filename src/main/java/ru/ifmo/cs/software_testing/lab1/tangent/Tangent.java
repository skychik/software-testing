package ru.ifmo.cs.software_testing.lab1.tangent;

import java.util.Scanner;

public class Tangent {
    private static double enterDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        double res;

        System.out.println(prompt);
        if (sc.hasNext() && sc.hasNextDouble()) {
            res = sc.nextDouble();
        } else {
            throw new IllegalArgumentException("Not a number");
        }

        return res;
    }

    public static void main(String[] args) {
        double number;
        try {
            number = enterDouble("Enter number:");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        double result = tan(number);
        System.out.printf("tan(%f)=%f\n", number, result);
        System.out.printf("Expected tan(%f)=%f\n", number, Math.tan(number));
    }

    public static double tan(double x) {
        double xInArea = (Math.abs(x) + Math.PI / 2) % Math.PI - (Math.PI / 2);
        return Math.sqrt(1 / Math.pow(taylorCos(xInArea), 2) - 1) * (x < 0 ? -1 : 1) * (xInArea < 0 ? -1 : 1);
    }

    private static double taylorCos(double x) {
        double result = 0;

        for(int n = 0; n < 30; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return result;
    }

    protected static long factorial(long n) {
        if (n <= 1) return 1;

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
