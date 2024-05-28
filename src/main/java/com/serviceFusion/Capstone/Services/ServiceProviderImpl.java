package com.serviceFusion.Capstone.services;


import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import com.serviceFusion.Capstone.dtos.requests.CustomerLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRequest;
import com.serviceFusion.Capstone.dtos.responses.LoginResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderResponse;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
public class ServiceProviderImpl  implements ServiceProviderService {
    private final ServiceProviderRepository serviceProviderRepository;


    @Override
    public ServiceProviderResponse registerServiceProvider(ServiceProviderRequest request) throws EmailAlreadyExistsException, InvalidEmailFormatException {
        validate(request);
        ServiceProvider serviceProvider = mapAndvalidateServiceProvider(request);
        ServiceProvider savedProvider = serviceProviderRepository.save(serviceProvider);

        ServiceProviderResponse response = new ServiceProviderResponse();
        response.setMessage("Registration sucessful");
        response.setId(savedProvider.getId());
        return response;
    }

    private static ServiceProvider mapAndvalidateServiceProvider(ServiceProviderRequest request) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setFullName(request.getFullName());
        serviceProvider.setYearsOfExperience(request.getExperience());
        serviceProvider.setPassword(request.getPassword());
        serviceProvider.setEmail(request.getEmail());
        serviceProvider.setPhoneNumber(request.getPhoneNumber());
        serviceProvider.setDescription(request.getDescription());
        serviceProvider.setCreatedAt(LocalDateTime.now());
        serviceProvider.setServiceCategory(request.getServiceCategory());
        return serviceProvider;
    }

    @Override
    public LoginResponse loginServiceProvider(CustomerLoginRequest customerLoginRequest) throws UserNotFoundException, IncorrectPasswordException {
        ServiceProvider foundUser = serviceProviderRepository.findByEmail(customerLoginRequest.getEmail());
        if(foundUser == null)throw new UserNotFoundException("User not found");
        if (!foundUser .getPassword().equalsIgnoreCase(customerLoginRequest.getPassword()))
            throw new IncorrectPasswordException("invalid password");

        foundUser.setLogin(true);
        serviceProviderRepository.save(foundUser);

        LoginResponse response = new LoginResponse();
        response.setMessage("login sucessful");
        return response;
    }

    @Override
    public ServiceProviderResponse updateProfile(ServiceProviderRequest updateDetailsRequest) throws UserNotFoundException {
        ServiceProvider foundUser = serviceProviderRepository.findByEmail(updateDetailsRequest.getEmail());
        if (foundUser == null) throw new UserNotFoundException("User not found");
        foundUser.setFullName(updateDetailsRequest.getFullName());
        foundUser.setEmail(updateDetailsRequest.getEmail());
        foundUser.setPassword(updateDetailsRequest.getPassword());
        foundUser.setDescription(updateDetailsRequest.getDescription());
        foundUser.setYearsOfExperience(updateDetailsRequest.getExperience());
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

    private void validate(ServiceProviderRequest serviceProviderRequest) throws InvalidEmailFormatException, EmailAlreadyExistsException {

        if (!isValidEmail(serviceProviderRequest.getEmail()))
            throw new InvalidEmailFormatException("invalid email format");
        if (serviceProviderRepository.existsByEmail(serviceProviderRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exist");
        }
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex =
                "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}




