package ru.ifmo.cs.software_testing.lab1.domain_model.nextTry;

import java.rmi.UnexpectedException;

public class Whale extends Creature {
	public Whale(boolean isAlive, Position position) {
		super(isAlive);
		this.setPosition(position);
	}

	public void die() throws UnexpectedException {
		this.setAlive(false);
		this.realize("I am not whale anymore");
	}
}
