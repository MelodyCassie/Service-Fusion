package com.serviceFusion.Capstone.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceFusionException extends Exception {

    private final Logger logger = LoggerFactory.getLogger(ServiceFusionException.class);
    public ServiceFusionException(String message) {
        super(message);
        logger.error("error: {}", message);
    }
}
