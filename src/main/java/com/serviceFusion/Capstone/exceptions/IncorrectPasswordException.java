package com.serviceFusion.Capstone.exceptions;

public class IncorrectPasswordException  extends ServiceFusionException{
    public IncorrectPasswordException(){

    }

    public IncorrectPasswordException(String message){
        super(message);
    }
}
