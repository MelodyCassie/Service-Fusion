package com.serviceFusion.Capstone.services.Interfaces;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.request.LoginRequest;
import com.serviceFusion.Capstone.dtos.request.ServiceProviderRequest;
import com.serviceFusion.Capstone.dtos.response.LoginResponse;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;

public interface ServiceProviderService {
    ServiceProvider registerServiceProvider(ServiceProviderRequest request) throws EmailAlreadyExistsException, InvalidEmailFormatException;

    LoginResponse loginServiceProvider(LoginRequest loginRequest) throws UserNotFoundException, IncorrectPasswordException;

}
