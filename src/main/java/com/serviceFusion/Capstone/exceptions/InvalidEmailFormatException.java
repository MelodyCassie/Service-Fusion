package com.serviceFusion.Capstone.exceptions;

public class InvalidEmailFormatException extends ServiceFusionException{

  public InvalidEmailFormatException(){

  }
  public InvalidEmailFormatException(String message){
      super(message);
  }
}
