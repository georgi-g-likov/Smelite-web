package com.smelite.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("APPRENTICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Apprentice extends User {

    private String phone;
    private String interests;

    @Column(length = 1000)
    private String description;

    private int coursesEnrolled;
    private int coursesCompleted;
    private double progress;
}
