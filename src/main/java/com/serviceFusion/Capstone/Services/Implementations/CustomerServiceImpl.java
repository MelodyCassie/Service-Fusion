package com.serviceFusion.Capstone.Services.Implementations;

import com.serviceFusion.Capstone.Services.CustomerService;
import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.CustomerRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.LoginRequest;
import com.serviceFusion.Capstone.dtos.responses.CustomerRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.LoginResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.utils.Verification;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Verification verification;

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest request) throws ServiceFusionException {
        boolean isRegistered  = customerRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new ServiceFusionException("Registration details already taken");
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setUsername(request.getUsername());
        customer.setPassword(request.getPassword());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAddress(request.getAddress());
        customer.setCreatedAt(request.getCreatedAt());

        customerRepository.save(customer);

        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setId(customer.getId());
        response.setMessage("Registered Successfully");

        return response;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws ServiceFusionException {
        Customer existingCustomer = customerRepository.findByEmail(request.getEmail());
        if (existingCustomer==null) throw new ServiceFusionException("User not found");
        String password = existingCustomer.getPassword();
        if (!password.equals(request.getPassword())) throw new ServiceFusionException("Invalid password");
        existingCustomer.setLoginStatus(true);

        LoginResponse response = new LoginResponse();
        response.setMessage("Login successful");

        return response;
    }
}

