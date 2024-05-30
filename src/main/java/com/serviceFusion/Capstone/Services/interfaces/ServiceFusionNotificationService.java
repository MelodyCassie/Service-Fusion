package com.serviceFusion.Capstone.services.interfaces;

import com.serviceFusion.Capstone.dtos.requests.WelcomeMessageRequest;

public interface ServiceFusionNotificationService {
    void welcomeMail (WelcomeMessageRequest request);
}
