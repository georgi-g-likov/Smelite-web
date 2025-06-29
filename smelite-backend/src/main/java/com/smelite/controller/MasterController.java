package com.smelite.controller;

import com.smelite.entity.Master;
import com.smelite.repository.MasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masters")
@RequiredArgsConstructor
public class MasterController {

    private final MasterRepository masterRepository;

    @GetMapping
    public ResponseEntity<List<Master>> getAllMasters() {
        return ResponseEntity.ok(masterRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Master> getMasterById(@PathVariable Long id) {
        return masterRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Master> createMaster(@RequestBody Master master) {
        return ResponseEntity.ok(masterRepository.save(master));
    }
}
