package com.smelite.service;

import com.smelite.entity.CraftProfile;
import com.smelite.repository.CraftProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CraftProfileService {

    private final CraftProfileRepository craftRepo;

    public CraftProfile createCraftProfile(CraftProfile profile) {
        return craftRepo.save(profile);
    }

    public CraftProfile getById(Long id) {
        return craftRepo.findById(id).orElse(null);
    }
}
