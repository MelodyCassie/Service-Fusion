package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.repositories.AdminRepository;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.CustomerRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerUpdateProfileRequest;
import com.serviceFusion.Capstone.dtos.responses.CustomerRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.CustomerUpdateResponse;
import com.serviceFusion.Capstone.dtos.responses.LoginResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import static com.serviceFusion.Capstone.utils.Verification.*;
@Service
@AllArgsConstructor

public class CustomerServiceApp implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final AdminRepository adminRepository;

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest request) throws ServiceFusionException {
        alreadyRegisteredCheck(request);
        verifyDetails(request);
        Customer customer = modelMapper.map((request), Customer.class);
        customer.setCreatedAt(LocalDateTime.now());
        customerRepository.save(customer);

        return response(customer);
    }

    private static CustomerRegistrationResponse response(Customer customer) {
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setId(customer.getId());
        response.setMessage("Registered Successfully");
        return response;
    }

    private void alreadyRegisteredCheck(CustomerRegistrationRequest request) throws ServiceFusionException {
        boolean isRegistered  = customerRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new ServiceFusionException("Registration details already taken");
    }

    private static void verifyDetails(CustomerRegistrationRequest request) throws ServiceFusionException {
        if (request.getFullName().length() < 3) throw new ServiceFusionException("FullName must be at least 3 characters");
        if (request.getUsername().length() < 3) throw new ServiceFusionException("Username must be at least 3 characters");
        if (request.getAddress().length() < 3) throw new ServiceFusionException("Address must be at least 3 characters");
        if (verifyEmail(request.getEmail())) throw new ServiceFusionException("Invalid email format");
        if (verifyPassword(request.getPassword())) throw new ServiceFusionException("Invalid password format");
        if (verifyPhoneNumber(request.getPhoneNumber())) throw new ServiceFusionException("Invalid phoneNumber format");


    }

    @Override
    public LoginResponse login(CustomerLoginRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findByEmail(request.getEmail());
        if (existingCustomer==null) throw new ServiceFusionException("User not found");
        String password = existingCustomer.getPassword();
        if (!password.equals(request.getPassword())) throw new ServiceFusionException("Invalid password");
        existingCustomer.setLoginStatus(true);
        customerRepository.save(existingCustomer);

        LoginResponse response = new LoginResponse();
        response.setMessage("Login successful");

        return response;
    }

    @Override
    public CustomerUpdateResponse updateCustomer(CustomerUpdateProfileRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (existingCustomer==null) throw new ServiceFusionException("User not found exception");
        if (existingCustomer.isLoginStatus()) throw new ServiceFusionException("Kindly login to update your profile");
        if (!existingCustomer.getPassword().equals(request.getPassword())) throw new ServiceFusionException("Invalid password");
        existingCustomer.setEmail(request.getEmail());
        existingCustomer.setFullName(request.getFullName());
        existingCustomer.setUsername(request.getUsername());
        existingCustomer.setPassword(request.getPassword());
        existingCustomer.setPhoneNumber(request.getPhoneNumber());
        existingCustomer.setAddress(request.getAddress());
        existingCustomer.setCreatedAt(LocalDateTime.now());

        customerRepository.save(existingCustomer);

        CustomerUpdateResponse response = new CustomerUpdateResponse();
        response.setMessage("Updated Successfully");
        response.setCustomerId(existingCustomer.getId());
        return response;



    }
}

