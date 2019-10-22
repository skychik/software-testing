package ru.ifmo.cs.software_testing.lab2.utility;

import ru.ifmo.cs.software_testing.lab2.math.logarithmic.LogN;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Cosecant;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Sinus;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Tangent;

public class FunctionSystem extends AbstractFunction{

    public Double calc(double x) {
        Tangent tan = new Tangent();
        Sinus sin = new Sinus();
        Cosecant csc = new Cosecant();

        LogN logN = new LogN();

        if(x <= 0) {
            return (2 * tan.calc(x) + sin.calc(x)) / csc.calc(x) * tan.calc(x) - sin.calc(x) * csc.calc(x);
        }
        else {
            return Math.pow(logN.calc(2, x) * Math.pow(logN.calc(2, x), 3) - logN.calc(2, x), 2) / logN.calc(3, x);
        }

    }
}
