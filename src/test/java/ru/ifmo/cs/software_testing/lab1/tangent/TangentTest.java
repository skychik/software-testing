package ru.ifmo.cs.software_testing.lab1.tangent;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TangentTest {
    private final double EPS = 1e-5;

	@Test
    void tan() {
    	for (Double num :
			    Arrays.asList(0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, Math.PI, Math.PI / 2 - 0.05, -1.0, -1231.23123)) {
		    System.out.printf("Test, x = %f\n", num);
		    assertEquals(Math.tan(num), Tangent.tan(num), EPS);
		    System.out.println("passed");
	    }
    }
}
