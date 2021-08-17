package com.agency04.sbss.pizza.model.forms;

import com.agency04.sbss.pizza.model.enums.PizzaSize;

public class PizzaOrderForm {
    private long pizzaId;
    private String name;
    private PizzaSize size;
    private String quantity;

    public PizzaOrderForm() {
    }

    public PizzaOrderForm(long pizzaId, PizzaSize size, String quantity) {
        this.pizzaId = pizzaId;
        this.size = size;
        this.quantity = quantity;
    }

    public PizzaOrderForm(long pizzaId, String name, PizzaSize size, String quantity) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }

    public long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
