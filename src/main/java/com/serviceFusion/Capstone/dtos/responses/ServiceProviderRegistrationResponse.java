package com.serviceFusion.Capstone.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceProviderRegistrationResponse {
    private String fullName;
    private String phonenumber;
    private String email;
    private int experience;
    private String description;

}
