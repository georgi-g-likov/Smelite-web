package com.smelite.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CraftProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String craftName; // име на занаята

    @Column(length = 1000)
    private String description; // описание на занаята

    private int experienceYears; // години опит

    private String location; // местоположение (град, село и т.н.)

    private String lessonType; // индивидуално / групово / смесено

    private String lessonPriceRange; // ценови диапазон (напр. 30-120 лв)

    private String images; // CSV от image URLs (или filenames)

    private boolean wantsWorkshopSupport; // ако няма ателие - иска ли помощ от платформата

    @OneToOne
    @JoinColumn(name = "master_id")
    private Master master; // връзка към майстора
}

