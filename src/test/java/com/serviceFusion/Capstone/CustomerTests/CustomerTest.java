package com.serviceFusion.Capstone.CustomerTests;

import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.CustomerRegistrationRequest;
import com.serviceFusion.Capstone.dtos.responses.CustomerRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testThatACustomerCanRegister() throws ServiceFusionException {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setName("Jack Smith");
        request.setEmail("JackSmith123@gmail.com");
        request.setUsername("jack");
        request.setPassword("password");
        request.setPhoneNumber("873736567");
        request.setAddress("Water St");
        request.setCreatedAt(LocalDateTime.now());

        CustomerRegistrationResponse response = customerService.register(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatMultipleCustomersCanRegister() throws ServiceFusionException {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setName("Melody Cassie");
        request.setEmail("melodycassie123@gmail.com");
        request.setUsername("Melody Cassie");
        request.setPassword("melody123");
        request.setPhoneNumber("08134546780");
        request.setAddress("London");
        request.setCreatedAt(LocalDateTime.now());

        CustomerRegistrationResponse response = customerService.register(request);

        assertThat(response).isNotNull();
        assertEquals(2,customerRepository.count());
    }

    @Test
    public void testThatWhenCustomerAttemptsToRegisterWithAlreadyTakenDetailsExceptionIsThrown(){
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setName("Melody Cassie");
        request.setEmail("melodycassie123@gmail.com");
        request.setUsername("Melody Cassie");
        request.setPassword("melody123");
        request.setPhoneNumber("08134546780");
        request.setAddress("London");
        request.setCreatedAt(LocalDateTime.now());

        assertThrows(ServiceFusionException.class,()->customerService.register(request));
    }




}
