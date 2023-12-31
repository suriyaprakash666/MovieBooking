package com.altimetrik.moviebooking.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionControllerAdvice {

//    Use This format to write exception in this controller


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomErrorResponse> handleRuntimeException(RuntimeException ex) {
        String message = ex.getMessage();
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now().toString(),500,"Runtime Exception", message);
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public  ResponseEntity<UserNotFoundException> handleUserNotFoundException(UserNotFoundException ex){
        String message = ex.getMessage();
        UserNotFoundException userNotFoundException = new UserNotFoundException("User Not Found with the ID: ","Check User Id Once!");
        return new ResponseEntity<>(userNotFoundException,HttpStatus.NOT_FOUND);
    }



}
