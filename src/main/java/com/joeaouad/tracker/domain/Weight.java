package com.joeaouad.tracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weight {
    private double value;

    private WeightUnit unit;

    public static Weight ofKgs(double value) {
        return new Weight(value, WeightUnit.KG);
    }

    public static Weight ofPounds(double value) {
        return new Weight(value, WeightUnit.POUND);
    }

    public static Weight ofPlates(long value) {
        return new Weight(value, WeightUnit.PLATE);
    }

    public static Weight bodyweight() {
        return new Weight(1, WeightUnit.BODY_WEIGHT);
    }
}
