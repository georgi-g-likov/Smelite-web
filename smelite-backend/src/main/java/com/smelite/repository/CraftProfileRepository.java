package com.smelite.repository;

import com.smelite.entity.CraftProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CraftProfileRepository extends JpaRepository<CraftProfile, Long> {
}