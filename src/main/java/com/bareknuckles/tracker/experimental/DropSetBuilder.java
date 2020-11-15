package com.bareknuckles.tracker.experimental;

import com.bareknuckles.tracker.domain.Weight;
import com.bareknuckles.tracker.domain.exercises.WeightLiftingEquipment;
import com.bareknuckles.tracker.domain.exercises.WeightLiftingExercise;
import com.bareknuckles.tracker.domain.exercises.WeightLiftingPosition;
import com.bareknuckles.tracker.domain.sets.DropSet;
import com.bareknuckles.tracker.domain.sets.WeightLiftingSet;

import java.time.Duration;

public class DropSetBuilder<T> {

    private final T parentBuilder;

    private final WeightLiftingExercise exercise;

    private final DropSet dropSet = new DropSet();

    public DropSetBuilder(T parentBuilder, WeightLiftingExercise exercise) {
        this.parentBuilder = parentBuilder;
        this.exercise = exercise;
    }

    public T done() {
        this.exercise.addSet(this.dropSet);
        return this.parentBuilder;
    }

    public T done(int sets) {
        this.exercise.addSet(this.dropSet, sets);
        return this.parentBuilder;
    }

    public DropBuilder<DropSetBuilder<T>> drop() {
        return new DropBuilder<>(this, this.dropSet);
    }
}

class DropBuilder<T> {

    private final T parentBuilder;

    private final DropSet dropSet;

    private final WeightLiftingSet.WeightLiftingSetBuilder builder = WeightLiftingSet.builder();

    public DropBuilder(T parentBuilder, DropSet dropSet) {
        this.parentBuilder = parentBuilder;
        this.dropSet = dropSet;
    }

    public T and() {
        this.dropSet.addDrop(this.builder.build());
        return parentBuilder;
    }

    public DropBuilder<T> weight(Weight weight) {
        builder.weight(weight);
        return this;
    }

    public DropBuilder<T> equipment(WeightLiftingEquipment equipment) {
        builder.equipment(equipment);
        return this;
    }

    public DropBuilder<T> position(WeightLiftingPosition position) {
        builder.position(position);
        return this;
    }

    public DropBuilder<T> reps(int reps) {
        builder.reps(reps);
        return this;
    }

    public DropBuilder<T> rest(Duration rest) {
        builder.rest(rest);
        return this;
    }
}