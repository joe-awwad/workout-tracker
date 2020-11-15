package com.joeaouad.tracker.domain.exercises;

import com.joeaouad.tracker.domain.sets.SuperSetExercise;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleSetExercise.class, name = "SingleSetExercise"),
        @JsonSubTypes.Type(value = WeightLiftingExercise.class, name = "WeightLiftingExercise"),
        @JsonSubTypes.Type(value = BodyWeightExercise.class, name = "BodyWeightExercise"),
        @JsonSubTypes.Type(value = CircuitExercise.class, name = "CircuitExercise"),
        @JsonSubTypes.Type(value = SuperSetExercise.class, name = "SuperSetExercise"),
        @JsonSubTypes.Type(value = SprintingExercise.class, name = "SprintingExercise"),
        @JsonSubTypes.Type(value = StrikingExercise.class, name = "StrikingExercise"),
        @JsonSubTypes.Type(value = DistanceExercise.class, name = "DistanceExercise"),
        @JsonSubTypes.Type(value = DurationExercise.class, name = "DurationExercise"),
        @JsonSubTypes.Type(value = RepetitionExercise.class, name = "RepetitionExercise"),
        @JsonSubTypes.Type(value = TypedExercise.class, name = "TypedExercise"),
        @JsonSubTypes.Type(value = IsometricExercise.class, name = "IsometricExercise"),
})
public class Exercise {

    private String name;

    private Duration rest;

    public Exercise(String name) {
        this.name = name;
    }

    public Exercise(String name, Duration rest) {
        this.name = name;
        this.rest = rest;
    }
}
