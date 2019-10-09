package ru.ifmo.cs.software_testing.lab1.domain_model;

import java.rmi.UnexpectedException;

public class Whale extends Creature {

	public Whale(boolean isAlive, Position position) {
		super(isAlive, position);
	}

	public void die() throws UnexpectedException {
		if (!isAlive()) {
			throw new UnexpectedException("Already dead!");
		}
		this.setAlive(false);
		this.beAwareOf("I am not whale anymore!");
	}
}
