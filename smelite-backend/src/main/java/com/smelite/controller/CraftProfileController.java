package com.smelite.controller;

import com.smelite.entity.CraftProfile;
import com.smelite.service.CraftProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crafts")
@RequiredArgsConstructor
public class CraftProfileController {

    private final CraftProfileService service;

    @PostMapping
    public CraftProfile create(@RequestBody CraftProfile profile) {
        return service.createCraftProfile(profile);
    }

    @GetMapping("/{id}")
    public CraftProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }
}

