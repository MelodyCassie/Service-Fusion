package com.serviceFusion.Capstone;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.dtos.requests.FindServiceProviderByCategoryRequest;
import com.serviceFusion.Capstone.dtos.requests.FindServiceProviderByLocationRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.UpdateServiceProviderProfileRequest;
import com.serviceFusion.Capstone.dtos.responses.FIndServiceProviderByLocationResponse;
import com.serviceFusion.Capstone.dtos.responses.FindServiceProviderByCategoryResponse;
import com.serviceFusion.Capstone.dtos.responses.ServiceProviderRegistrationResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.ServiceProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProviderTest {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @Test
    public void testThatServiceProviderCanRegister() throws ServiceFusionException {
        ServiceProviderRegistrationRequest request = new ServiceProviderRegistrationRequest();
        request.setFullName("Boluwatife Agboola");
        request.setCategory(ServiceCategory.HAIRSTYLISTS);
        request.setEmail("lanlehin@gmail.com");
        request.setDescription("Does both male and female hair styling");
        request.setExperience(3);
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
        request.setDescription("Does both male and female hair styling");
        request.setExperience(1);
        request.setLocation(Location.ISOLO);
        ServiceProviderRegistrationResponse response = serviceProviderService.registerServiceProvider(request);
        assertThat(response).isNotNull();
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

    @Test
    public void testThatServiceProviderCanUpdateProfile() throws ServiceFusionException {
        UpdateServiceProviderProfileRequest request = new UpdateServiceProviderProfileRequest();

    }


}
