package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class DataSender {
    private NotificationSenderRequest sender;
    private List<ReceiverRequest> to = new ArrayList<>();
    private String subject;
    private String textContent;
}
