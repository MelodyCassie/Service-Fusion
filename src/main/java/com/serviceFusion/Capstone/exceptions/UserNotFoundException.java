package com.serviceFusion.Capstone.exceptions;

public class UserNotFoundException extends ServiceFusionException{
    public UserNotFoundException(){

    }
    public UserNotFoundException(String message){
        super(message);
    }
}
