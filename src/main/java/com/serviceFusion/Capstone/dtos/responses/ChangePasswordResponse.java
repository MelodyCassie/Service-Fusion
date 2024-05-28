package com.serviceFusion.Capstone.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePasswordResponse {
    private String status;
    private String email;

}
