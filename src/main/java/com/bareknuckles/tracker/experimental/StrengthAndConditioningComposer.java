package com.bareknuckles.tracker.experimental;


import com.bareknuckles.tracker.domain.WorkoutSection;
import com.bareknuckles.tracker.domain.exercises.WeightLiftingExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.bareknuckles.tracker.experimental.StrengthAndConditioningExerciseType.*;

public class StrengthAndConditioningComposer implements WorkoutSectionComposer {

    private static final String STRENGTH_AND_CONDITIONING = "Strength & Conditioning";

    private final Map<StrengthAndConditioningExerciseType, WeightLiftingExercise> weightLiftingExercises;

    private String name = STRENGTH_AND_CONDITIONING;

    public StrengthAndConditioningComposer() {
        this(new HashMap<>());
        Arrays.stream(StrengthAndConditioningExerciseType.values())
                .forEach(item -> this.weightLiftingExercises.put(item, new WeightLiftingExercise(item.getValue())));
    }

    public StrengthAndConditioningComposer(Map<StrengthAndConditioningExerciseType, WeightLiftingExercise> weightLiftingExercises) {
        this.weightLiftingExercises = weightLiftingExercises;
    }

    @Override
    public WorkoutSection compose() {
        WorkoutSection section = new WorkoutSection();
        section.setName(this.name);
        this.weightLiftingExercises.values().stream()
                .filter(WeightLiftingExercise::isNotEmpty)
                .forEach(section::addExercise);
        return section;
    }

    public StrengthAndConditioningComposer name(String name) {
        this.name = name;
        return this;
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> squat() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(SQUAT));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> deadlift() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(DEADLIFT));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> benchPress() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(BENCH_PRESS));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> militaryPress() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(MILITARY_PRESS));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> plank() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(PLANK));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> pullup() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(PULL_UP));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> chinup() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(CHIN_UP));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> legExtension() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(LEG_EXTENSION));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> legAdduction() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(LEG_ADDUCTION));
    }
}
