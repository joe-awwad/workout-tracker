package com.joeaouad.tracker.domain.sets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
public class RepetitionSet extends ExerciseSet {

    private long reps;

    public RepetitionSet(long reps) {
        this.reps = reps;
    }

    public RepetitionSet(long reps, Duration rest) {
        super(rest);
        this.reps = reps;
    }
}
