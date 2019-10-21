package lab2.trigonometric;

import lab2.AbstractFunction;

public class Cosecant extends AbstractFunction {
    public Double calc(double x) {
        Sinus sin = new Sinus();

        return 1/sin.calc(x);
    }
}
