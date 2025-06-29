package com.smelite.repository;

import com.smelite.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master, Long> {
    Master findByEmail(String email);
}
