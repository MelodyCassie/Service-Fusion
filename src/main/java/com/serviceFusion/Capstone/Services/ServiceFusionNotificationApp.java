package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.NotificationSenderRequest;
import com.serviceFusion.Capstone.dtos.requests.ReceiverRequest;
import com.serviceFusion.Capstone.dtos.requests.WelcomeMessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceFusionNotificationApp implements ServiceFusionNotificationService{
    private final NotificationSetUpServiceNoticeApp notificationSetUpServiceNoticeApp;
    @Override
    public void welcomeMail(WelcomeMessageRequest request) {
        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setEmail("tobi4tee@gmail.com");
        senderRequest.setName("ServiceFusion");
        List<ReceiverRequest> listOfReceivers = new ArrayList<>();
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setName(request.getFullName());
        receiverRequest.setEmail(request.getEmail());
        listOfReceivers.add(receiverRequest);
        String subject = "Welcome! Your registration was successful";
        String textContent = receiverRequest.getName() + " " + receiverRequest.getEmail() + " " + subject;
        notificationSetUpServiceNoticeApp.sendNotification(senderRequest,subject,textContent, listOfReceivers);


    }
}
