package com.joeaouad.tracker.experimental;


import com.joeaouad.tracker.domain.StrikingType;
import com.joeaouad.tracker.domain.WorkoutSection;
import com.joeaouad.tracker.domain.exercises.StrikingExercise;
import com.joeaouad.tracker.domain.sets.StrikingSet;

import java.time.Duration;

public class BoxingComposer implements WorkoutSectionComposer {

    private static final String BOXING = "BOXING";

    private final StrikingExercise boxing;

    private String name = BOXING;

    public BoxingComposer() {
        this.boxing = new StrikingExercise();
        this.boxing.setName(BOXING);
    }

    @Override
    public WorkoutSection compose() {
        WorkoutSection section = new WorkoutSection();
        section.setName(this.name);
        section.addExercise(this.boxing);
        return section;
    }

    public BoxingComposer name(String name) {
        this.name = name;
        return this;
    }

    public BoxingComposer boxing(Duration duration, Duration rest) {
        return doBoxing(StrikingType.GENERIC, duration, rest);
    }

    public BoxingComposer shadow(Duration duration, Duration rest) {
        return doBoxing(StrikingType.SHADOW, duration, rest);
    }

    public BoxingComposer pads(Duration duration, Duration rest) {
        return doBoxing(StrikingType.PADS, duration, rest);
    }

    public BoxingComposer virtual(Duration duration, Duration rest) {
        return doBoxing(StrikingType.VIRTUAL, duration, rest);
    }

    public BoxingComposer heavyBag(Duration duration, Duration rest) {
        return doBoxing(StrikingType.HEAVY_BAG, duration, rest);
    }

    public BoxingComposer boxing(int rounds, Duration duration, Duration rest) {
        return doBoxing(rounds, StrikingType.GENERIC, duration, rest);
    }

    public BoxingComposer shadow(int rounds, Duration duration, Duration rest) {
        return doBoxing(rounds, StrikingType.SHADOW, duration, rest);
    }

    public BoxingComposer pads(int rounds, Duration duration, Duration rest) {
        return doBoxing(rounds, StrikingType.PADS, duration, rest);
    }

    public BoxingComposer virtual(int rounds, Duration duration, Duration rest) {
        return doBoxing(rounds, StrikingType.VIRTUAL, duration, rest);
    }

    public BoxingComposer heavyBag(int rounds, Duration duration, Duration rest) {
        return doBoxing(rounds, StrikingType.HEAVY_BAG, duration, rest);
    }

    private BoxingComposer doBoxing(StrikingType strikingType, Duration duration, Duration rest) {
        this.boxing.addSet(new StrikingSet(strikingType, duration, rest));
        return this;
    }

    private BoxingComposer doBoxing(int rounds, StrikingType strikingType, Duration duration, Duration rest) {
        this.boxing.addSet(new StrikingSet(strikingType, duration, rest), rounds);
        return this;
    }
}
