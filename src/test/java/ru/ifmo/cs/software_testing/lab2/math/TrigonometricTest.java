package ru.ifmo.cs.software_testing.lab2.math;

import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Cosecant;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Sinus;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Tangent;
import ru.ifmo.cs.software_testing.lab2.utility.FunctionSystem;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrigonometricTest {
    private final double EPS = 1e-5;
    private Sinus sin = new Sinus();
    private Tangent tan = new Tangent();
    private Cosecant csc = new Cosecant();

    private FunctionSystem funcSystem = new FunctionSystem();

    @Test
    void sinTest() {
        for (Double x :
                Arrays.asList(0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, Math.PI, Math.PI / 2, -1.5, -1231.23123))
        {
            double math = Math.sin(x);
            Double calc = sin.calc(x);
            System.out.printf("sin(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }

    @Test
    void tanTest() {
        for (Double x :
                Arrays.asList(0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, Math.PI, Math.PI / 2 - 0.02, -1.5, -1231.23123))
        {
            double math = Math.tan(x);
            Double calc = tan.calc(x);
            System.out.printf("tan(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, 1e-3);
        }
    }

    @Test
    void cscTest() {
        for (Double x :
                Arrays.asList(0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, Math.PI - 0.01, Math.PI / 2 - 0.02, -1.5, -1231.23123))
        {
            double math = 1 / Math.sin(x);
            Double calc = csc.calc(x);
            System.out.printf("csc(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }
}
