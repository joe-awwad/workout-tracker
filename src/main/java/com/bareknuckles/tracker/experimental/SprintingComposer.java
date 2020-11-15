package com.bareknuckles.tracker.experimental;

import com.bareknuckles.tracker.domain.Distance;
import com.bareknuckles.tracker.domain.WorkoutSection;
import com.bareknuckles.tracker.domain.exercises.SprintingExercise;
import com.bareknuckles.tracker.domain.sets.SprintType;
import com.bareknuckles.tracker.domain.sets.SprintingSet;

import java.time.Duration;

import static com.bareknuckles.tracker.domain.sets.SprintType.FLAT;
import static com.bareknuckles.tracker.domain.sets.SprintType.INCLINED;

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
        return distanceSprint(distance, FLAT, rest);
    }

    public SprintingComposer flat(Duration duration, Duration rest) {
        return durationSprint(duration, FLAT, rest);
    }

    public SprintingComposer uphill(Distance distance, Duration rest) {
        return distanceSprint(distance, INCLINED, rest);
    }

    public SprintingComposer uphill(Duration duration, Duration rest) {
        return durationSprint(duration, INCLINED, rest);
    }

    public SprintingComposer flat(int sets, Distance distance, Duration rest) {
        return distanceSprint(sets, distance, FLAT, rest);
    }

    public SprintingComposer flat(int sets, Duration duration, Duration rest) {
        return durationSprint(sets, duration, FLAT, rest);
    }

    public SprintingComposer uphill(int sets, Distance distance, Duration rest) {
        return distanceSprint(sets, distance, INCLINED, rest);
    }

    public SprintingComposer uphill(int sets, Duration duration, Duration rest) {
        return durationSprint(sets, duration, INCLINED, rest);
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
