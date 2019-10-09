package ru.ifmo.cs.software_testing.lab1.domain_model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ifmo.cs.software_testing.lab1.domain_model.DomainModel.*;

class DomainModelTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	void testOutput() {
		TIME_TO_LIVE = 1000;
		TIME_TO_REALIZE = TIME_TO_LIVE + 1000;
		TOTAL_TIME = TIME_TO_REALIZE + 1000;
		main(null);

		assertEquals("Whale appears\n" +
				"Whale starts realizing itself as a whale\n" +
				"Whale died ;(\n" +
				"Couldn't beAwareOf such fact: I am whale\n" +
				"whale awarenesses={I am not whale anymore!=AWARE, I am whale=TRYING_TO_AWARE}\n", outContent.toString());
	}
}