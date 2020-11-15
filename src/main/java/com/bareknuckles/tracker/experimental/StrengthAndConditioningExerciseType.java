package com.bareknuckles.tracker.experimental;

import lombok.Getter;

@Getter
public enum StrengthAndConditioningExerciseType {
    SQUAT("Squat"),
    DEADLIFT("Deadlift"),
    BENCH_PRESS("Bench Press"),
    MILITARY_PRESS("Military Press"),
    PLANK("Plank"),
    PULL_UP("Pull-up"),
    CHIN_UP("Chin-up"),
    LEG_EXTENSION("Leg Extension"),
    LEG_ADDUCTION("Leg Adduction");

    private final String value;

    StrengthAndConditioningExerciseType(String value) {
        this.value = value;
    }
}
