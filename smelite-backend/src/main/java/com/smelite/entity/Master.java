package com.smelite.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@DiscriminatorValue("MASTER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Master extends User {

    @Column(length = 1000)
    private String bio;

    private String location;
    private String workshopAddress;
    private String lessonTypes;       // напр. "Групови и индивидуални"
    private String lessonPriceRange;  // напр. "50-80 лв."
    private int experienceYears;
    private double rating;
    private int studentCount;
    private int courseCount;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CraftProfile> crafts;
    @Column(length = 2000)
    private String portfolioImages;   // CSV или JSON списък от изображения
}
