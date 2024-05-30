package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@AllArgsConstructor
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
    private final ServiceProviderRepository serviceProviderRepository;
    private final ModelMapper modelMapper;
    private final ServiceFusionNotificationService fusionNotificationService;



    @Override
    public ServiceProviderRegistrationResponse registerServiceProvider(ServiceProviderRegistrationRequest request) throws ServiceFusionException {
        checkIfExist(request);


        ServiceProvider serviceProvider = getServiceProvider(request);
//        WelcomeMessageRequest welcomeRequest = new WelcomeMessageRequest();
//            welcomeRequest.setEmail(serviceProvider.getEmail());
//            welcomeRequest.setFullName(serviceProvider.getFullName());
//            fusionNotificationService.welcomeMail(welcomeRequest);

        return  getProviderRegistrationResponse(serviceProvider);

    }

    private static ServiceProviderRegistrationResponse getProviderRegistrationResponse(ServiceProvider serviceProvider) {
        ServiceProviderRegistrationResponse response = new ServiceProviderRegistrationResponse();
        response.setMessage("Successfully registered serviceProvider");
        response.setId(serviceProvider.getId());
        return response;
    }

    private ServiceProvider getServiceProvider(ServiceProviderRegistrationRequest request) {
        ServiceProvider serviceProvider = modelMapper.map(request, ServiceProvider.class);
        serviceProvider.setLocation(request.getLocation());
        serviceProvider.setCreatedAt(LocalDateTime.now());
        serviceProviderRepository.save(serviceProvider);
        return serviceProvider;
    }

    private void checkIfExist(ServiceProviderRegistrationRequest request) throws ServiceFusionException {
        boolean isRegistered = serviceProviderRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new ServiceFusionException("Submitted email already taken");
    }



//    @Override
    public ServiceProviderResponse updateProfile(ServiceProviderRequest updateDetailsRequest) throws UserNotFoundException {
        ServiceProvider foundUser = serviceProviderRepository.findByEmail(updateDetailsRequest.getEmail());
        if (foundUser == null) throw new UserNotFoundException("User not found");
        foundUser.setFullName(updateDetailsRequest.getFullName());
        foundUser.setEmail(updateDetailsRequest.getEmail());
        foundUser.setPassword(updateDetailsRequest.getPassword());
        foundUser.setDescription(updateDetailsRequest.getDescription());
        foundUser.setYearsOfExperience(updateDetailsRequest.getExperienceInYears());
        foundUser.setPassword(updateDetailsRequest.getPassword());
        foundUser.setPhoneNumber(updateDetailsRequest.getPhoneNumber());
        foundUser.setServiceCategory(ServiceCategory.CLEANERS);
        ServiceProvider updatedProfile = serviceProviderRepository.save(foundUser);

        ServiceProviderResponse response = new ServiceProviderResponse();
        response.setId(updatedProfile.getId());
        response.setMessage("update successful");
        response.setFullName(updatedProfile.getFullName());
        return response;
    }

    @Override
    public FIndServiceProviderByLocationResponse findByLocation(FindServiceProviderByLocationRequest request) throws ServiceFusionException {
        ServiceProvider existingServiceProvider = serviceProviderRepository.findByLocation(request.getLocation());
        if (existingServiceProvider==null) throw new ServiceFusionException("No service provider in this category was found");

        List<ServiceProvider> serviceProviders = new ArrayList<>();
        serviceProviders.add(existingServiceProvider);
        serviceProviderRepository.saveAll(serviceProviders);
        FIndServiceProviderByLocationResponse response = new FIndServiceProviderByLocationResponse();
        response.setServiceProviders(serviceProviders);
        response.setMessage("Here is a list of service providers in the " + request.getLocation() + " location");
        return response;

    }

    @Override
    public FindServiceProviderByCategoryResponse findByServiceCategory(FindServiceProviderByCategoryRequest request) throws ServiceFusionException {
        ServiceProvider existingServiceProvider = serviceProviderRepository.findByServiceCategory(request.getCategory());
        if (existingServiceProvider==null) throw new ServiceFusionException("No service provider in this category was found");
        serviceProviderRepository.save(existingServiceProvider);

        List<ServiceProvider> serviceProviders = new ArrayList<>();
        serviceProviders.add(existingServiceProvider);
        FindServiceProviderByCategoryResponse response = new FindServiceProviderByCategoryResponse();
        response.setServiceProviders(serviceProviders);
        response.setMessage("Here is a list of service providers in the " + request.getCategory() + " category.");

        return response;
    }

    @Override
    public List<ServiceProvider> findByServiceProvideByCategory(ServiceCategory category) {
        return serviceProviderRepository.findAllByServiceCategory(category);
    }

    @Override
    public ServiceProviderLoginResponse login(ServiceProviderLoginRequest request) throws UserNotFoundException, IncorrectPasswordException {
        ServiceProvider existingServiceProvider = serviceProviderRepository.findByEmail(request.getEmail());
        if(existingServiceProvider == null)throw new UserNotFoundException("User not found");
        if (!existingServiceProvider .getPassword().equalsIgnoreCase(request.getPassword()))
            throw new IncorrectPasswordException("invalid password");

        existingServiceProvider.setLogin(true);
        serviceProviderRepository.save(existingServiceProvider);
        ServiceProviderLoginResponse response = new ServiceProviderLoginResponse();
        response.setMessage("Login successful");
        return response;
    }

    @Override
    public void logout(ServiceProviderLogoutRequest request) {
        ServiceProvider existingProvider = serviceProviderRepository.findById(request.getProviderId()).get();
        existingProvider.setLogin(false);
        serviceProviderRepository.save(existingProvider);

    }

}
