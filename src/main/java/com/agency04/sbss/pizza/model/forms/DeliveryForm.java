package com.agency04.sbss.pizza.model.forms;

import java.util.Date;
import java.util.List;

public class DeliveryForm {
    private String username;
    private Date submissionDate;
    private List<PizzaOrderForm> pizzaOrders;

    public DeliveryForm() {
    }

    public DeliveryForm(String username, Date submissionDate, List<PizzaOrderForm> pizzaOrders) {
        this.username = username;
        this.submissionDate = submissionDate;
        this.pizzaOrders = pizzaOrders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public List<PizzaOrderForm> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrderForm> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }
}
