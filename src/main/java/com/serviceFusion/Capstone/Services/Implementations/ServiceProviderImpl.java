package com.serviceFusion.Capstone.Services.Implementations;

import com.serviceFusion.Capstone.Services.Interfaces.ServiceProviderService;
import com.serviceFusion.Capstone.data.models.Role;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.request.ServiceProviderRequest;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.repository.ServiceProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ServiceProviderImpl  implements ServiceProviderService {
    private final ServiceProviderRepository serviceProviderRepository;

    @Override
    public ServiceProvider registerServiceProvider(ServiceProviderRequest request) {

       validate(request);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setFullName(request.getFullName());
        serviceProvider.setYearsOfExperience(request.getExperience());
        serviceProvider.setPassword(request.getPassword());
        serviceProvider.setEmail(request.getEmail());
        serviceProvider.setPhoneNumber(request.getPhonenumber());
        serviceProvider.setDescription(request.getDescription());
        serviceProvider.setSystemRole(Role.SERVICE_PROVIDER);

        ServiceProvider savedProvider = serviceProviderRepository.save(serviceProvider);

        ServiceProvider response = new ServiceProvider();

        response.setFullName(savedProvider.getFullName());
        response.setDescription(savedProvider.getDescription());
        response.setYearsOfExperience(savedProvider.getYearsOfExperience());
        response.setEmail(savedProvider.getEmail());
        response.setPhoneNumber(savedProvider.getPhoneNumber());

        return response;
    }

    private void validate(ServiceProviderRequest serviceProviderRequest) {

       if (!isValidEmail(serviceProviderRequest.getEmail()))
           throw new InvalidEmailFormatException("invalid email format");
        if (serviceProviderRepository.existsByEmail(serviceProviderRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exist");
        }
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}




