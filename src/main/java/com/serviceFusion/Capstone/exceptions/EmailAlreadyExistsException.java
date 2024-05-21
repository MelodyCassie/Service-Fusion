package com.serviceFusion.Capstone.exceptions;

public class EmailAlreadyExistsException extends ServiceFusionException {


    public EmailAlreadyExistsException(){

    }
    public EmailAlreadyExistsException(String message){
        super(message);
    }

}

