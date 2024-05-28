<<<<<<< HEAD:src/main/java/com/serviceFusion/Capstone/Services/ServiceProviderImpl.java
package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderLoginResponse;
=======
package com.serviceFusion.Capstone.Services.Implementations;

import com.serviceFusion.Capstone.Services.Interfaces.ServiceProviderService;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.dtos.requests.ChangePasswordRequest;
import com.serviceFusion.Capstone.dtos.responses.ChangePasswordResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderResponse;
>>>>>>> origin/submain:src/main/java/com/serviceFusion/Capstone/Services/Implementations/ServiceProviderImpl.java
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
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
<<<<<<< HEAD:src/main/java/com/serviceFusion/Capstone/Services/ServiceProviderImpl.java
    public ServiceProvider registerServiceProvider(ServiceProviderRegistrationRequest request) throws EmailAlreadyExistsException, InvalidEmailFormatException {
=======
    public ServiceProviderResponse registerServiceProvider(ServiceProviderRequest request) throws EmailAlreadyExistsException, InvalidEmailFormatException {
>>>>>>> origin/submain:src/main/java/com/serviceFusion/Capstone/Services/Implementations/ServiceProviderImpl.java
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
<<<<<<< HEAD:src/main/java/com/serviceFusion/Capstone/Services/ServiceProviderImpl.java
        serviceProvider.setServiceCategory(request.getCategory());
        serviceProvider.setDescription(request.getDescription());
        serviceProvider.setCreatedAt(request.getCreatedAt());

        ServiceProvider savedProvider = serviceProviderRepository.save(serviceProvider);
        ServiceProvider response = new ServiceProvider();

        response.setFullName(savedProvider.getFullName());
        response.setDescription(savedProvider.getDescription());
        response.setYearsOfExperience(savedProvider.getYearsOfExperience());
        response.setEmail(savedProvider.getEmail());
        response.setPhoneNumber(savedProvider.getPhoneNumber());

        return response;
=======
        serviceProvider.setDescription(request.getDescription());
        serviceProvider.setCreatedAt(LocalDateTime.now());
        serviceProvider.setServiceCategory(ServiceCategory.BARBERS);
        return serviceProvider;
>>>>>>> origin/submain:src/main/java/com/serviceFusion/Capstone/Services/Implementations/ServiceProviderImpl.java
    }

    @Override
    public ServiceProviderLoginResponse loginServiceProvider(ServiceProviderLoginRequest serviceProviderLoginRequest) throws UserNotFoundException, IncorrectPasswordException {
     ServiceProvider foundUser = serviceProviderRepository.findByEmail(serviceProviderLoginRequest.getEmail());
      if(foundUser == null)throw new UserNotFoundException("User not found");
      if (!foundUser .getPassword().equalsIgnoreCase(serviceProviderLoginRequest.getPassword()))
          throw new IncorrectPasswordException("invalid password");

        foundUser.setLogin(true);
        serviceProviderRepository.save(foundUser);

        ServiceProviderLoginResponse response = new ServiceProviderLoginResponse();
        response.setMessage("login successful");
        return response;
    }

<<<<<<< HEAD:src/main/java/com/serviceFusion/Capstone/Services/ServiceProviderImpl.java
    private void validate(ServiceProviderRegistrationRequest serviceProviderRegistrationRequest) throws InvalidEmailFormatException, EmailAlreadyExistsException {
=======
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

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePassword) throws UserNotFoundException, IncorrectPasswordException {
     ServiceProvider foundUser = serviceProviderRepository.findByEmail(changePassword.getEmail());
      if (foundUser == null)throw new UserNotFoundException("service provider not found");
      if (!foundUser.getPassword().equalsIgnoreCase(changePassword.getOldPassword()))
         throw new IncorrectPasswordException("invalid password");
        foundUser.setPassword(changePassword.getPassword());
       serviceProviderRepository.save(foundUser);

       ChangePasswordResponse response = new ChangePasswordResponse();
       response.setStatus("password changed successfully");
//       response.setPassword(changePassword.getPassword());
        return response;
    }

    private void validate(ServiceProviderRequest serviceProviderRequest) throws InvalidEmailFormatException, EmailAlreadyExistsException {
>>>>>>> origin/submain:src/main/java/com/serviceFusion/Capstone/Services/Implementations/ServiceProviderImpl.java

       if (!isValidEmail(serviceProviderRegistrationRequest.getEmail()))
           throw new InvalidEmailFormatException("invalid email format");
        if (serviceProviderRepository.existsByEmail(serviceProviderRegistrationRequest.getEmail())) {
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




