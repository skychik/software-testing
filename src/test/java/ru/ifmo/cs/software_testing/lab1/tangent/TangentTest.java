package ru.ifmo.cs.software_testing.lab1.tangent;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TangentTest {
    Tangent testTan = new Tangent();
    double eps = 1e-5;

    private boolean epsEquals(double a, double b, double eps)
    {
        return Math.abs(b - a) < eps;
    }

    @Test
    void testCalc() {
        assertTrue(epsEquals(Math.tan(0), testTan.calcTan(0), eps));
        System.out.println("x = 0 test passed");

        assertTrue(epsEquals(Math.tan(0.5), testTan.calcTan(0.5), eps));
        System.out.println("x = 0.5 test passed");

        assertTrue(epsEquals(Math.tan(1), testTan.calcTan(1), eps));
        System.out.println("x = 1 test passed");
    }
}
