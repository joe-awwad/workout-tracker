package com.joeaouad.tracker.domain.exercises;

import com.joeaouad.tracker.domain.sets.WeightLiftingSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeightLiftingExercise extends TypedExercise<WeightLiftingSet> {

    public WeightLiftingExercise(String name) {
        super(name);
    }
}
