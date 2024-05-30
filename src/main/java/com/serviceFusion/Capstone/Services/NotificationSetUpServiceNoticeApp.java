package com.serviceFusion.Capstone.services;

import com.serviceFusion.Capstone.dtos.requests.DataSender;
import com.serviceFusion.Capstone.dtos.requests.NotificationSenderRequest;
import com.serviceFusion.Capstone.dtos.requests.ReceiverRequest;
import com.serviceFusion.Capstone.dtos.responses.NotificationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NotificationSetUpServiceNoticeApp implements NotificationSetUpService {

    @Value("${brevo.base.url}")
    private String url;
    @Value("${brevo.api.key}")
    private String apiKey;


    @Override
    public void sendNotification(NotificationSenderRequest request, String subject, String textContent, List<ReceiverRequest> receiverRequestList) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("api-key",apiKey);
        for (ReceiverRequest to : receiverRequestList){
            DataSender dataSender = new DataSender();
            dataSender.setSender(request);
            dataSender.getTo().add(to);
            dataSender.setSubject(subject);
            dataSender.setTextContent(textContent);
            HttpEntity<DataSender> httpEntity = new HttpEntity<>(dataSender, httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            System.out.println(httpEntity);
            ResponseEntity<NotificationResponse> response = restTemplate.postForEntity(url, httpEntity, NotificationResponse.class);
            System.out.println(response.getBody());
        }

    }
}
