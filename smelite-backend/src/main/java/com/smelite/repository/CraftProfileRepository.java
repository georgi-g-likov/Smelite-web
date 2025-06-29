package com.smelite.repository;

import com.smelite.entity.CraftProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CraftProfileRepository extends JpaRepository<CraftProfile, Long> {

    List<CraftProfile> findByMasterId(Long masterId);

    List<CraftProfile> findByCraftNameContainingIgnoreCase(String keyword);

    List<CraftProfile> findByLocationIgnoreCase(String location);

    List<CraftProfile> findByMaster_NameContainingIgnoreCase(String name);
    // Може да добавим и други методи според нуждите
}
