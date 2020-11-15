package com.bareknuckles.tracker.experimental;

import com.bareknuckles.tracker.domain.Workout;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkoutBuilder {

    private final List<WorkoutSectionComposer> composers = new ArrayList<>();

    private String name;

    private Duration duration;

    private OffsetDateTime dateTime = OffsetDateTime.now();

    public static WorkoutBuilder get() {
        return new WorkoutBuilder();
    }

    public WorkoutBuilder name(String name) {
        this.name = name;
        return this;
    }

    public WorkoutBuilder duration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public WorkoutBuilder dateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public WorkoutBuilder composeWith(WorkoutSectionComposer composer) {
        this.composers.add(composer);
        return this;
    }

    public Workout build() {
        Workout workout = new Workout();
        workout.setName(this.name);
        workout.setDuration(this.duration);
        workout.setDateTime(this.dateTime);

        this.composers.stream()
                .map(WorkoutSectionComposer::compose)
                .forEach(workout::addSection);

        return workout;
    }
}
