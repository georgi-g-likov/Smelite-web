package com.smelite.controller;

import com.smelite.entity.CraftProfile;
import com.smelite.entity.Master;
import com.smelite.repository.CraftProfileRepository;
import com.smelite.repository.MasterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/crafts")
@RequiredArgsConstructor
public class CraftProfileController {

    private final CraftProfileRepository craftProfileRepository;
    private final MasterRepository masterRepository;

    @PostMapping
    @PreAuthorize("hasAuthority('MASTER')")
    @Transactional
    public ResponseEntity<CraftProfile> createCraft(@RequestBody CraftProfile profile, Principal principal) {
        String email = principal.getName();

        Master master = masterRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Master not found"));

        profile.setMaster(master);
        CraftProfile saved = craftProfileRepository.save(profile);

        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<CraftProfile>> getAllCrafts(@RequestParam(required = false) String location,
                                                           @RequestParam(required = false) String craftName,
                                                           @RequestParam(required = false) String masterName) {
        List<CraftProfile> result;

        if (location != null) {
            result = craftProfileRepository.findByLocationIgnoreCase(location);
        } else if (craftName != null) {
            result = craftProfileRepository.findByCraftNameContainingIgnoreCase(craftName);
        } else if (masterName != null) {
            result = craftProfileRepository.findByMaster_NameContainingIgnoreCase(masterName);
        } else {
            result = craftProfileRepository.findAll();
        }

        return ResponseEntity.ok(result);
    }
}


