package com.joeaouad.tracker.domain.sets;

import com.joeaouad.tracker.domain.exercises.SingleSetExercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperSet extends ExerciseSet {

    private SingleSetExercise exercise1;

    private SingleSetExercise exercise2;

    public SuperSet(SingleSetExercise exercise1, SingleSetExercise exercise2, Duration rest) {
        super(rest);
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
    }
}
