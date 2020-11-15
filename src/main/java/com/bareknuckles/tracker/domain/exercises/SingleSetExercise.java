package com.bareknuckles.tracker.domain.exercises;

import com.bareknuckles.tracker.domain.sets.ExerciseSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
public class SingleSetExercise extends Exercise {
    private ExerciseSet set;

    public SingleSetExercise(String name, ExerciseSet set) {
        super(name);
        this.set = set;
    }

    public SingleSetExercise(String name, ExerciseSet set, Duration rest) {
        super(name, rest);
        this.set = set;
    }
}
