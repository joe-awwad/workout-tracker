package com.bareknuckles.tracker.controllers;

import com.bareknuckles.tracker.domain.Workout;
import com.bareknuckles.tracker.repositories.WorkoutRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@WebFluxTest
class WorkoutControllerTest {

    public static final String WORKOUTS_API = "/api/v1/workouts";

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private WorkoutRepository workoutRepository;

    @Test
    void shouldGetWorkouts() {
        given(this.workoutRepository.findAll()).willReturn(Flux.just(new Workout(), new Workout()));

        this.webTestClient.get()
                .uri(WORKOUTS_API)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Workout.class);
    }

    @Test
    void shouldGetWorkoutById() {
        given(this.workoutRepository.findById(anyString())).willReturn(Mono.just(new Workout()));

        this.webTestClient.get()
                .uri(WORKOUTS_API + "/id")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Workout.class);
    }

    @Test
    void shouldCreateWorkout() {
        given(this.workoutRepository.save(any())).willReturn(Mono.just(new Workout()));

        this.webTestClient.post()
                .uri(WORKOUTS_API)
                .bodyValue(new Workout())
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(Workout.class);
    }

    @Test
    void shouldUpsertWorkout() {
        given(this.workoutRepository.save(any())).willReturn(Mono.just(new Workout()));

        this.webTestClient.put()
                .uri(WORKOUTS_API + "/id")
                .bodyValue(new Workout())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Workout.class);
    }

    @Test
    void shouldPatchWorkout() {
        given(this.workoutRepository.findById(anyString())).willReturn(Mono.just(new Workout()));
        given(this.workoutRepository.save(any())).willReturn(Mono.just(new Workout()));

        this.webTestClient.patch()
                .uri(WORKOUTS_API + "/id")
                .bodyValue(new Workout())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Workout.class);

        verify(this.workoutRepository, times(1)).save(any());
    }

    @Test
    void shouldNotPatchGivenNonExistentWorkout() {
        given(this.workoutRepository.findById(anyString())).willReturn(Mono.empty());

        this.webTestClient.patch()
                .uri(WORKOUTS_API + "/id")
                .bodyValue(new Workout())
                .exchange()
                .expectStatus()
                .isNotFound();

        verify(this.workoutRepository, never()).save(any());
    }

    @Test
    void shouldDeleteWorkout() {
        given(this.workoutRepository.deleteById(anyString())).willReturn(Mono.empty());

        this.webTestClient.delete()
                .uri(WORKOUTS_API + "/id")
                .exchange()
                .expectStatus()
                .isNoContent();

        verify(this.workoutRepository).deleteById(anyString());
    }
}