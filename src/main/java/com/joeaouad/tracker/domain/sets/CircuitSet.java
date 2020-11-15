package com.joeaouad.tracker.domain.sets;

import com.joeaouad.tracker.domain.exercises.SingleSetExercise;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CircuitSet extends ExerciseSet {

    private List<SingleSetExercise> exercises = new ArrayList<>();

    public CircuitSet(List<SingleSetExercise> exercises) {
        this.exercises = exercises;
    }

    public CircuitSet(List<SingleSetExercise> exercises, Duration rest) {
        super(rest);
        this.exercises = exercises;
    }

    public void addExercise(SingleSetExercise exercise) {
        this.exercises.add(exercise);
    }
}
