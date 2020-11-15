package com.joeaouad.tracker.domain.sets;

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
        @JsonSubTypes.Type(value = RepetitionSet.class, name = "RepetitionSet"),
        @JsonSubTypes.Type(value = DurationSet.class, name = "DurationSet"),
        @JsonSubTypes.Type(value = DistanceSet.class, name = "DistanceSet"),
        @JsonSubTypes.Type(value = BodyWeightSet.class, name = "BodyWeightSet"),
        @JsonSubTypes.Type(value = WeightLiftingSet.class, name = "WeightLiftingSet"),
        @JsonSubTypes.Type(value = CircuitSet.class, name = "CircuitSet"),
        @JsonSubTypes.Type(value = SuperSet.class, name = "SuperSet"),
        @JsonSubTypes.Type(value = DropSet.class, name = "DropSet"),
        @JsonSubTypes.Type(value = StrikingSet.class, name = "StrikingSet"),
        @JsonSubTypes.Type(value = SprintingSet.class, name = "SprintingSet"),
        @JsonSubTypes.Type(value = IsometricSet.class, name = "IsometricSet"),
})
public class ExerciseSet {
    private Duration rest;

    public ExerciseSet(Duration rest) {
        this.rest = rest;
    }
}
