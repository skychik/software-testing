package ru.ifmo.cs.software_testing.lab1.domain_model.entity.utility;

import lombok.Getter;
import lombok.Setter;

public abstract class EntityWithAwareness extends Entity {
	@Getter
	@Setter
	private AwarenessState awarenessState;
}
