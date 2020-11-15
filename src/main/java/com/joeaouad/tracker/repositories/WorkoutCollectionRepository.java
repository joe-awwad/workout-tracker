package com.joeaouad.tracker.repositories;

import com.joeaouad.tracker.domain.WorkoutCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface WorkoutCollectionRepository extends ReactiveMongoRepository<WorkoutCollection, String> {
    Mono<WorkoutCollection> findByName(String s);
}
