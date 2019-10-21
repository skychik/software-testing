package lab2.trigonometric;

import lab2.CSVWriter;
import lab2.FunctionSystem;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrigonometricTest {
    private final double EPS = 1e-5;
    Sinus sin = new Sinus();
    Tangent tan = new Tangent();
    Cosecant csc = new Cosecant();

    FunctionSystem funcSysnem = new FunctionSystem();

    CSVWriter writer = new CSVWriter(funcSysnem);

    @Test
    void sinTest() {
        for (Double x :
                Arrays.asList(0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, Math.PI, Math.PI / 2, -1.5, -1231.23123))
        {
            Double math = Math.sin(x);
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
            Double math = Math.tan(x);
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
            Double math = 1 / Math.sin(x);
            Double calc = csc.calc(x);
            System.out.printf("csc(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }


    @Test
    void systemTest() {
        for (Double x :
                Arrays.asList(-0.5, -1.0, -1.3, -2.0, -2.5, -3.0, -3.5, -Math.PI / 2 - 0.3, -1231.23123))
        {
            Double math = ((2 * Math.tan(x) + Math.sin(x)) * Math.tan(x) / (1 / Math.sin(x))) - 1;
            Double calc = funcSysnem.calc(x);
            System.out.printf("f(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, 1e-2);
        }
        writer.write(-4, 4, 0.1);
    }
}
