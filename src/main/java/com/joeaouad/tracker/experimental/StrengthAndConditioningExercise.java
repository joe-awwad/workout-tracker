package com.joeaouad.tracker.experimental;

import lombok.Getter;

import static com.joeaouad.tracker.experimental.ExerciseType.ISOMETRIC;
import static com.joeaouad.tracker.experimental.ExerciseType.ISOTONIC;

@Getter
public enum StrengthAndConditioningExercise {
    SQUAT("Squat", ISOTONIC),
    DEADLIFT("Deadlift", ISOTONIC),
    BENCH_PRESS("Bench Press", ISOTONIC),
    MILITARY_PRESS("Military Press", ISOTONIC),
    PLANK("Plank", ISOMETRIC),
    SIDE_PLANK("Side Plank", ISOMETRIC),
    DUMBBELL_SWING("Dumbbell Swing", ISOTONIC),
    PULL_UP("Pull-up", ISOTONIC),
    CHIN_UP("Chin-up", ISOTONIC),
    LEG_EXTENSION("Leg Extension", ISOTONIC),
    LEG_ADDUCTION("Leg Adduction", ISOTONIC);

    private final String value;

    private final ExerciseType exerciseType;

    StrengthAndConditioningExercise(String value, ExerciseType exerciseType) {
        this.value = value;
        this.exerciseType = exerciseType;
    }
}
