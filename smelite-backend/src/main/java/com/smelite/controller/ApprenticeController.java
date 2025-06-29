package com.smelite.controller;

import com.smelite.entity.Apprentice;
import com.smelite.repository.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprentices")
@RequiredArgsConstructor
public class ApprenticeController {

    private final ApprenticeRepository apprenticeRepository;

    @GetMapping
    public ResponseEntity<List<Apprentice>> getAllApprentices() {
        return ResponseEntity.ok(apprenticeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprentice> getApprenticeById(@PathVariable Long id) {
        return apprenticeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Apprentice> createApprentice(@RequestBody Apprentice apprentice) {
        return ResponseEntity.ok(apprenticeRepository.save(apprentice));
    }
}
