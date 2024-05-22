package com.serviceFusion.Capstone.dtos.request;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ServiceProviderRequest {

    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private int experience;
    private String description;
    private ServiceCategory category;
    private LocalDateTime createdAt;


}
