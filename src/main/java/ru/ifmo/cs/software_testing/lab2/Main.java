package ru.ifmo.cs.software_testing.lab2;

import ru.ifmo.cs.software_testing.lab2.math.logarithmic.Ln;
import ru.ifmo.cs.software_testing.lab2.math.logarithmic.Log2;
import ru.ifmo.cs.software_testing.lab2.math.logarithmic.Log3;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Cosecant;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Sinus;
import ru.ifmo.cs.software_testing.lab2.math.trigonometric.Tangent;
import ru.ifmo.cs.software_testing.lab2.utility.AbstractFunction;
import ru.ifmo.cs.software_testing.lab2.utility.CSVWriter;
import ru.ifmo.cs.software_testing.lab2.utility.FunctionSystem;

public class Main {
	public static void main(String[] args) {
		FunctionSystem funcSystem = new FunctionSystem();
		Ln ln = new Ln();
		Log2 log2 = new Log2();
		Log3 log3 = new Log3();
		Cosecant csc = new Cosecant();
		Sinus sin = new Sinus();
		Tangent tan = new Tangent();
		FunctionSystem fs = new FunctionSystem();

		output(ln, 0, 4, 0.1);
		output(log2, 0, 4, 0.1);
		output(log3, 0, 4, 0.1);
		output(csc, -4, 4, 0.1);
		output(sin, -4, 4, 0.1);
		output(tan, -4, 4, 0.1);
		output(fs, -4, 4, 0.1);

	}

	private static void output(AbstractFunction f, double from, double to, double step) {
		CSVWriter writer = new CSVWriter(f);
		writer.write(from, to, step);
	}
}
