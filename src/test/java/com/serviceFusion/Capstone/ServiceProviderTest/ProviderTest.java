package com.serviceFusion.Capstone.ServiceProviderTest;

import com.serviceFusion.Capstone.data.models.Location;
import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.IncorrectPasswordException;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.exceptions.UserNotFoundException;
import com.serviceFusion.Capstone.services.ServiceProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
        request.setFullName("Sola Agboola");
        request.setCategory(ServiceCategory.BARBERS);
        request.setEmail("sola@gmail.com");
        request.setDescription("Does both male and female hair styling");
        request.setYearsOfExperience("5 years");
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
        request.setCategory(ServiceCategory.CLEANERS);
        request.setEmail("adeniyidaniel01@gmail.com");
        request.setDescription("Male and Female hair styling");
        request.setYearsOfExperience("2 years");
        request.setLocation(Location.ISOLO);
        request.setPassword("Daniel234@");
        request.setPhoneNumber("08168952046");

        ServiceProviderRegistrationResponse response = serviceProviderService.registerServiceProvider(request);
        assertThat(response).isNotNull();
    }
    @Test
    public void testThatServiceProviderCanLogin() throws UserNotFoundException, IncorrectPasswordException {
        ServiceProviderLoginRequest request = new ServiceProviderLoginRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("lanlehinTifeh13@");
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
    public void testThatServiceProviderCanUpdateProfile(){
        UpdateServiceProviderProfileRequest request = new UpdateServiceProviderProfileRequest();
        request.setEmail("");
        request.setFullName("Boluwatife Agboola");
        request.setPassword("Daniel234@");
        request.setPhoneNumber("08068952954");
        request.setLocation(Location.EJIGBO);
        request.setServiceCategory(ServiceCategory.CLEANERS);
        request.setYearsOfExperience("6 years");
        request.setDescription("Over 6 years experience");

        UpdateServiceProviderProfileResponse response = serviceProviderService.updateProfile(request);
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
    public void testThatAllRegisteredServiceProvidersCanBeFound(){
        serviceProviderRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void testThatAServiceProviderListOfBookingsCanBeFound() throws ServiceFusionException {
        ViewProviderBookingRequest request = new ViewProviderBookingRequest();
        request.setProviderId(1L);

        ViewProviderBookingResponse response = serviceProviderService.getAllBooking(request);
        System.out.println(response.getProviderListOfBooking().size());
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatServiceProviderCanUploadImage() throws ServiceFusionException, IOException {
        ServiceProviderUploadImageRequest request = new ServiceProviderUploadImageRequest();

        request.setServiceProviderId(1L);
        UploadImageRequest request1 = new UploadImageRequest();
        File file1 = new File("C:\\Users\\Dell\\Pictures\\Camera Roll\\WIN_20240314_15_15_40_Pro.jpg");
        FileInputStream inputStream = new FileInputStream(file1);
        MultipartFile multipartFile = new MockMultipartFile(
                "file", inputStream);
        request1.setImage(multipartFile);
        request.setImageRequest(request1);



        UploadImageResponse response = serviceProviderService.uploadProfilePicture(request);
        System.out.println(response.getUrl());
        assertThat(response).isNotNull();
    }

}
