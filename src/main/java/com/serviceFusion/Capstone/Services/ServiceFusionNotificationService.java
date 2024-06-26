package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.CustomerBookingMessageRequest;
import com.serviceFusion.Capstone.dtos.requests.RegistrationMessageRequest;
import com.serviceFusion.Capstone.dtos.requests.ServiceProviderBookingMessageRequest;
import com.serviceFusion.Capstone.dtos.requests.UpdateMessageRequest;

public interface ServiceFusionNotificationService {
    void registrationNotification(RegistrationMessageRequest request);
    void updateNotification(UpdateMessageRequest request);
    void customerBookingNotification(CustomerBookingMessageRequest request);
    void serviceProviderBookingNotification(ServiceProviderBookingMessageRequest request, String preferredTime);
}
