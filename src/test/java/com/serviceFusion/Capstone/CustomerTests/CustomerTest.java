package com.serviceFusion.Capstone.CustomerTests;

import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.CustomerLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.CustomerUpdateProfileRequest;
import com.serviceFusion.Capstone.dtos.responses.CustomerUpdateResponse;
import com.serviceFusion.Capstone.dtos.responses.LoginResponse;
import com.serviceFusion.Capstone.dtos.responses.CustomerRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import com.serviceFusion.Capstone.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



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
        request.setFullName("Jack Smith");
        request.setEmail("JackSmith123@gmail.com");
        request.setUsername("jack");
        request.setPassword("13071994Temmylove.");
        request.setPhoneNumber("08073736567");
        request.setAddress("Water St");

        CustomerRegistrationResponse response = customerService.register(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatMultipleCustomersCanRegister() throws ServiceFusionException {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setFullName("Melody Cassie2");
        request.setEmail("melodycassie@gmail.com");
        request.setUsername("Melody Cassieee");
        request.setPassword("13071994Temmylove.");
        request.setPhoneNumber("08134546780");
        request.setAddress("London");

        CustomerRegistrationResponse response = customerService.register(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatWhenCustomerAttemptsToRegisterWithAlreadyTakenDetailsExceptionIsThrown(){
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setFullName("Melody Cassie2");
        request.setEmail("melodycassie@gmail.com");
        request.setUsername("Melody Cassieee");
        request.setPassword("melody1234");
        request.setPhoneNumber("08134546780");
        request.setAddress("London");

        assertThrows(ServiceFusionException.class,()->customerService.register(request));
    }

    @Test
    public void testThatCustomerCanLogin() throws ServiceFusionException {
        CustomerLoginRequest request = new CustomerLoginRequest();
        request.setEmail("JackSmith123@gmail.com");

        request.setPassword("13071994Temmylove.");
        LoginResponse response = customerService.login(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatCustomerCanUpdateProfile() throws ServiceFusionException {
       CustomerUpdateProfileRequest request = new  CustomerUpdateProfileRequest();
       request.setCustomerId(1L);
        request.setFullName("Melody Oluchi");
        request.setEmail("melodycassie2@gmail.com");
        request.setUsername("Melody Cassieee");
        request.setPassword("melody1234@");
        request.setPhoneNumber("08134546780");
        request.setAddress("Germany");
        CustomerUpdateResponse response = customerService.updateCustomer(request);
        assertThat(response).isNotNull();

    }

}
