package com.serviceFusion.Capstone.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class NotificationSenderRequest {
    private String name;
    private String email;
}
