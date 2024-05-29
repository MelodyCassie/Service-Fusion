package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.Location;
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
    private String experienceInYears;
    private String description;
    private Location location;
    private ServiceCategory serviceCategory;

}
