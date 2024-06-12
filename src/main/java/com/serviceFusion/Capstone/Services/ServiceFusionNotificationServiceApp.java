package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.data.models.Booking;
import com.serviceFusion.Capstone.data.models.Customer;
import com.serviceFusion.Capstone.data.models.ServiceProvider;
import com.serviceFusion.Capstone.dtos.requests.*;
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

    @Override
    public void customerBookingNotification(CustomerBookingMessageRequest request) {
        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setName("ServiceFusion");
        senderRequest.setEmail(request.getEmail());
        List<ReceiverRequest> listOfReceivers = new ArrayList<>();
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setName(request.getFullName());
        receiverRequest.setEmail(request.getEmail());
        listOfReceivers.add(receiverRequest);
        String subject = "Dear " + request.getFullName() + " your booking was successful. " +
                "You'll be contacted by your service provider shortly." +
                " Thanks for trusting us";
        String textContent = receiverRequest.getName() + " " + receiverRequest.getEmail() + " " + subject;
        notificationSetUpServiceNoticeApp.sendNotification(senderRequest,subject,textContent, listOfReceivers);

    }

    @Override
    public void serviceProviderBookingNotification(ServiceProviderBookingMessageRequest request,String preferredTime) {
        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setName("ServiceFusion");
        senderRequest.setEmail(request.getEmail());



        List<ReceiverRequest> listOfReceivers = new ArrayList<>();
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setName(request.getFullName());
        receiverRequest.setEmail(request.getEmail());
        listOfReceivers.add(receiverRequest);
        String subject = "Dear " + request.getFullName() + " your service has been booked for. The client prefers the service to be delivered on " + preferredTime +
                " Kindly check your mail and dashboard for more details." +
                ". Stay connected!";
        String textContent = request.getFullName() + " " + receiverRequest.getEmail() + subject;
        notificationSetUpServiceNoticeApp.sendNotification(senderRequest,subject,textContent,listOfReceivers);

    }

}
