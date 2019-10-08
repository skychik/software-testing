package ru.ifmo.cs.software_testing.lab1.domain_model.entity;

import lombok.Getter;
import ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility.Entity;

import java.util.ArrayList;

public class Character {
	@Getter
	private ArrayList<Entity> properties = new ArrayList<>();

	public void is(Entity entity) {
		properties.add(entity);
	}
}
