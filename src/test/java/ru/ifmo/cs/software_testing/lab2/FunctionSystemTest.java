package ru.ifmo.cs.software_testing.lab2;

import org.junit.jupiter.api.Test;
import ru.ifmo.cs.software_testing.lab2.utility.FunctionSystem;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionSystemTest {
	private final double EPS = 1e-5;
	private FunctionSystem funcSystem = new FunctionSystem();

	@Test
	void logSystemTest() {
		for (Double x :
				Arrays.asList(0.5, 1.0, 1.3, 2.0, 2.5, 3.0, 3.5, 12.23123, 20.0)) {
			double mathLog2 = Math.log(x) / Math.log(2);
			double mathLog3 = Math.log(x) / Math.log(3);

			double math = Math.pow(mathLog2 * Math.pow(mathLog2, 3) - mathLog2, 2) / mathLog3;
			Double calc = funcSystem.calc(x);
			System.out.printf("f(%f) = %f; expected: %f\n", x, calc, math);
			assertEquals(math, calc, EPS);
		}
	}

	@Test
	void trigSystemTest() {
		for (Double x :
				Arrays.asList(-0.5, -1.0, -1.3, -2.0, -2.5, -3.0, -3.5, -Math.PI / 2 - 0.3, -1231.23123)) {
			double math = ((2 * Math.tan(x) + Math.sin(x)) * Math.tan(x) / (1 / Math.sin(x))) - 1;
			Double calc = funcSystem.calc(x);
			System.out.printf("f(%f) = %f; expected: %f\n", x, calc, math);
			assertEquals(math, calc, 1e-2);
		}
	}
}
