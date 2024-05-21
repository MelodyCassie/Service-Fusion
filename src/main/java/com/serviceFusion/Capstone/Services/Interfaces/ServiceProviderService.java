package com.serviceFusion.Capstone.Services.Interfaces;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.request.LoginRequest;
import com.serviceFusion.Capstone.dtos.request.ServiceProviderRequest;
import com.serviceFusion.Capstone.dtos.response.LoginResponse;

public interface ServiceProviderService {
    ServiceProvider registerServiceProvider(ServiceProviderRequest request);

    LoginResponse loginServiceProvider(LoginRequest loginRequest);

}
