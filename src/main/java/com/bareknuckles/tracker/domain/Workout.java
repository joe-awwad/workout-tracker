package com.bareknuckles.tracker.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Workout extends BaseEntity {

    private String athlete;

    private String name;

    private Duration duration;

    private OffsetDateTime dateTime;

    @Singular
    private List<WorkoutSection> sections;

    public void addSection(WorkoutSection section) {
        if (this.sections == null) {
            this.sections = new ArrayList<>();
        }
        this.sections.add(section);
    }
}
