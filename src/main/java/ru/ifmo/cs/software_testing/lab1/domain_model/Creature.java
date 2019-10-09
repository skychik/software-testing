package ru.ifmo.cs.software_testing.lab1.domain_model;

import lombok.Getter;
import lombok.Setter;

import java.rmi.UnexpectedException;
import java.util.HashMap;
import java.util.Map;

public class Creature {
	@Getter
	@Setter
	private Position position;
	@Getter
	@Setter
	private boolean isAlive;
	@Getter
	private Map<String, AwarenessType> factAwarenesses = new HashMap<>();

	public Creature(boolean isAlive, Position position) {
		this.isAlive = isAlive;
		this.position = position;
	}

	public void beginToUnderstand(String fact) throws UnexpectedException {
		if (factAwarenesses.get(fact) == null) {
			factAwarenesses.put(fact, AwarenessType.TRYING_TO_AWARE);
		} else if (factAwarenesses.get(fact) == AwarenessType.NOT_AWARE) {
			factAwarenesses.put(fact, AwarenessType.TRYING_TO_AWARE);
		} else {
			throw new UnexpectedException("Already tried to aware!");
		}
	}

	public void beAwareOf(String fact) throws UnexpectedException {
		if (factAwarenesses.get(fact) == null) {
			factAwarenesses.put(fact, AwarenessType.AWARE);
		} else if (factAwarenesses.get(fact) == AwarenessType.AWARE) {
			throw new UnexpectedException("Already awared!");
		} else {
			factAwarenesses.put(fact, AwarenessType.AWARE);
		}
	}
}
