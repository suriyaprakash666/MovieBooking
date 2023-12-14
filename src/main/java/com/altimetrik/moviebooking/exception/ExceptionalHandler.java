package com.altimetrik.moviebooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionalHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomErrorResponse> handleRuntimeException(RuntimeException ex) {
        String message = ex.getMessage();
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now().toString(),500,"Runtime Exception", message);
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<SeatNotFoundException> handleSeatNotFoundException(SeatNotFoundException ex){
        String message = ex.getMessage();
        SeatNotFoundException seatNotFoundException = new SeatNotFoundException("Id Not Found with the ID: ","Check Your Id Once!");
        return new ResponseEntity<>(seatNotFoundException, HttpStatus.NOT_FOUND);
    }

}
