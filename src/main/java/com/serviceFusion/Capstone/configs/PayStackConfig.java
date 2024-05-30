package com.serviceFusion.Capstone.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PayStackConfig {

    @Value("${paystack.base.url}")
    private String payStackBaseUrl;
    @Value("${paystack.api.key}")
    private String payStackApiKey;


}
