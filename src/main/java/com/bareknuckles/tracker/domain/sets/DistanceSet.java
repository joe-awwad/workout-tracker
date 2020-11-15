package com.bareknuckles.tracker.domain.sets;

import com.bareknuckles.tracker.domain.Distance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
public class DistanceSet extends ExerciseSet {

    private Distance distance;

    public DistanceSet(Distance distance) {
        this.distance = distance;
    }

    public DistanceSet(Distance distance, Duration rest) {
        super(rest);
        this.distance = distance;
    }
}
