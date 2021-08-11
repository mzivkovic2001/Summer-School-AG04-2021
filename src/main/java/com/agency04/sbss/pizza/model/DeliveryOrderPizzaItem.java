package com.agency04.sbss.pizza.model;

public class DeliveryOrderPizzaItem {
    private int pizzaId;
    private PizzaSize size;
    private int quantity;
    private double price;

    public DeliveryOrderPizzaItem() {
    }

    public DeliveryOrderPizzaItem(int pizzaId, PizzaSize size, int quantity) {
        this.pizzaId = pizzaId;
        this.size = size;
        this.quantity = quantity;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
