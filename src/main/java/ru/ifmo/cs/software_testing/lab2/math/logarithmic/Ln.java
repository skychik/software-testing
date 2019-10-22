package ru.ifmo.cs.software_testing.lab2.math.logarithmic;

import ru.ifmo.cs.software_testing.lab2.utility.AbstractFunction;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.NaN;

public class Ln extends AbstractFunction {
    {
        table.put(0.0, NEGATIVE_INFINITY);
        table.put(1.0, 0.0);
        table.put(2.0, 0.6931471805599453);
        table.put(3.0, 1.0986122886681098);
        table.put(Math.E, 1.0);
    }

    public Double calc(double x) {
        if(x < 0) return NaN;

        Double tableValue = super.calc(x);
        if (tableValue != null) {
            return tableValue;
        }

        double t = (x - 1)/(x + 1);

        double result = 0;

        for(int n = 0; n < 100; n++) {
            result += Math.pow(t, 2*n + 1) / (2*n + 1);
        }

        return 2 * result;
    }
}
