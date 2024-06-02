package com.serviceFusion.Capstone.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceFusionException.class)
    public ResponseEntity<String> serviceFusionException(ServiceFusionException exception){
     return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
