package com.bareknuckles.tracker.domain.exercises;

import com.bareknuckles.tracker.domain.CircuitType;
import com.bareknuckles.tracker.domain.sets.CircuitSet;
import lombok.Getter;
import lombok.Setter;

import static com.bareknuckles.tracker.domain.CircuitType.CIRCUIT;


@Getter
@Setter
public class CircuitExercise extends TypedExercise<CircuitSet> {
    private CircuitType circuitType = CIRCUIT;
}
