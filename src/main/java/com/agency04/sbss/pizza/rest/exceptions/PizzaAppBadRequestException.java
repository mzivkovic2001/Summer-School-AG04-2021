package com.agency04.sbss.pizza.rest.exceptions;

public class PizzaAppBadRequestException extends RuntimeException{
    public PizzaAppBadRequestException(String message) {
        super(message);
    }

    public PizzaAppBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PizzaAppBadRequestException(Throwable cause) {
        super(cause);
    }
}
