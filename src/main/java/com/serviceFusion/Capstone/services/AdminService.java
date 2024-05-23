package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.AdminLoginRequest;
import com.serviceFusion.Capstone.dtos.requests.AdminLogoutRequest;
import com.serviceFusion.Capstone.dtos.requests.AdminRegistrationRequest;
import com.serviceFusion.Capstone.dtos.requests.AdminUpdateProfileRequest;
import com.serviceFusion.Capstone.dtos.responses.AdminLoginResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminRegistrationResponse;
import com.serviceFusion.Capstone.dtos.responses.AdminUpdateProfileResponse;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws ServiceFusionException;

    AdminUpdateProfileResponse updateProfile(AdminUpdateProfileRequest request) throws ServiceFusionException;

    AdminLoginResponse login(AdminLoginRequest request) throws ServiceFusionException;

    void logout(AdminLogoutRequest request) throws ServiceFusionException;
}
