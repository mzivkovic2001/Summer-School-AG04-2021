package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deliveryId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PizzaOrder> pizzaOrders;

    private Date submissionDate;

    public Delivery() {
    }

    public Delivery(Customer customer, List<PizzaOrder> pizzaOrders, Date submissionDate) {
        this.customer = customer;
        this.pizzaOrders = pizzaOrders;
        this.submissionDate = submissionDate;
    }

    // setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    // getters
    public long getDeliveryId() {
        return deliveryId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    // methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery)) return false;
        Delivery delivery = (Delivery) o;
        return getDeliveryId() == delivery.getDeliveryId() && getCustomer().equals(delivery.getCustomer()) && getPizzaOrders().equals(delivery.getPizzaOrders()) && getSubmissionDate().equals(delivery.getSubmissionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeliveryId(), getCustomer(), getPizzaOrders(), getSubmissionDate());
    }
}
