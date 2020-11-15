package com.joeaouad.tracker.domain.exercises;

import com.joeaouad.tracker.domain.sets.IsometricSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IsometricExercise extends TypedExercise<IsometricSet> {
    public IsometricExercise(String name) {
        super(name);
    }
}
