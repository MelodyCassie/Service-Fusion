package com.serviceFusion.Capstone.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceProviderRequest {

    private String fullName;
    private String phonenumber;
    private String email;
    private String password;
    private int experience;
    private String description;


}
