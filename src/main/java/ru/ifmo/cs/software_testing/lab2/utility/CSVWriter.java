package ru.ifmo.cs.software_testing.lab2.utility;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private AbstractFunction function;

    public CSVWriter(AbstractFunction function) {
        this.function = function;
    }

    private String getFilename() {
        String funcName = this.function.getClass().getSimpleName();
        if (funcName.isEmpty()) {
            funcName = "func";
        }
        return "./output/lab2/" + funcName + ".csv";
    }

    public void write(double from, double to, double step) {
        try ( FileWriter writer = new FileWriter(getFilename(), false) ) {
            for (double x = from; x < to; x += step) {
                double value = function.calc(x);

                if (Double.isNaN(value)) continue;
                writer.append(String.format("%f\t%f\n", x, value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
