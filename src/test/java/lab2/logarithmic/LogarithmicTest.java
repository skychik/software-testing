package lab2.logarithmic;

import lab2.FunctionSystem;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LogarithmicTest {

    private final double EPS = 1e-5;
    Ln ln = new Ln();
    LogN logN = new LogN();
    FunctionSystem funcSysnem = new FunctionSystem();

    @Test
    void lnTest() {
        for (Double x :
                Arrays.asList(-2.0, 0.0, 0.1, 0.5, 0.7, 1.0, 4.5, 3.0, 5.0, 10.0, 20.0, 30.0, 40.0))
        {
            Double math = Math.log(x);
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
            Double math = Math.log(x)/ Math.log(2);
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
            Double math = Math.log(x)/ Math.log(3);
            Double calc = logN.calc(3, x);
            System.out.printf("log3(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }

    @Test
    void systemTest() {
        for (Double x :
                Arrays.asList(0.5, 1.0, 1.3, 2.0, 2.5, 3.0, 3.5, 12.23123, 20.0))
        {

            double mathLog2 = Math.log(x) / Math.log(2);
            double mathLog3 = Math.log(x) / Math.log(3);

            Double math = Math.pow(mathLog2 * Math.pow(mathLog2, 3) - mathLog2, 2) / mathLog3;
            Double calc = funcSysnem.calc(x);
            System.out.printf("f(%f) = %f; expected: %f\n", x, calc, math);
            assertEquals(math, calc, EPS);
        }
    }
}
