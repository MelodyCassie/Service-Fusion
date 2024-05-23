package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AdminRegistrationRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String name;
    private LocalDateTime createdAt;
}
