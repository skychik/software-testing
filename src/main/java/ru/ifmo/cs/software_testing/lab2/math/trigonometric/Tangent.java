package ru.ifmo.cs.software_testing.lab2.math.trigonometric;

import ru.ifmo.cs.software_testing.lab2.utility.AbstractFunction;

import static java.lang.Double.NaN;

public class Tangent extends AbstractFunction {
    {
        table.put(-Math.PI / 2, NaN);
        table.put(-Math.PI / 4, -1.0);
        table.put(0.0, 0.0);
        table.put(Math.PI / 4, 1.0);
        table.put(Math.PI / 2, NaN);
    }

    public Double calc(double x) {
        double xInArea = (Math.abs(x) + Math.PI / 2) % Math.PI - (Math.PI / 2);

        Double tableValue = super.calc(xInArea);
        if (tableValue != null) {
            return tableValue;
        }

        Sinus sin = new Sinus();
        return Math.sqrt(1 / (1 - Math.pow(sin.calc(xInArea), 2)) - 1) * (x < 0 ? -1 : 1) * (xInArea < 0 ? -1 : 1);
    }
}
