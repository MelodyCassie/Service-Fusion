package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationMessageRequest {
    private String email;
    private String fullName;
}
