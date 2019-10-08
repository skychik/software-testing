package ru.ifmo.cs.software_testing.lab1.domain_model.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Whale extends Creature {

	@Override
	public String getType() {
		return "whale";
	}

	public void swim() {
	}
}
