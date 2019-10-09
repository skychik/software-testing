package ru.ifmo.cs.software_testing.lab1.domain_model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;

import static org.junit.jupiter.api.Assertions.*;

class WhaleTest {
	@Test
	void dying() {
		Whale whale = new Whale(false, Position.NOT_NORMAL);
		assert !whale.isAlive();
		assertThrows(UnexpectedException.class, whale::die);
	}
}