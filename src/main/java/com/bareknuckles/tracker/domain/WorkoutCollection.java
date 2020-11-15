package com.bareknuckles.tracker.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class WorkoutCollection extends BaseEntity {
    private String name;

    private List<String> workouts;

    private Range<LocalDate> period;
}
