package com.serviceFusion.Capstone;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.FIndServiceProviderByLocationResponse;
import com.serviceFusion.Capstone.dtos.responses.FindServiceProviderByCategoryResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;
import com.serviceFusion.Capstone.services.ServiceProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class ProviderTest {

    @Autowired
    private ServiceProviderService serviceProviderService;
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Test
    public void testThatServiceProviderCanRegister() throws ServiceFusionException {
        ServiceProviderRegistrationRequest request = new ServiceProviderRegistrationRequest();
        request.setFullName("Boluwatife Agboola");
        request.setCategory(ServiceCategory.HAIRSTYLISTS);
        request.setEmail("lanlehin@gmail.com");
        request.setDescription("Does both male and female hair styling");
        request.setExperienceInYears("2 years");
        request.setPhoneNumber("08068952954");
        request.setLocation(Location.EJIGBO);
        request.setPassword("lanlehinTifeh13@");

        ServiceProviderRegistrationResponse response = serviceProviderService.registerServiceProvider(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatMultipleServiceProvidersCanRegister() throws ServiceFusionException {
        ServiceProviderRegistrationRequest request = new ServiceProviderRegistrationRequest();
        request.setFullName("Adeniyi Daniel");
        request.setCategory(ServiceCategory.BARBERS);
        request.setEmail("adeniyidaniel@gmail.com");
        request.setDescription("Male and Female hair styling");
        request.setExperienceInYears("2 years");
        request.setLocation(Location.ISOLO);
        request.setPassword("Daniel234@");
        request.setPhoneNumber("08168952046");

        ServiceProviderRegistrationResponse response = serviceProviderService.registerServiceProvider(request);
        assertThat(response).isNotNull();
    }
    @Test
    public void testThatServiceProviderCanLogin() throws UserNotFoundException, IncorrectPasswordException {
        ServiceProviderLoginRequest request = new ServiceProviderLoginRequest();
        request.setEmail("adeniyidaniel@gmail.com");
        request.setPassword("Daniel234@");
        ServiceProviderLoginResponse response = serviceProviderService.login(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatServiceProviderCanLogout(){
        ServiceProviderLogoutRequest request = new ServiceProviderLogoutRequest();
        request.setProviderId(1L);
        serviceProviderService.logout(request);
        assertFalse(serviceProviderRepository.findByEmail("lanlehin@gmail.com").isLogin());

    }

    @Test
    public void testThatServiceProviderCanUpdateProfile() throws ServiceFusionException {
        UpdateServiceProviderProfileRequest request = new UpdateServiceProviderProfileRequest();
        request.setEmail("");
        request.setFullName("Boluwatife Agboola");
        request.setPassword("Daniel234@");
        request.setPhoneNumber("08068952954");
        request.setLocation(Location.EJIGBO);
        request.setServiceCategory(ServiceCategory.CLEANERS);
        request.setYearsOfExperience("6 years");
        request.setDescription("Over 6 years experience");



    }


    @Test
    public void testThatServiceProviderCanBeFoundByCategory() throws ServiceFusionException {
        FindServiceProviderByCategoryRequest request = new FindServiceProviderByCategoryRequest();
        request.setCategory(ServiceCategory.HAIRSTYLISTS);
        FindServiceProviderByCategoryResponse response = serviceProviderService.findByServiceCategory(request);
        System.out.println(response);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatServiceProviderCanBeFoundByLocation() throws ServiceFusionException {
        FindServiceProviderByLocationRequest request = new FindServiceProviderByLocationRequest();
        request.setLocation(Location.EJIGBO);
        FIndServiceProviderByLocationResponse response = serviceProviderService.findByLocation(request);
        System.out.println(response);
        assertThat(response).isNotNull();
    }


}
