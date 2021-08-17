package com.agency04.sbss.pizza.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PizzaAppRestExceptionHandler {

    // exception handling code here

    @ExceptionHandler
    public ResponseEntity<PizzaAppErrorResponse> handleException (PizzaAppNotFoundException exc) {
        // Create a pizza error response
        PizzaAppErrorResponse error = new PizzaAppErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PizzaAppErrorResponse> handleException (PizzaAppBadRequestException exc) {
        PizzaAppErrorResponse error = new PizzaAppErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PizzaAppErrorResponse> handleException (Exception exc) {
        // Create a pizza error response
        PizzaAppErrorResponse error = new PizzaAppErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
