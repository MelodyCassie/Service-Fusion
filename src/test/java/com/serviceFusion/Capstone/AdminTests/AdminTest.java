package com.serviceFusion.Capstone.AdminTests;

import com.serviceFusion.Capstone.data.models.Admin;
import com.serviceFusion.Capstone.data.repositories.AdminRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.services.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testThatAdminCanRegister() throws ServiceFusionException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setUsername("AgboolaToby");
        request.setPassword("1307Temmylove.");
        request.setFullName("Agboola Tobi Samuel");

        AdminRegistrationResponse response = adminService.registerAdmin(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatMoreThanOneAdminCanRegister() throws ServiceFusionException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("mbata1Favour@gmail.com");
        request.setUsername("Favvy");
        request.setPassword("favourMbata1234.");
        request.setFullName("Mbatata Favour");
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
        request.setFullName("Mbatata Favour");
        request.setCreatedAt(LocalDateTime.now());
        assertThrows(ServiceFusionException.class,()->adminService.registerAdmin(request));
    }

    @Test
    public void testThatAttemptToRegisterWithInvalidEmailFormatThrowsException(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("favourmbatagmail.com");
        request.setUsername("Favvy");
        request.setPassword("favourMbata1234.");
        request.setFullName("Mbatata Favour");
        request.setCreatedAt(LocalDateTime.now());
        assertThrows(ServiceFusionException.class,()->adminService.registerAdmin(request));
    }

    @Test
    public void testThatAttemptToRegisterWithInvalidPasswordFormatThrowsException(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("favourmbatagmail.com");
        request.setUsername("Favvy");
        request.setPassword("111");
        request.setFullName("Mbatata Favour");
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
    public void testThatAdminCanLogin() throws ServiceFusionException {
        AdminLoginRequest request = new AdminLoginRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("1307Agbool");
        AdminLoginResponse response = adminService.login(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatAdminCanLogout() throws ServiceFusionException {
        AdminLogoutRequest request = new AdminLogoutRequest();
        request.setId(1L);
      adminService.logout(request);
      Admin admin = adminRepository.findByEmail("tobi4tee@gmail.com");
        assertFalse(admin.isLogin());
    }

    @Test
    public void  testThatAnAdminCanBeDelete(){
        DeleteAdminRequest request = new DeleteAdminRequest();
        request.setAdminId(1L);
        DeleteAdminResponse response = adminService.deleteAdmin(request);

        assertThat(response).isNotNull();

    }

    @Test
    public void testThatAllAdminsCanBeDeleted(){
        DeleteAdminRequest request = new DeleteAdminRequest();
        adminService.deleteAll(request);
        assertEquals(0,adminRepository.findAll().size());
    }

    @Test
    public void testThatACustomerCanBeDeleted() throws ServiceFusionException {
        AdminDeleteCustomerRequest request = new AdminDeleteCustomerRequest();
        request.setAdminId(102L);
        request.setCustomerId(1L);
        AdminDeleteCustomerResponse response = adminService.deleteCustomer(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatAdminCanDeleteServiceProvider() throws ServiceFusionException {
        AdminDeleteServiceProviderRequest request = new AdminDeleteServiceProviderRequest();
        request.setAdminId(102L);
        request.setServiceProviderId(1L);
        AdminDeleteServiceProviderResponse response = adminService.deleteServiceProvider(request);
        assertThat(response).isNotNull();
    }

}
