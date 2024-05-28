package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.CustomerLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRequest;
import com.serviceFusion.Capstone.dtos.responses.LoginResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderResponse;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;

public interface ServiceProviderService {

    ServiceProviderResponse registerServiceProvider(ServiceProviderRequest request) throws EmailAlreadyExistsException, InvalidEmailFormatException;

    LoginResponse loginServiceProvider(CustomerLoginRequest customerLoginRequest) throws UserNotFoundException, IncorrectPasswordException;

    ServiceProviderResponse updateProfile(ServiceProviderRequest updateDetailsRequest) throws UserNotFoundException;

}
