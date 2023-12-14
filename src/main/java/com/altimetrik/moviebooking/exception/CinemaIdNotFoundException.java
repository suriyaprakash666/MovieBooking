package com.altimetrik.moviebooking.exception;

public class CinemaIdNotFoundException extends Exception{
    String message;

    public CinemaIdNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
