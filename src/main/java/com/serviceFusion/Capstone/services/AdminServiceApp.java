package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Admin;
import com.serviceFusion.Capstone.data.models.Role;
import com.serviceFusion.Capstone.data.repositories.AdminRepository;
import com.serviceFusion.Capstone.data.repositories.CustomerRepository;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import com.serviceFusion.Capstone.data.repositories.ServiceProviderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.serviceFusion.Capstone.utils.Verification.*;

@Service
@AllArgsConstructor
public class AdminServiceApp implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceFusionNotificationService fusionNotificationService;

    @Override
    public AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws ServiceFusionException {
        existingAdmin(request);
        verifyAdmin(request);
        Admin admin = modelMapper.map(request, Admin.class);
        admin.setRole(Role.ADMIN);
        admin.setCreatedAt(LocalDateTime.now());
        adminRepository.save(admin);
        WelcomeMessageRequest welcomeRequest = new WelcomeMessageRequest();
        welcomeRequest.setEmail(admin.getEmail());
        welcomeRequest.setFullName(admin.getFullName());
        fusionNotificationService.welcomeMail(welcomeRequest);


        return getResponse(admin);

    }

    private static AdminRegistrationResponse getResponse(Admin admin) {
        AdminRegistrationResponse response = new AdminRegistrationResponse();
        response.setAdminId(admin.getId());
        response.setMessage("Successfully registered admin " + admin.getUsername());
        return response;
    }

    private static void verifyAdmin(AdminRegistrationRequest request) throws ServiceFusionException {
        if(verifyEmail(request.getEmail())) throw new ServiceFusionException("Invalid email format");
        if(verifyPassword(request.getPassword())) throw new ServiceFusionException("Invalid password format");
        if (request.getUsername().length() < 3) throw new ServiceFusionException("Invalid username format");
    }

    private void existingAdmin(AdminRegistrationRequest request) throws ServiceFusionException {
        boolean isRegistered = adminRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new ServiceFusionException("Submitted email already taken");
    }

    @Override
    public AdminUpdateProfileResponse updateProfile(AdminUpdateProfileRequest request) throws ServiceFusionException {
        Admin existingAdmin = getAdmin(request);
        if (existingAdmin.isLogin()) throw new ServiceFusionException("Kindly login to update profile");
        modelMapper.map(request, existingAdmin);
        existingAdmin.setRole(Role.ADMIN);
        existingAdmin.setUpdatedAt(LocalDateTime.now());
        adminRepository.save(existingAdmin);

        return getUpdateProfileResponse(existingAdmin);

    }

    @Override
    public AdminLoginResponse login(AdminLoginRequest request) throws ServiceFusionException {
        Admin admin = adminRepository.findByEmail(request.getEmail());
        if (admin==null) throw new ServiceFusionException("Admin not found");
        if (!admin.getPassword().equals(request.getPassword())) throw new ServiceFusionException("Incorrect password");
        admin.setLogin(true);
        adminRepository.save(admin);

        AdminLoginResponse response = new AdminLoginResponse();
        response.setMessage("Login successful");
        return response;
    }

    @Override
    public void logout(AdminLogoutRequest request) throws ServiceFusionException {
        Admin admin = adminRepository.findById(request.getId()).orElse(null);
        if (admin==null) throw new ServiceFusionException("User not found");

        admin.setLogin(false);
        adminRepository.save(admin);
    }

    @Override
    public DeleteAdminResponse deleteAdmin(DeleteAdminRequest request) {

        adminRepository.findById(request.getAdminId());
        adminRepository.deleteById(request.getAdminId());

        DeleteAdminResponse response = new DeleteAdminResponse();
        response.setMessage("Admin successfully deleted");
        return response;
    }

    @Override
    public void deleteAll(DeleteAdminRequest request) {
        adminRepository.deleteAll();
    }

    @Override
    public AdminDeleteCustomerResponse deleteCustomer(AdminDeleteCustomerRequest request) throws ServiceFusionException {
        Admin admin = adminRepository.findById(request.getAdminId()).orElse(null);
        if (admin==null) throw new ServiceFusionException("Admin not found");
        customerRepository.deleteById(request.getCustomerId());
        AdminDeleteCustomerResponse response = new AdminDeleteCustomerResponse();
        response.setMessage(request.getCustomerId() + " has been successfully deleted");

        return response;
    }

    @Override
    public AdminDeleteServiceProviderResponse deleteServiceProvider(AdminDeleteServiceProviderRequest request) throws ServiceFusionException {
        Admin admin = adminRepository.findById(request.getAdminId()).orElse(null);
        if (admin==null) throw new ServiceFusionException("Admin not found");
        if (!admin.isLogin()) throw new ServiceFusionException("Kindly login to perform your operations");
        serviceProviderRepository.deleteById(request.getServiceProviderId());
        AdminDeleteServiceProviderResponse response = new AdminDeleteServiceProviderResponse();
        response.setMessage(request.getServiceProviderId() + " has been successfully deleted");

        return response;
    }

    private static AdminUpdateProfileResponse getUpdateProfileResponse(Admin existingAdmin) {
        AdminUpdateProfileResponse response = new AdminUpdateProfileResponse();
        response.setAdminId(existingAdmin.getId());
        response.setMessage("Successfully updated admin " + existingAdmin.getUsername());
        return response;
    }

    private Admin getAdmin(AdminUpdateProfileRequest request) throws ServiceFusionException {
        Admin existingAdmin = adminRepository.findById(request.getAdminId()).orElse(null);
        if (existingAdmin == null) throw new ServiceFusionException("Admin not found");
        return existingAdmin;
    }
}
