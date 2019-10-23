package ru.ifmo.cs.software_testing.lab2.math;

import org.junit.jupiter.api.*;
import ru.ifmo.cs.software_testing.lab2.math.logarithmic.Ln;
import ru.ifmo.cs.software_testing.lab2.math.logarithmic.LogN;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LogarithmicTest {
    private final double EPS = 1e-5;
    private Ln ln = new Ln();
    private LogN logN = new LogN();

    @Test
    void lnTest() {
        for (Double x :
                Arrays.asList(-2.0, 0.0, 0.1, 0.5, 0.7, 1.0, 4.5, 3.0, 5.0, 10.0, 20.0, 30.0, 40.0))
        {
            double math = Math.log(x);
            Double calc = ln.calc(x);
            System.out.printf("ln(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }

    @Test
    void log2Test() {
        for (Double x :
                Arrays.asList(-2.0, 0.0, 0.1, 0.5, 0.7, 1.0, 4.5, 3.0, 5.0, 10.0, 20.0, 30.0, 40.0))
        {
            double math = Math.log(x)/ Math.log(2);
            Double calc = logN.calc(2, x);
            System.out.printf("log2(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }

    @Test
    void log3Test() {
        for (Double x :
                Arrays.asList(-2.0, 0.0, 0.1, 0.5, 0.7, 1.0, 4.5, 3.0, 5.0, 10.0, 20.0, 30.0, 40.0))
        {
            double math = Math.log(x)/ Math.log(3);
            Double calc = logN.calc(3, x);
            System.out.printf("log3(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }
}
