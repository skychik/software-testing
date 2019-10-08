package ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility;

import lombok.Getter;

import java.util.ArrayList;

public abstract class Entity {
	@Getter
	private String type;
	ArrayList<Relation> relations = new ArrayList<>();
}
