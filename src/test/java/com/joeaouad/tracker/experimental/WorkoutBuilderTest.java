package com.joeaouad.tracker.experimental;

import com.joeaouad.tracker.domain.Workout;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joeaouad.tracker.domain.Distance;
import com.joeaouad.tracker.domain.Weight;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static java.time.LocalDateTime.now;
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
                .composeWith(Composers.strengthAndConditioning()
                        .squat().weight(Weight.ofKgs(100)).reps(5).rest(ofMinutes(5)).done()
                        .squat().weight(Weight.ofKgs(110)).reps(5).rest(ofMinutes(5)).done()
                        .squat().weight(Weight.ofKgs(120)).reps(5).rest(ofMinutes(5)).done()
                        .squat()
                        .dropSet()
                        .drop().weight(Weight.ofKgs(125)).reps(2).and()
                        .drop().weight(Weight.ofKgs(115)).reps(4).and()
                        .drop().weight(Weight.ofKgs(105)).reps(6).and()
                        .done()
                        .deadlift().weight(Weight.ofKgs(140)).reps(5).rest(ofMinutes(5)).done())
                .composeWith(Composers.boxing()
                        .shadow(3, ofMinutes(3), ofMinutes(1))
                        .heavyBag(11, ofMinutes(3), ofMinutes(1)))
                .composeWith(Composers.sprinting()
                        .flat(5, Distance.ofMeters(100), ofMinutes(2))
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
