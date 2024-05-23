package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.AdminLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminUpdateProfileResponse;
import com.serviceFusion.Capstone.dtos.responses.DeleteAdminResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws ServiceFusionException;

    AdminUpdateProfileResponse updateProfile(AdminUpdateProfileRequest request) throws ServiceFusionException;

    AdminLoginResponse login(AdminLoginRequest request) throws ServiceFusionException;

    void logout(AdminLogoutRequest request) throws ServiceFusionException;

    DeleteAdminResponse deleteAdmin(DeleteAdminRequest request);

    void deleteAll(DeleteAdminRequest request);
}
