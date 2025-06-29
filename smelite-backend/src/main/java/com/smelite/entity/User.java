package com.smelite.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role_type")
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String city;

    private int age;

    @Enumerated(EnumType.STRING)
    private Role role;

}
