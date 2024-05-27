package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderLoginResponse;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;

public interface ServiceProviderService {
    ServiceProvider registerServiceProvider(ServiceProviderRegistrationRequest request) throws EmailAlreadyExistsException, InvalidEmailFormatException;

    ServiceProviderLoginResponse loginServiceProvider(ServiceProviderLoginRequest serviceProviderLoginRequest) throws UserNotFoundException, IncorrectPasswordException;

}
