package com.altimetrik.moviebooking.exception;

public class UserNotFoundException extends RuntimeException{
    private String error;
    private String message;
    public UserNotFoundException(String error,String msg){
        this.error = error;
        this.message = msg;
    }
}
