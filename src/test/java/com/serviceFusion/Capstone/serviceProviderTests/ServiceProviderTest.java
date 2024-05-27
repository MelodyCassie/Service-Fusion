package com.serviceFusion.Capstone.serviceProviderTests;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import com.serviceFusion.Capstone.services.ServiceProviderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ServiceProviderTest {
   @Autowired
    private ServiceProviderService serviceProviderService;

    private ServiceProviderRegistrationRequest request;
    private ServiceProviderRegistrationRequest request1;
    private ServiceProviderRegistrationRequest request2;
    private ServiceProviderLoginRequest serviceProviderLoginRequest;


   @BeforeEach
   void setup(){
      request = new ServiceProviderRegistrationRequest();
       request.setFullName("Favour Mbata");
       request.setEmail("favour@gmail.com");
       request.setPhoneNumber("09134547890");
       request.setPassword("favour");
       request.setCategory(ServiceCategory.HAIRSTYLISTS);
       request.setExperience(2);
       request.setDescription("I'm a professional fashion stylist who specialize in both male and female wear");
       request.setCreatedAt(LocalDateTime.now());

       request1 = new ServiceProviderRegistrationRequest();
       request1.setFullName("edo peter");
       request1.setEmail("example@gmail.com");
       request1.setPhoneNumber("090122228993");
       request1.setPassword("password");
       request1.setExperience(2);
       request1.setDescription("Am joe a professional barber");

       request2 = new ServiceProviderRegistrationRequest();
       request2.setFullName("edo peter");
       request2.setEmail("example@gmail.com");
       request2.setPhoneNumber("090122228993");
       request2.setPassword("password");
       request2.setExperience(2);
       request2.setDescription("Am joe a professional barber");

       serviceProviderLoginRequest = new ServiceProviderLoginRequest();


   }

   @Test
    @DisplayName("Test that service provider can register")
    void registerSkillProvider(){
      assertDoesNotThrow(()-> serviceProviderService.registerServiceProvider(request));
   }


  @Test
  @DisplayName("Test that service provider cannot  register with same email")
    void registerSkillProviderWithEmail(){
      assertThrows(EmailAlreadyExistsException.class, () -> {
          serviceProviderService.registerServiceProvider(request1);
      });
  }

 @Test
 @DisplayName("Test that service provider cannot  register with wrong email format")
    void registerWithout_WrongEmailFormat(){

     assertThrows(InvalidEmailFormatException.class,()->{
         serviceProviderService.registerServiceProvider(request2);
     });
 }
    @Test
    @DisplayName("Test that service provider can login")

    void loginServiceProvider(){
        serviceProviderLoginRequest.setEmail("example@gmail.com");
        serviceProviderLoginRequest.setPassword("password");

        assertDoesNotThrow( ()->{
           serviceProviderService.loginServiceProvider(serviceProviderLoginRequest);
        });
    }

}
