package com.smelite.dto;

import com.smelite.entity.User;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String city;
    private int age;
    private User.Role role;
}
