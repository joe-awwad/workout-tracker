package com.joeaouad.tracker.experimental;


import com.joeaouad.tracker.domain.WorkoutSection;
import com.joeaouad.tracker.domain.exercises.IsometricExercise;
import com.joeaouad.tracker.domain.exercises.WeightLiftingExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.joeaouad.tracker.experimental.ExerciseType.*;
import static com.joeaouad.tracker.experimental.StrengthAndConditioningExercise.*;

public class StrengthAndConditioningComposer implements WorkoutSectionComposer {

    private static final String STRENGTH_AND_CONDITIONING = "Strength & Conditioning";

    private final Map<StrengthAndConditioningExercise, WeightLiftingExercise> weightLiftingExercises;

    private final Map<StrengthAndConditioningExercise, IsometricExercise> isometricExercises;

    private String name = STRENGTH_AND_CONDITIONING;

    public StrengthAndConditioningComposer() {
        this(new HashMap<>(), new HashMap<>());

        Arrays.stream(StrengthAndConditioningExercise.values())
                .filter(item -> Objects.equals(item.getExerciseType(), ISOTONIC))
                .forEach(item -> this.weightLiftingExercises.put(item, new WeightLiftingExercise(item.getValue())));

        Arrays.stream(StrengthAndConditioningExercise.values())
                .filter(item -> Objects.equals(item.getExerciseType(), ISOMETRIC))
                .forEach(item -> this.isometricExercises.put(item, new IsometricExercise(item.getValue())));
    }

    private StrengthAndConditioningComposer(Map<StrengthAndConditioningExercise, WeightLiftingExercise> weightLiftingExercises,
                                            Map<StrengthAndConditioningExercise, IsometricExercise> isometricExercises) {
        this.weightLiftingExercises = weightLiftingExercises;
        this.isometricExercises = isometricExercises;
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

    public IsometricSetBuilder<StrengthAndConditioningComposer> plank() {
        return new IsometricSetBuilder<>(this, this.isometricExercises.get(PLANK));
    }

    public IsometricSetBuilder<StrengthAndConditioningComposer> sidePlank() {
        return new IsometricSetBuilder<>(this, this.isometricExercises.get(SIDE_PLANK));
    }

    public WeightLiftingSetBuilder<StrengthAndConditioningComposer> dumbbellSwing() {
        return new WeightLiftingSetBuilder<>(this, this.weightLiftingExercises.get(DUMBBELL_SWING));
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
