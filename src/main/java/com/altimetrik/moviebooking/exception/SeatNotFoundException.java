package com.altimetrik.moviebooking.exception;

public class SeatNotFoundException extends RuntimeException{
    private String error;
    private String message;
    public SeatNotFoundException(String error,String msg){
        this.error = error;
        this.message = msg;
    }
}

