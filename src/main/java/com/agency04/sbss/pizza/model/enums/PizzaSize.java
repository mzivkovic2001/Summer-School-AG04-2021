package com.agency04.sbss.pizza.model.enums;

public enum PizzaSize {
    SMALL("S", 0),
    MEDIUM("M", 5),
    LARGE("L", 10),
    FAMILY("XL", 15);

    private final String label;
    private final double priceIncrement;

    PizzaSize(final String label, final double priceIncrement) {
        this.label = label;
        this.priceIncrement = priceIncrement;
    }

    public String getLabel() {
        return label;
    }

    public double getPriceIncrement() {
        return priceIncrement;
    }
}
