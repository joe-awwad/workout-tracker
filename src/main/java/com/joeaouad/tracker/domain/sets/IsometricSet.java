package com.joeaouad.tracker.domain.sets;

import com.joeaouad.tracker.domain.Weight;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class IsometricSet extends DurationSet {

    private Weight weight;

    @Builder
    public IsometricSet(Duration duration, Weight weight, Duration rest) {
        super(duration, rest);
        this.weight = weight;
    }

    public IsometricSet(Duration duration, Weight weight) {
        super(duration);
        this.weight = weight;
    }
}
