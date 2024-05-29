package com.serviceFusion.Capstone.CustomerTests;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
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

    @Test
    public void searchServiceProviderTest(){
        SearchServiceProviderRequest request = new SearchServiceProviderRequest();
        request.setCategory(ServiceCategory.HAIRSTYLISTS);
        request.setLocation(Location.EJIGBO);
        SearchServiceProviderResponse response = customerService.searchForServiceProvider(request);
        System.out.println(response.getServiceProviders().size());
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatACustomerCanBookASpecificServiceProvider() throws ServiceFusionException {
        CustomerBookingRequest request = new CustomerBookingRequest();
        request.setCustomerId(2L);
        request.setCustomerName("Jack Smith");
        request.setCustomerAddress("312, Sabo Yaba");
        request.setPreferredDate("05/06/2024");

        CustomerBookingResponse response = customerService.bookService(request);
        assertThat(response).isNotNull();
    }

}
