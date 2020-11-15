package com.joeaouad.tracker.experimental;

import com.joeaouad.tracker.domain.Distance;
import com.joeaouad.tracker.domain.WorkoutSection;
import com.joeaouad.tracker.domain.exercises.SprintingExercise;
import com.joeaouad.tracker.domain.sets.SprintType;
import com.joeaouad.tracker.domain.sets.SprintingSet;

import java.time.Duration;

public class SprintingComposer implements WorkoutSectionComposer {

    private static final String SPRINTS = "Sprints";
    private static final String SPRINT = "Sprint";
    private final SprintingExercise sprints;
    private String name = SPRINTS;

    public SprintingComposer() {
        this.sprints = new SprintingExercise();
        this.sprints.setName(SPRINT);
    }

    @Override
    public WorkoutSection compose() {
        WorkoutSection section = new WorkoutSection();
        section.setName(this.name);
        section.addExercise(this.sprints);
        return section;
    }

    public SprintingComposer name(String name) {
        this.name = name;
        return this;
    }

    public SprintingComposer flat(Distance distance, Duration rest) {
        return distanceSprint(distance, SprintType.FLAT, rest);
    }

    public SprintingComposer flat(Duration duration, Duration rest) {
        return durationSprint(duration, SprintType.FLAT, rest);
    }

    public SprintingComposer uphill(Distance distance, Duration rest) {
        return distanceSprint(distance, SprintType.INCLINED, rest);
    }

    public SprintingComposer uphill(Duration duration, Duration rest) {
        return durationSprint(duration, SprintType.INCLINED, rest);
    }

    public SprintingComposer flat(int sets, Distance distance, Duration rest) {
        return distanceSprint(sets, distance, SprintType.FLAT, rest);
    }

    public SprintingComposer flat(int sets, Duration duration, Duration rest) {
        return durationSprint(sets, duration, SprintType.FLAT, rest);
    }

    public SprintingComposer uphill(int sets, Distance distance, Duration rest) {
        return distanceSprint(sets, distance, SprintType.INCLINED, rest);
    }

    public SprintingComposer uphill(int sets, Duration duration, Duration rest) {
        return durationSprint(sets, duration, SprintType.INCLINED, rest);
    }

    private SprintingComposer distanceSprint(Distance distance, SprintType sprintType, Duration rest) {
        this.sprints.addSet(SprintingSet.builder().distance(distance).type(sprintType).rest(rest).build());
        return this;
    }

    private SprintingComposer durationSprint(Duration duration, SprintType sprintType, Duration rest) {
        this.sprints.addSet(SprintingSet.builder().duration(duration).type(sprintType).rest(rest).build());
        return this;
    }

    private SprintingComposer distanceSprint(int sets, Distance distance, SprintType sprintType, Duration rest) {
        this.sprints.addSet(SprintingSet.builder().distance(distance).type(sprintType).rest(rest).build(), sets);
        return this;
    }

    private SprintingComposer durationSprint(int sets, Duration duration, SprintType sprintType, Duration rest) {
        this.sprints.addSet(SprintingSet.builder().duration(duration).type(sprintType).rest(rest).build(), sets);
        return this;
    }
}
