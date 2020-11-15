package com.joeaouad.tracker.domain.sets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DropSet extends WeightLiftingSet {

    private List<WeightLiftingSet> drops = new ArrayList<>();

    public DropSet(WeightLiftingSet... sets) {
        this.drops = Arrays.asList(sets);
    }

    public DropSet(List<WeightLiftingSet> sets) {
        this.drops = sets;
    }

    public DropSet(List<WeightLiftingSet> sets, Duration rest) {
        setRest(rest);
        this.drops = sets;
    }

    public void addDrop(WeightLiftingSet set) {
        this.drops.add(set);
    }
}