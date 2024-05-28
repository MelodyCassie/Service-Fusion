package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.*;

public interface ServiceProviderService {

    ServiceProviderRegistrationResponse registerServiceProvider(ServiceProviderRegistrationRequest request) throws ServiceFusionException;

    LoginResponse loginServiceProvider(CustomerLoginRequest customerLoginRequest) throws UserNotFoundException, IncorrectPasswordException;

    ServiceProviderResponse updateProfile(ServiceProviderRequest updateDetailsRequest) throws UserNotFoundException;

    FIndServiceProviderByLocationResponse findByLocation(FindServiceProviderByLocationRequest request) throws ServiceFusionException;

    FindServiceProviderByCategoryResponse findByServiceCategory(FindServiceProviderByCategoryRequest request) throws ServiceFusionException;
}
