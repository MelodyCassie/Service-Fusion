package com.serviceFusion.Capstone;

import com.serviceFusion.Capstone.Services.Interfaces.ServiceProviderService;
import com.serviceFusion.Capstone.dtos.request.LoginRequest;
import com.serviceFusion.Capstone.dtos.request.ServiceProviderRequest;
import com.serviceFusion.Capstone.exceptions.EmailAlreadyExistsException;
import com.serviceFusion.Capstone.exceptions.InvalidEmailFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ServiceProviderTest {
   @Autowired
    private  ServiceProviderService serviceProviderService;

    private ServiceProviderRequest request;
    private ServiceProviderRequest request1;
    private ServiceProviderRequest request2;
    private LoginRequest loginRequest;


   @BeforeEach
   void setup(){
      request = new ServiceProviderRequest();
      request.setFullName("edo peter");
      request.setEmail("example@gmail.com");
      request.setPhonenumber("090122228993");
      request.setPassword("password");
      request.setExperience(2);
      request.setDescription("Am joe a professional barber");

       request1 = new ServiceProviderRequest();
       request1.setFullName("edo peter");
       request1.setEmail("example@gmail.com");
       request1.setPhonenumber("090122228993");
       request1.setPassword("password");
       request1.setExperience(2);
       request1.setDescription("Am joe a professional barber");

       request2 = new ServiceProviderRequest();
       request2.setFullName("edo peter");
       request2.setEmail("example@gmail.com");
       request2.setPhonenumber("090122228993");
       request2.setPassword("password");
       request2.setExperience(2);
       request2.setDescription("Am joe a professional barber");

       loginRequest = new LoginRequest();


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
        loginRequest.setEmail("example@gmail.com");
        loginRequest.setPassword("password");

        assertDoesNotThrow( ()->{
           serviceProviderService.loginServiceProvider(loginRequest);
        });
    }
}
