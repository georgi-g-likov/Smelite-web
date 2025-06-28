package com.smelite.repository;

import com.smelite.entity.Apprentice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenticeRepository extends JpaRepository<Apprentice, Long> {
    Apprentice findByEmail(String email);
}
