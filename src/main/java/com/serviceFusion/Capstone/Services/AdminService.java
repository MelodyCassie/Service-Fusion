package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.dtos.requests.*;
import com.serviceFusion.Capstone.dtos.responses.*;
import com.serviceFusion.Capstone.exceptions.ServiceFusionException;

import java.util.List;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws ServiceFusionException;

    AdminUpdateProfileResponse updateProfile(AdminUpdateProfileRequest request) throws ServiceFusionException;

    AdminLoginResponse login(AdminLoginRequest request) throws ServiceFusionException;

    void logout(AdminLogoutRequest request) throws ServiceFusionException;

    DeleteAdminResponse deleteAdmin(DeleteAdminRequest request);

    void deleteAll(DeleteAdminRequest request);

    AdminDeleteCustomerResponse deleteCustomer(AdminDeleteCustomerRequest request) throws ServiceFusionException;

    AdminDeleteServiceProviderResponse deleteServiceProvider(AdminDeleteServiceProviderRequest request) throws ServiceFusionException;

    List<Customer> findAllCustomers(AdminViewAllCustomersRequest request) throws ServiceFusionException;
}
