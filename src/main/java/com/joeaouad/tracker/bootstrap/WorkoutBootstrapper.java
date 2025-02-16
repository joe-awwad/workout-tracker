package com.joeaouad.tracker.bootstrap;

import com.joeaouad.tracker.domain.Range;
import com.joeaouad.tracker.domain.Workout;
import com.joeaouad.tracker.domain.WorkoutCollection;
import com.joeaouad.tracker.experimental.WorkoutBuilder;
import com.joeaouad.tracker.repositories.WorkoutCollectionRepository;
import com.joeaouad.tracker.repositories.WorkoutRepository;
import com.joeaouad.tracker.domain.Weight;
import com.joeaouad.tracker.domain.exercises.WeightLiftingEquipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static com.joeaouad.tracker.experimental.Composers.*;
import static java.time.Duration.ofMinutes;

@Slf4j
@Component
@RequiredArgsConstructor
public class WorkoutBootstrapper implements ApplicationRunner {

    private final WorkoutRepository workouts;

    private final WorkoutCollectionRepository collections;

    @Override
    public void run(ApplicationArguments args) {
        this.workouts.saveAll(Arrays.asList(
                WorkoutBuilder.get()
                        .name("Strength & Conditioning Workout")
                        .duration(ofMinutes(90))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 11, 19, 0))
                        .composeWith(strengthAndConditioning()
                                .squat().weight(Weight.ofKgs(85)).reps(5).rest(ofMinutes(5))
                                .done()
                                .benchPress().equipment(WeightLiftingEquipment.DUMBBELL).weight(Weight.ofKgs(25)).reps(8).rest(ofMinutes(3))
                                .done()
                                .benchPress().equipment(WeightLiftingEquipment.DUMBBELL).weight(Weight.ofKgs(30)).reps(6).rest(ofMinutes(3))
                                .done()
                                .benchPress().equipment(WeightLiftingEquipment.DUMBBELL).weight(Weight.ofKgs(30)).reps(6).rest(ofMinutes(3))
                                .done()
                                .pullup().reps(6).done(5))
                        .composeWith(boxing()
                                .heavyBag(10, ofMinutes(3), ofMinutes(1)))
                        .build(),

                WorkoutBuilder.get()
                        .name("Sprinting Workout")
                        .duration(ofMinutes(30))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 12, 10, 0))
                        .composeWith(sprinting()
                                .uphill(10, Duration.ofSeconds(10), ofMinutes(2)))
                        .build(),

                WorkoutBuilder.get()
                        .name("Strength & Conditioning Workout")
                        .duration(ofMinutes(90))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 12, 19, 0))
                        .composeWith(boxing().shadow(3, ofMinutes(3), ofMinutes(1)))
                        .composeWith(strengthAndConditioning()
                                .deadlift().reps(5).weight(Weight.ofKgs(90)).rest(ofMinutes(90)).done()
                                .deadlift().reps(5).weight(Weight.ofKgs(90)).rest(ofMinutes(95)).done()
                                .deadlift().reps(5).weight(Weight.ofKgs(90)).rest(ofMinutes(100)).done()
                                .deadlift().reps(5).weight(Weight.ofKgs(90)).rest(ofMinutes(100)).done()
                                .deadlift().reps(5).weight(Weight.ofKgs(90)).rest(ofMinutes(105)).done()
                                .militaryPress().equipment(WeightLiftingEquipment.DUMBBELL).weight(Weight.ofKgs(20)).reps(5).rest(ofMinutes(3)).done(5)
                                .chinup().reps(6).done(5)
                        ).build(),

                WorkoutBuilder.get()
                        .name("Boxing Workout")
                        .duration(ofMinutes(90))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 13, 19, 0))
                        .composeWith(boxing().boxing(20, ofMinutes(3), ofMinutes(1)))
                        .build(),

                WorkoutBuilder.get()
                        .name("Strength & Conditioning Workout")
                        .duration(ofMinutes(90))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 14, 19, 0))
                        .composeWith(boxing().shadow(3, ofMinutes(3), ofMinutes(1)))
                        .composeWith(strengthAndConditioning()
                                .squat().weight(Weight.ofKgs(80)).reps(5).rest(ofMinutes(5)).done(5)
                                .squat().weight(Weight.ofKgs(85)).reps(5).rest(ofMinutes(5)).done(5)
                                .squat().weight(Weight.ofKgs(90)).reps(5).rest(ofMinutes(5)).done(5)
                                .benchPress().weight(Weight.ofKgs(25)).reps(5).rest(ofMinutes(5)).done(3)
                                .chinup().reps(8).done(2)
                                .chinup().reps(6).done()
                                .chinup().reps(5).done()
                                .legExtension().weight(Weight.ofKgs(72.5)).reps(10).rest(ofMinutes(5)).done(5))
                        .build(),

                Workout.builder().name("Boxing PT")
                        .duration(ofMinutes(90))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 15, 11, 0))
                        .build(),

                WorkoutBuilder.get()
                        .name("Sprinting & Boxing Workout")
                        .duration(ofMinutes(30))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 16, 10, 0))
                        .composeWith(sprinting().uphill(10, Duration.ofSeconds(10), ofMinutes(2)))
                        .composeWith(boxing().shadow(10, ofMinutes(3), ofMinutes(1)))
                        .build(),

                WorkoutBuilder.get()
                        .name("Strength & Conditioning Workout")
                        .duration(ofMinutes(40))
                        .dateTime(LocalDateTime.of(2019, Month.NOVEMBER, 16, 19, 0))
                        .composeWith(strengthAndConditioning()
                                .deadlift().weight(Weight.ofKgs(110)).reps(5).rest(ofMinutes(5)).done()
                                .benchPress().weight(Weight.ofKgs(65)).reps(5).rest(ofMinutes(5)).done(3)
                                .chinup().reps(8).done(2)
                                .chinup().reps(7).done()
                                .chinup().reps(6).done()
                        ).build()


        )).map(Workout::getId).collectList()
                .map(workoutIds -> WorkoutCollection.builder()
                        .name("2019/2020 - Week 1")
                        .workouts(workoutIds)
                        .period(new Range<>(
                                LocalDate.of(2019, Month.NOVEMBER, 11),
                                LocalDate.of(2019, Month.NOVEMBER, 16)))
                        .build())
                .flatMap(this.collections::save)
                .subscribe(
                        collection -> log.debug(String.format("Workout Collection Saved From %s To %s",
                                collection.getPeriod().getStart(), collection.getPeriod().getEnd()))
                );
    }
}
