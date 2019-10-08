package ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility;

import java.util.Objects;

public class Relation {
	public final RelationType relationType;
	public final Entity entity;

	public Relation(RelationType relationType, Entity entity) {
		this.relationType = relationType;
		this.entity = entity;
	}

	public String toString() {
		return "Relation[" + relationType + "," + entity + "]";
	}

	public boolean equals(Relation relation) {
		return Objects.equals(relationType, relation.relationType) &&
				Objects.equals(entity, relation.entity);
	}

	public int hashCode() {
		if (relationType == null) return (entity == null) ? 0 : entity.hashCode() + 1;
		else if (entity == null) return relationType.hashCode() + 2;
		else return relationType.hashCode() * 17 + entity.hashCode();
	}
}
