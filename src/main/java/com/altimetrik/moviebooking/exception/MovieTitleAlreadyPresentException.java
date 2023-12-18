package com.altimetrik.moviebooking.exception;

public class MovieTitleAlreadyPresentException extends RuntimeException{
    public MovieTitleAlreadyPresentException(String message) {
        super(message);
    }
}
