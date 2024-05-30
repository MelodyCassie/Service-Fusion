package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateServiceProviderProfileRequest {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String description;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceCategory;
    private String yearsOfExperience;
}
