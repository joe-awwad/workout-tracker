package com.joeaouad.tracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distance {
    private long value;

    private DistanceUnit unit;

    public static Distance ofMeters(long value) {
        return new Distance(value, DistanceUnit.METER);
    }

    public static Distance ofKms(long value) {
        return new Distance(value, DistanceUnit.KM);
    }
}
