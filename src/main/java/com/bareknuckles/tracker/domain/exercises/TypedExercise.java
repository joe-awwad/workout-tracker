package com.bareknuckles.tracker.domain.exercises;

import com.bareknuckles.tracker.domain.sets.ExerciseSet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypedExercise<T extends ExerciseSet> extends Exercise {

    private List<T> sets = new ArrayList<>();

    public TypedExercise(String name) {
        super(name);
    }

    public TypedExercise(String name, List<T> sets) {
        super(name);
        this.sets = sets;
    }

    public TypedExercise(String name, List<T> sets, Duration rest) {
        super(name, rest);
        this.sets = sets;
    }

    public void addSet(T set) {
        this.sets.add(set);
    }

    public void addSet(T set, int repeatedCount) {
        IntStream.range(0, repeatedCount).forEach(i -> this.sets.add(set));
    }

    public boolean isNotEmpty() {
        return !this.sets.isEmpty();
    }
}
