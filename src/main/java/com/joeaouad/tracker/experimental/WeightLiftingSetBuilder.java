package com.joeaouad.tracker.experimental;

import com.joeaouad.tracker.domain.Weight;
import com.joeaouad.tracker.domain.exercises.WeightLiftingEquipment;
import com.joeaouad.tracker.domain.exercises.WeightLiftingExercise;
import com.joeaouad.tracker.domain.exercises.WeightLiftingPosition;
import com.joeaouad.tracker.domain.sets.WeightLiftingSet;

import java.time.Duration;

public class WeightLiftingSetBuilder<T> {

    protected final T parentBuilder;

    protected final WeightLiftingExercise exercise;

    protected final WeightLiftingSet.WeightLiftingSetBuilder builder = WeightLiftingSet.builder();

    public WeightLiftingSetBuilder(T parentBuilder, WeightLiftingExercise exercise) {
        this.parentBuilder = parentBuilder;
        this.exercise = exercise;
    }

    public T done() {
        this.exercise.addSet(this.builder.build());
        return this.parentBuilder;
    }

    public T done(int sets) {
        this.exercise.addSet(this.builder.build(), sets);
        return this.parentBuilder;
    }

    public WeightLiftingSetBuilder<T> weight(Weight weight) {
        builder.weight(weight);
        return this;
    }

    public WeightLiftingSetBuilder<T> equipment(WeightLiftingEquipment equipment) {
        builder.equipment(equipment);
        return this;
    }

    public WeightLiftingSetBuilder<T> position(WeightLiftingPosition position) {
        builder.position(position);
        return this;
    }

    public WeightLiftingSetBuilder<T> reps(int reps) {
        builder.reps(reps);
        return this;
    }

    public WeightLiftingSetBuilder<T> rest(Duration rest) {
        builder.rest(rest);
        return this;
    }

    public DropSetBuilder<T> dropSet() {
        return new DropSetBuilder<>(this.parentBuilder, this.exercise);
    }

}