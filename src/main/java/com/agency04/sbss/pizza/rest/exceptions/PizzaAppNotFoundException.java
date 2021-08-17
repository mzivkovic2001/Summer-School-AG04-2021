package com.agency04.sbss.pizza.rest.exceptions;

public class PizzaAppNotFoundException extends RuntimeException {

    public PizzaAppNotFoundException(String message) {
        super(message);
    }

    public PizzaAppNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PizzaAppNotFoundException(Throwable cause) {
        super(cause);
    }
}
