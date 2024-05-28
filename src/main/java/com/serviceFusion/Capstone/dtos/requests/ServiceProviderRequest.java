package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceProviderRequest {

    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private int experience;
    private String description;
    private ServiceCategory serviceCategory;

}