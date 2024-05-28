package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePasswordRequest {
    private String email;
    private String password;
    private String oldPassword;
}
