package com.bareknuckles.tracker.domain.sets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
public class DurationSet extends ExerciseSet {

    private Duration duration;

    public DurationSet(Duration duration) {
        this.duration = duration;
    }

    public DurationSet(Duration duration, Duration rest) {
        super(rest);
        this.duration = duration;
    }
}
