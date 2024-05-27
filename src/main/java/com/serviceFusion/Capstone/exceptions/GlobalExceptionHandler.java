package com.serviceFusion.Capstone.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceFusionException.class)
//    public ResponseEntity<ApiResponse> blogException(BlogException exception){
//        return new ResponseEntity<>(ApiResponse.builder()
//                .data(exception.getMessage())
//                .httpStatus(HttpStatus.BAD_REQUEST)
//                .statusCode(HttpStatus.BAD_REQUEST.value())
//                .isSuccessful(false)
//                .build(), HttpStatus.BAD_REQUEST);
//    }
    public ResponseEntity<String> handleServiceFusionException(ServiceFusionException exception){
     return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
