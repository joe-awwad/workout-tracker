package com.bareknuckles.tracker.domain.sets;

import com.bareknuckles.tracker.domain.StrikingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
public class StrikingSet extends DurationSet {

    private StrikingType strikingType;

    public StrikingSet(Duration duration, Duration rest) {
        super(duration, rest);
    }

    public StrikingSet(StrikingType strikingType, Duration duration) {
        super(duration);
        this.strikingType = strikingType;
    }

    public StrikingSet(StrikingType strikingType, Duration duration, Duration rest) {
        super(duration, rest);
        this.strikingType = strikingType;
    }
}
