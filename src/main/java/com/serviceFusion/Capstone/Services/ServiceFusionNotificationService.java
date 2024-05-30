package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.WelcomeMessageRequest;

public interface ServiceFusionNotificationService {
    void welcomeMail (WelcomeMessageRequest request);
}
