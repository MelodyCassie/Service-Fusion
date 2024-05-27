package com.serviceFusion.Capstone.dtos.requests;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationRequest {
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private LocalDateTime createdAt;
}
