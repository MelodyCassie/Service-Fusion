package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ServiceProviderRegistrationRequest {

    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private String yearsOfExperience;
    private String description;
    private ServiceCategory serviceCategory;
    private Location location;
    private LocalDateTime createdAt;


}
