package com.serviceFusion.Capstone.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceProviderResponse {
    private String fullName;
    private String phonenumber;
    private String email;
    private int experience;
    private String description;

}
