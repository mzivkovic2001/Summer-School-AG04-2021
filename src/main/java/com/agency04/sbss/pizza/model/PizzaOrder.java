package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.model.enums.PizzaSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pizzaOrderId;

    @ManyToOne
    @JoinColumn(name = "pizzaId")
    private Pizza pizza;

    @Enumerated(EnumType.STRING)
    private PizzaSize size;

    private String quantity;

    public PizzaOrder() {
    }

    public PizzaOrder(Pizza pizza, PizzaSize size, String quantity) {
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
    }

    public long getPizzaOrderId() {
        return pizzaOrderId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaOrder)) return false;
        PizzaOrder that = (PizzaOrder) o;
        return getPizzaOrderId() == that.getPizzaOrderId() && getPizza().equals(that.getPizza()) && getSize() == that.getSize() && getQuantity().equals(that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPizzaOrderId(), getPizza(), getSize(), getQuantity());
    }
}
