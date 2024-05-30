package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.NotificationSenderRequest;
import com.serviceFusion.Capstone.dtos.requests.ReceiverRequest;

import java.util.List;

public interface NotificationSetUpService {
    void sendNotification(NotificationSenderRequest request, String subject, String htmlContent, List<ReceiverRequest> receiverRequestList);
}
