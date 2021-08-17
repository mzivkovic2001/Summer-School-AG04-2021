package com.agency04.sbss.pizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerDetailId;
    private String firstName;
    private String lastName;
    private String phone;

    public CustomerDetails() {
    }

    public CustomerDetails(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // getters
    public long getCustomerDetailId() {
        return customerDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    // methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDetails)) return false;
        CustomerDetails that = (CustomerDetails) o;
        return getCustomerDetailId() == that.getCustomerDetailId() && getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerDetailId(), getFirstName(), getLastName(), getPhone());
    }
}
