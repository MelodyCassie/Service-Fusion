package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.NotificationSenderRequest;
import com.serviceFusion.Capstone.dtos.requests.ReceiverRequest;
import com.serviceFusion.Capstone.dtos.requests.RegistrationMessageRequest;
import com.serviceFusion.Capstone.dtos.requests.UpdateMessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceFusionNotificationServiceApp implements ServiceFusionNotificationService{
    private final NotificationSetUpServiceNoticeApp notificationSetUpServiceNoticeApp;
    @Override
    public void registrationNotification(RegistrationMessageRequest request) {
        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setEmail("tobi4tee@gmail.com");
        senderRequest.setName("ServiceFusion");
        List<ReceiverRequest> listOfReceivers = new ArrayList<>();
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setName(request.getFullName());
        receiverRequest.setEmail(request.getEmail());
        listOfReceivers.add(receiverRequest);
        String subject = "Welcome dear " + request.getFullName() + " your registration was successful." +
                " Welcome to a world of endless opportunities.We're glad to have you here.";
        String textContent = receiverRequest.getName() + " " + receiverRequest.getEmail() + " " + subject;
        notificationSetUpServiceNoticeApp.sendNotification(senderRequest,subject,textContent, listOfReceivers);


    }

    @Override
    public void updateNotification(UpdateMessageRequest request) {
        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setEmail("tobi4tee@gmail.com");
        senderRequest.setName("ServiceFusion");
        List<ReceiverRequest> listOfReceivers = new ArrayList<>();
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setName(request.getFullName());
        receiverRequest.setEmail(request.getEmail());
        listOfReceivers.add(receiverRequest);
        String subject = "Dear " + request.getFullName() + " your update was successful." +
                " In our world of endless opportunities.We're glad to have you here.";
        String textContent = receiverRequest.getName() + " " + receiverRequest.getEmail() + " " + subject;
        notificationSetUpServiceNoticeApp.sendNotification(senderRequest,subject,textContent, listOfReceivers);
    }
}
