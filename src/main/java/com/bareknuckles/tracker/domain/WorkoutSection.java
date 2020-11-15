package com.bareknuckles.tracker.domain;

import com.bareknuckles.tracker.domain.exercises.Exercise;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkoutSection {
    private String name;

    private List<Exercise> exercises = new ArrayList<>();

    public WorkoutSection(String name, List<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }
}
