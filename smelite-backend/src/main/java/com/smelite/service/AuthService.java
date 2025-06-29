package com.smelite.service;

import com.smelite.dto.RegisterRequest;
import com.smelite.dto.AuthResponse;
import com.smelite.entity.*;
import com.smelite.repository.UserRepository;
import com.smelite.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user;

        if (request.getRole().equals(Role.MASTER)) {
            Master master = Master.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.MASTER)
                    .age(request.getAge())
                    .city(request.getCity())
                    .bio("")
                    .courseCount(0)
                    .experienceYears(0)
                    .lessonPriceRange("")
                    .lessonTypes("")
                    .location("")
                    .portfolioImages("")
                    .rating(0.0f)
                    .studentCount(0)
                    .workshopAddress("")
                    .build();
            user = master;
        } else if (request.getRole().equals(Role.APPRENTICE)) {
            Apprentice apprentice = Apprentice.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.APPRENTICE)
                    .age(request.getAge())
                    .city(request.getCity())
                    // Default values
                    .coursesCompleted(0)
                    .coursesEnrolled(0)
                    .description("")
                    .interests("")
                    .phone("")
                    .progress(0.0f)
                    .build();
            user = apprentice;
        } else {
            throw new IllegalArgumentException("Unknown role: " + request.getRole());
        }

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(com.smelite.dto.AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        String jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
