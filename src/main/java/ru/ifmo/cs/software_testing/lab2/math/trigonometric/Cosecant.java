package ru.ifmo.cs.software_testing.lab2.math.trigonometric;

import ru.ifmo.cs.software_testing.lab2.utility.AbstractFunction;

public class Cosecant extends AbstractFunction {
    public Double calc(double x) {
        Sinus sin = new Sinus();

        return 1/sin.calc(x);
    }
}
