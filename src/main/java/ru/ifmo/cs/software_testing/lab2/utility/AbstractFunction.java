package ru.ifmo.cs.software_testing.lab2.utility;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFunction {
    public Map<Double, Double> table = new HashMap<>();

    public Double calc(double x) {
        return table.get(x);
    }
}
