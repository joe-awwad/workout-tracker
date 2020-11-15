package com.bareknuckles.tracker.repositories;

import com.bareknuckles.tracker.domain.Workout;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface WorkoutRepository extends ReactiveMongoRepository<Workout, String> {

    Flux<Workout> findAllByAthlete(String athlete);

    Flux<Workout> findAllByAthleteAndDateTimeBetween(String athlete, LocalDateTime start, LocalDateTime end);
}
