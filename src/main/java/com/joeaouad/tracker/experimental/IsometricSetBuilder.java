package com.joeaouad.tracker.experimental;

import com.joeaouad.tracker.domain.Weight;
import com.joeaouad.tracker.domain.exercises.IsometricExercise;
import com.joeaouad.tracker.domain.sets.IsometricSet;

import java.time.Duration;

public class IsometricSetBuilder<T> {

    protected final T parentBuilder;

    protected final IsometricExercise exercise;

    protected final IsometricSet.IsometricSetBuilder builder = IsometricSet.builder();

    public IsometricSetBuilder(T parentBuilder, IsometricExercise exercise) {
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

    public IsometricSetBuilder<T> weight(Weight weight) {
        builder.weight(weight);
        return this;
    }

    public IsometricSetBuilder<T> duration(Duration duration) {
        builder.duration(duration);
        return this;
    }

    public IsometricSetBuilder<T> rest(Duration rest) {
        builder.rest(rest);
        return this;
    }
}