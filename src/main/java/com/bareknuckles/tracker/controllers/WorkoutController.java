package com.bareknuckles.tracker.controllers;

import com.bareknuckles.tracker.domain.Workout;
import com.bareknuckles.tracker.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/workouts")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    @GetMapping
    public Flux<Workout> getWorkouts() {
        return this.workoutRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<Workout> getWorkout(@PathVariable String id) {
        return this.workoutRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<Workout> createWorkout(@RequestBody Workout workout) {
        return this.workoutRepository.save(workout);
    }

    @PutMapping("{id}")
    public Mono<Workout> upsertWorkout(@PathVariable String id, @RequestBody Workout workout) {
        workout.setId(id);
        return this.workoutRepository.save(workout);
    }

    @PatchMapping("{id}")
    public Mono<Workout> patchWorkout(@PathVariable String id, @RequestBody Workout workout) {
        return this.workoutRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND)))
                .map(entity -> {
                    patchIfNotEquals(entity::setAthlete, workout::getAthlete, entity::getAthlete);
                    patchIfNotEquals(entity::setDuration, workout::getDuration, entity::getDuration);
                    patchIfNotEquals(entity::setDateTime, workout::getDateTime, entity::getDateTime);
                    return entity;
                })
                .flatMap(this.workoutRepository::save);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<Void> deleteWorkout(@PathVariable String id) {
        return this.workoutRepository.deleteById(id);
    }

    private <T> void patchIfNotEquals(Consumer<T> consumer, Supplier<T> supplier, Supplier<T> currentValue) {
        if (!Objects.equals(currentValue.get(), supplier.get())) {
            consumer.accept(supplier.get());
        }
    }
}
