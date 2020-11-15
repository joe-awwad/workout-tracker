package com.joeaouad.tracker.domain.sets;


import com.joeaouad.tracker.domain.Distance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@AllArgsConstructor
public class SprintingSet extends ExerciseSet {

    private Distance distance;

    private Duration duration;

    private SprintType type;

    public SprintingSet() {
        this.type = SprintType.FLAT;
    }

    @Builder
    public SprintingSet(Distance distance, Duration duration, SprintType type, Duration rest) {
        super(rest);
        this.distance = distance;
        this.duration = duration;
        this.type = type;
    }
}
