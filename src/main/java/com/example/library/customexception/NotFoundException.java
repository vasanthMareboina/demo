package com.example.library.customexception;

public class NotFoundException extends Exception{

    public NotFoundException(String message){
        super(message);
    }
}
