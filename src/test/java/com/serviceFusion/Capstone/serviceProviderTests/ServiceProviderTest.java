//package com.serviceFusion.Capstone.serviceProviderTests;
//import com.serviceFusion.Capstone.data.models.ServiceCategory;
//
//import com.serviceFusion.Capstone.dtos.requests.CustomerLoginRequest;
//import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRequest;
//import com.serviceFusion.Capstone.dtos.responses.ServiceProviderResponse;
//import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
//import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
//import com.serviceFusion.Capstone.exceptions.UserNotFoundException;
//import com.serviceFusion.Capstone.services.ServiceProviderService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class ServiceProviderTest {
//    @Autowired
//    private ServiceProviderService serviceProviderService;
//
//    private ServiceProviderRequest request;
//    private ServiceProviderRequest request1;
//    private ServiceProviderRequest request2;
//    private CustomerLoginRequest customerLoginRequest;
//
//    private ServiceProviderRequest updateDetailsRequest;
//
//
//    @BeforeEach
//    void setup() {
//        request = new ServiceProviderRequest();
//        request.setFullName("edo peter");
//        request.setEmail("example@gmail.com");
//        request.setPhoneNumber("090122228993");
//        request.setPassword("password");
//        request.setExperience(2);
//        request.setServiceCategory(ServiceCategory.CLEANERS);
//        request.setDescription("Am joe a professional barber");
//
//        request1 = new ServiceProviderRequest();
//        request1.setFullName("edo peter");
//        request1.setEmail("example@gmail.com");
//        request1.setPhoneNumber("090122228993");
//        request1.setPassword("password");
//        request1.setExperience(2);
//        request.setServiceCategory(ServiceCategory.BARBERS);
//        request1.setDescription("Am joe a professional barber");
//
//        request2 = new ServiceProviderRequest();
//        request2.setFullName("edo peter");
//        request2.setEmail("example@gmail.com");
//        request2.setPhoneNumber("090122228993");
//        request2.setPassword("password");
//        request.setServiceCategory(ServiceCategory.CLEANERS);
//        request2.setExperience(2);
//        request2.setDescription("Am joe a professional barber");
//
//        customerLoginRequest = new CustomerLoginRequest();
//
//        updateDetailsRequest = new ServiceProviderRequest();
//        updateDetailsRequest.setFullName("chuks chichi");
//        updateDetailsRequest.setPhoneNumber("090122228993");
//        updateDetailsRequest.setEmail("example@gmail.com");
//        updateDetailsRequest.setPassword("password");
//        updateDetailsRequest.setServiceCategory(ServiceCategory.CLEANERS);
//        updateDetailsRequest.setExperience(2);
//        updateDetailsRequest.setDescription("Am joe a professional barber");
//
//    }
//
//    @Test
//    @DisplayName("Test that service provider can register")
//    void registerSkillProvider() {
//        assertDoesNotThrow(() -> serviceProviderService.registerServiceProvider(request));
//    }
//
//
//    @Test
//    @DisplayName("Test that service provider cannot  register with same email")
//    void registerSkillProviderWithEmail() {
//        assertThrows(EmailAlreadyExistsException.class, () -> {
//            serviceProviderService.registerServiceProvider(request1);
//        });
//    }
//
//    @Test
//    @DisplayName("Test that service provider cannot  register with wrong email format")
//    void registerWithout_WrongEmailFormat() {
//
//        assertThrows(InvalidEmailFormatException.class, () -> {
//            serviceProviderService.registerServiceProvider(request2);
//        });
//    }
//
//    @Test
//    @DisplayName("Test that service provider can login")
//    void loginServiceProvider() {
//        customerLoginRequest.setEmail("example@gmail.com");
//        customerLoginRequest.setPassword("password");
//
//        assertDoesNotThrow(() -> {
//            serviceProviderService.loginServiceProvider(customerLoginRequest);
//        });
//    }
//
//    @Test
//    @DisplayName("Test that service provider can update profile")
//    void updateProfile() throws UserNotFoundException {
//        ServiceProviderResponse response = serviceProviderService.updateProfile(updateDetailsRequest);
//       assertEquals("chuks chichi",response.getFullName());
//    }
//
//}