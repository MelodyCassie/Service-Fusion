package com.serviceFusion.Capstone.AdminTests;

import com.serviceFusion.Capstone.data.models.Role;
import com.serviceFusion.Capstone.dtos.requests.AdminLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.AdminRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.AdminUpdateProfileRequest;
import com.serviceFusion.Capstone.dtos.responses.AdminRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminUpdateProfileResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testThatAdminCanRegister() throws ServiceFusionException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setUsername("AgboolaToby");
        request.setPassword("1307Temmylove.");
        request.setName("Agboola Tobi Samuel");

        AdminRegistrationResponse response = adminService.registerAdmin(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatMoreThanOneAdminCanRegister() throws ServiceFusionException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("mbata1Favour@gmail.com");
        request.setUsername("Favvy");
        request.setPassword("favourMbata1234.");
        request.setName("Mbatata Favour");
        request.setCreatedAt(LocalDateTime.now());

        AdminRegistrationResponse response = adminService.registerAdmin(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatAttemptToRegisterWithAnAlreadyTakenEmailThrowsException(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("mbataFavour@gmail.com");
        request.setUsername("Favvy");
        request.setPassword("favourMbata1234.");
        request.setName("Mbatata Favour");
        request.setCreatedAt(LocalDateTime.now());
        assertThrows(ServiceFusionException.class,()->adminService.registerAdmin(request));
    }

    @Test
    public void testThatAttemptToRegisterWithInvalidEmailFormatThrowsException(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("favourmbatagmail.com");
        request.setUsername("Favvy");
        request.setPassword("favourMbata1234.");
        request.setName("Mbatata Favour");
        request.setCreatedAt(LocalDateTime.now());
        assertThrows(ServiceFusionException.class,()->adminService.registerAdmin(request));
    }

    @Test
    public void testThatAttemptToRegisterWithInvalidPasswordFormatThrowsException(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("favourmbatagmail.com");
        request.setUsername("Favvy");
        request.setPassword("111");
        request.setName("Mbatata Favour");
        request.setCreatedAt(LocalDateTime.now());
        assertThrows(ServiceFusionException.class,()->adminService.registerAdmin(request));
    }


    @Test
    public void testThatAdminCanUpdateProfile() throws ServiceFusionException {
        AdminUpdateProfileRequest request = new AdminUpdateProfileRequest();
        request.setAdminId(1L);
        request.setEmail("tobi4tee@gmail.com");
        request.setUsername("AgboolaTobi");
        request.setPassword("1307Agbool");
        request.setName("Agboola Tobi");
        request.setUpdatedAt(LocalDateTime.now());
        adminService.updateProfile(request);

        AdminRegistrationResponse response = new AdminRegistrationResponse();
        assertThat(response).isNotNull();

    }


    @Test
    public void testThatMultipleAdminCanUpdateProfile() throws ServiceFusionException {
        AdminUpdateProfileRequest request = new AdminUpdateProfileRequest();
        request.setAdminId(2L);
        request.setEmail("mbataFavour@gmail.com");
        request.setUsername("Favour");
        request.setPassword("Godsfavour001.");
        request.setName("HisFavour");
        AdminUpdateProfileResponse response = adminService.updateProfile(request);

        assertThat(response).isNotNull();

    }

    @Test
    public void testThatAdminCanLogin(){
        AdminLoginRequest request = new AdminLoginRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("1307Agbool");
        adminService.login(request);

    }

}
