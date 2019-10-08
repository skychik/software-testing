package ru.ifmo.cs.software_testing.lab1.domain_model.entity;

import ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility.Entity;
import ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility.EntityWithAwareness;
import ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility.Relation;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.stream.Collectors;

import static ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility.AwarenessState.*;
import static ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility.RelationType.IS;

public class Creature extends Entity {
	@Override
	public String getType() {
		return "creature";
	}

	public void realize(Entity thing) throws UnexpectedException {
		List<Relation> neededRelations = relations.stream()
				.filter((Relation rel) ->
						rel.relationType == IS &&
						rel.entity instanceof EntityWithAwareness &&
						rel.entity.getType().equals(thing.getType()))
				.collect(Collectors.toList());

		if (neededRelations.size() > 1) {
			throw new UnexpectedException("Several relations with the same RelationType and Entity type!");
		}
		if (neededRelations.size() == 0) {
			EntityWithAwareness newEntity = (EntityWithAwareness) thing;
			newEntity.setAwarenessState(AWARE);
			relations.add(new Relation(IS, newEntity));
		}
		if (neededRelations.size() == 1) {
			EntityWithAwareness entity = (EntityWithAwareness) neededRelations.get(0).entity;
			if (entity.getAwarenessState() == AWARE) {
				throw new UnexpectedException("Already aware!");
			} else {
				entity.setAwarenessState(AWARE);
			}
		}
	}

	public void startRealizing(Entity thing) throws UnexpectedException {
		List<Relation> neededRelations = relations.stream()
				.filter((Relation rel) ->
						rel.relationType == IS &&
								rel.entity instanceof EntityWithAwareness &&
								rel.entity.getType().equals(thing.getType()))
				.collect(Collectors.toList());

		if (neededRelations.size() > 1) {
			throw new UnexpectedException("Several relations with the same RelationType and Entity type!");
		}
		if (neededRelations.size() == 0) {
			EntityWithAwareness newEntity = (EntityWithAwareness) thing;
			newEntity.setAwarenessState(TRYING_TO_AWARE);
			relations.add(new Relation(IS, newEntity));
		}
		if (neededRelations.size() == 1) {
			EntityWithAwareness entity = (EntityWithAwareness) neededRelations.get(0).entity;
			if (entity.getAwarenessState() == TRYING_TO_AWARE) {
				throw new UnexpectedException("Already trying to realize!");
			} else {
				entity.setAwarenessState(AWARE);
			}
		}
	}
}
