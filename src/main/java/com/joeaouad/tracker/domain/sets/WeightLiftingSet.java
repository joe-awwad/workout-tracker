package com.joeaouad.tracker.domain.sets;

import com.joeaouad.tracker.domain.Weight;
import com.joeaouad.tracker.domain.exercises.WeightLiftingEquipment;
import com.joeaouad.tracker.domain.exercises.WeightLiftingPosition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;


@Getter
@Setter
@NoArgsConstructor
public class WeightLiftingSet extends RepetitionSet {

    private Weight weight;

    private WeightLiftingEquipment equipment;

    private WeightLiftingPosition position;

    @Builder
    public WeightLiftingSet(long reps, Duration rest, Weight weight, WeightLiftingEquipment equipment, WeightLiftingPosition position) {
        super(reps, rest);
        this.weight = weight;
        this.equipment = equipment;
        this.position = position;
    }
}
