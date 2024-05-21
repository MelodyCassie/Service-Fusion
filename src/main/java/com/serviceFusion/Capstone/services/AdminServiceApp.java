package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Admin;
import com.serviceFusion.Capstone.data.repositories.AdminRepository;
import com.serviceFusion.Capstone.dtos.requests.AdminRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.AdminUpdateProfileRequest;
import com.serviceFusion.Capstone.dtos.responses.AdminRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminUpdateProfileResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.serviceFusion.Capstone.utils.Verification.verifyEmail;
import static com.serviceFusion.Capstone.utils.Verification.verifyPassword;

@Service
@AllArgsConstructor
public class AdminServiceApp implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Override
    public AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws ServiceFusionException {
        existingAdmin(request);
        verifyAdmin(request);
        Admin admin = modelMapper.map(request, Admin.class);
        admin.setRole(request.getRole());
        admin.setCreateAt(LocalDateTime.now());
        adminRepository.save(admin);

        return getResponse(admin);

    }

    private static AdminRegistrationResponse getResponse(Admin admin) {
        AdminRegistrationResponse response = new AdminRegistrationResponse();
        response.setAdminId(admin.getId());
        response.setMessage("Successfully registered admin " + admin.getUsername());
        return response;
    }

    private static void verifyAdmin(AdminRegistrationRequest request) throws ServiceFusionException {
        if(!verifyEmail(request.getEmail())) throw new ServiceFusionException("Invalid email format");
        if(!verifyPassword(request.getPassword())) throw new ServiceFusionException("Invalid password format");
    }

    private void existingAdmin(AdminRegistrationRequest request) throws ServiceFusionException {
        boolean isRegistered = adminRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new ServiceFusionException("Submitted email already taken");
    }

    @Override
    public AdminUpdateProfileResponse updateProfile(AdminUpdateProfileRequest request) throws ServiceFusionException {
        Admin existingAdmin = getAdmin(request);
        modelMapper.map(request, existingAdmin);
        existingAdmin.setRole(request.getRole());
        existingAdmin.setUpdatedAt(LocalDateTime.now());
        adminRepository.save(existingAdmin);

        return getUpdateProfileResponse(existingAdmin);

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
