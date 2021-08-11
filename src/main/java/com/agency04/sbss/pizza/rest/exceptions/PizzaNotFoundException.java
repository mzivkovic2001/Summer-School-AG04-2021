package com.agency04.sbss.pizza.rest.exceptions;

public class PizzaNotFoundException extends RuntimeException {

    public PizzaNotFoundException(String message) {
        super(message);
    }

    public PizzaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PizzaNotFoundException(Throwable cause) {
        super(cause);
    }
}
