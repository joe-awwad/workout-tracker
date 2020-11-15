package com.bareknuckles.tracker.experimental;

import com.bareknuckles.tracker.domain.Workout;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static com.bareknuckles.tracker.domain.Distance.ofMeters;
import static com.bareknuckles.tracker.domain.Weight.ofKgs;
import static com.bareknuckles.tracker.experimental.Composers.*;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static java.time.OffsetDateTime.now;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@JsonTest
public class WorkoutBuilderTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldBuildWorkout() {
        Workout workout = WorkoutBuilder.get()
                .name("Joe's Vanilla Workout - 2020")
                .duration(ofMinutes(90))
                .dateTime(now())
                .composeWith(strengthAndConditioning()
                        .squat().weight(ofKgs(100)).reps(5).rest(ofMinutes(5)).done()
                        .squat().weight(ofKgs(110)).reps(5).rest(ofMinutes(5)).done()
                        .squat().weight(ofKgs(120)).reps(5).rest(ofMinutes(5)).done()
                        .squat()
                        .dropSet()
                        .drop().weight(ofKgs(125)).reps(2).and()
                        .drop().weight(ofKgs(115)).reps(4).and()
                        .drop().weight(ofKgs(105)).reps(6).and()
                        .done()
                        .deadlift().weight(ofKgs(140)).reps(5).rest(ofMinutes(5)).done())
                .composeWith(boxing()
                        .shadow(3, ofMinutes(3), ofMinutes(1))
                        .heavyBag(11, ofMinutes(3), ofMinutes(1)))
                .composeWith(sprinting()
                        .flat(5, ofMeters(100), ofMinutes(2))
                        .flat(5, ofSeconds(12), ofMinutes(2)))
                .build();

        assertNotNull(workout);

        assertDoesNotThrow(() -> deserialize(serialize(workout), Workout.class));
    }

    private <T> String deserialize(String serialized, Class<T> clazz) throws JsonProcessingException {
        return this.objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(objectMapper.readValue(serialized, clazz));
    }

    private String serialize(Workout workout) throws JsonProcessingException {
        return this.objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(workout);
    }
}
