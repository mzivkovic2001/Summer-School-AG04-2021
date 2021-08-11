package com.agency04.sbss.pizza.model;

import java.util.List;

public class DeliveryOrderForm {
    private int id;
    private Customer customer;
    private List<DeliveryOrderPizzaItem> orderedPizzas;

    public DeliveryOrderForm() {
    }

    public DeliveryOrderForm(int id, Customer customer, List<DeliveryOrderPizzaItem> orderedPizzas) {
        this.id = id;
        this.customer = customer;
        this.orderedPizzas = orderedPizzas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<DeliveryOrderPizzaItem> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setOrderedPizzas(List<DeliveryOrderPizzaItem> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }
}
