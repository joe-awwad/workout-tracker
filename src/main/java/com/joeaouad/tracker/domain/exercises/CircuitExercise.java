package com.joeaouad.tracker.domain.exercises;

import com.joeaouad.tracker.domain.CircuitType;
import com.joeaouad.tracker.domain.sets.CircuitSet;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CircuitExercise extends TypedExercise<CircuitSet> {
    private CircuitType circuitType = CircuitType.CIRCUIT;
}
