package lab2.logarithmic;

import lab2.AbstractFunction;

public class LogN extends AbstractFunction {

    public Double calc(double n, double x) {
        if (n < 0 || n == 1) {
            throw new IllegalArgumentException();
        }

        Ln ln = new Ln();
        return ln.calc(x)/ln.calc(n);
    }
}
