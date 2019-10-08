package ru.ifmo.cs.software_testing.lab1.domain_model.nextTry;

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

	public Creature(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void startRealizing(String fact) throws UnexpectedException {
		factAwarenesses.putIfAbsent(fact, AwarenessType.TRYING_TO_AWARE);
		if (factAwarenesses.get(fact) != AwarenessType.NOT_AWARE) {
			factAwarenesses.put(fact, AwarenessType.TRYING_TO_AWARE);
		} else {
			throw new UnexpectedException("Already tried to realize!");
		}
	}

	public void realize(String fact) throws UnexpectedException {
		if (factAwarenesses.get(fact) == null) {
			factAwarenesses.put(fact, AwarenessType.AWARE);
		} else if (factAwarenesses.get(fact) == AwarenessType.AWARE) {
			throw new UnexpectedException("Already realized!");
		} else {
			factAwarenesses.put(fact, AwarenessType.AWARE);
		}
	}
}
