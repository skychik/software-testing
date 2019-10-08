package ru.ifmo.cs.software_testing.lab1.tangent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tangent {
    public static void main(String[] args) {

        double number;
        double tan;

        while(true) {
            try {
                number = enterDouble("Enter number (0 <= x < pi/2): ");
                tan = calcTan(number);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("You entered a number out of correct range");
                continue;
            }
        }
        System.out.println("tan(" + number + ") = " + tan);
    }

    private static double enterDouble(String prompt) {
        double number;

        while(true) {
            try {
                Scanner inputScanner = new Scanner(System.in);
                System.out.print(prompt);

                number = inputScanner.nextDouble();
                break;

            } catch (InputMismatchException e) {
                System.out.println("You entered not number");
                continue;
            }
        }
        return number;
    }
    private static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    private static double taylorCos(double x) {
        double result = 0;

        for(int n = 0; n < 12; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return result;
    }

    public static double calcTan(double x) {
        if (x < 0 || x > Math.PI/2)
            throw new IllegalArgumentException("0 <= x < pi/2");

        return Math.sqrt(1 / Math.pow(taylorCos(x), 2) - 1);
    }
}
