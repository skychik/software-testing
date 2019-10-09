package ru.ifmo.cs.software_testing.lab1.domain_model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ifmo.cs.software_testing.lab1.domain_model.AwarenessType.AWARE;
import static ru.ifmo.cs.software_testing.lab1.domain_model.AwarenessType.TRYING_TO_AWARE;

class CreatureTest {
	private Creature creature;

	@BeforeEach
	void create() {
		creature = new Creature(true, Position.NORMAL);
	}

	@Test
	void beginToUnderstand() {
		String fact1 = "fact1";
		assertDoesNotThrow(() -> creature.beginToUnderstand(fact1));
		assert creature.getFactAwarenesses().get(fact1) == TRYING_TO_AWARE;
		assertThrows(UnexpectedException.class, () -> creature.beginToUnderstand(fact1));

		String fact2 = "fact2";
		assertDoesNotThrow(() -> creature.beAwareOf(fact2));
		assertThrows(UnexpectedException.class, () -> creature.beginToUnderstand(fact2));
	}

	@Test
	void beAwareOf() {
		String fact1 = "fact1";
		assertDoesNotThrow(() -> creature.beAwareOf(fact1));
		assert creature.getFactAwarenesses().get(fact1) == AWARE;
		assertThrows(UnexpectedException.class, () -> creature.beAwareOf(fact1));
	}

	@Test
	void position() {
		Position[] positions = Position.values();
		for (Position pos : positions) {
			creature.setPosition(pos);
			assert creature.getPosition() == pos;
		}
	}

	@Test
	void alive() {
		assert creature.isAlive();
		creature.setAlive(false);
		assert !creature.isAlive();
	}

	@Test
	void getFactAwarenesses() {
		String[] facts = { "f1", "f2", "f3", "f4", "f5" };
		assertDoesNotThrow(() -> creature.beAwareOf(facts[0]));
		assertDoesNotThrow(() -> creature.beginToUnderstand(facts[1]));
		assertDoesNotThrow(() -> creature.beginToUnderstand(facts[2]));

		Map<String, AwarenessType> awarenesses = new HashMap<>();
		awarenesses.put(facts[1], TRYING_TO_AWARE);
		awarenesses.put(facts[0], AWARE);
		awarenesses.put(facts[2], TRYING_TO_AWARE);
		assert creature.getFactAwarenesses().equals(awarenesses);
	}
}