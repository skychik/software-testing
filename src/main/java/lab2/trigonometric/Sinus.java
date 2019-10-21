package lab2.trigonometric;

import lab2.AbstractFunction;

import static lab2.math.Operation.factorial;
import static lab2.math.Operation.mod;

public class Sinus extends AbstractFunction {

    {
        table.put(0.0, 0.0);
        table.put(Math.PI / 6, 0.5);
        table.put(Math.PI / 2, 1.0);
        table.put(5.0/6 * Math.PI, 0.5);
        table.put(Math.PI, 0.0);
        table.put(7.0/6 * Math.PI, -0.5);
        table.put(3.0/2 * Math.PI, -1.0);
        table.put(11.0/6 * Math.PI, -0.5);
        table.put(2 * Math.PI, 0.0);
    }

    public Double calc (double x) {
        Double xInArea = mod(x, 2 * Math.PI);

        Double tableValue = super.calc(xInArea);
        if (tableValue != null) {
            return tableValue;
        }

        double result = 0;

        for(int n = 0; n < 10; n++) {
            result += Math.pow(-1, n) * Math.pow(xInArea, 2 * n + 1) / factorial(2 * n + 1);
        }
        return result;
    }
}
