package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(unique=true)
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Delivery> deliveries;

    public Customer() {
    }

    public Customer(String username, CustomerDetails customerDetails) {
        this.username = username;
        this.customerDetails = customerDetails;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() && getUsername().equals(customer.getUsername()) && getCustomerDetails().equals(customer.getCustomerDetails()) && getDeliveries().equals(customer.getDeliveries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getUsername(), getCustomerDetails(), getDeliveries());
    }
}
