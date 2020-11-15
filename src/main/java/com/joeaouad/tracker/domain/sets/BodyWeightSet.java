package com.joeaouad.tracker.domain.sets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;


@Getter
@Setter
@NoArgsConstructor
public class BodyWeightSet extends RepetitionSet {
    public BodyWeightSet(long reps) {
        super(reps);
    }

    public BodyWeightSet(long reps, Duration rest) {
        super(reps, rest);
    }
}
