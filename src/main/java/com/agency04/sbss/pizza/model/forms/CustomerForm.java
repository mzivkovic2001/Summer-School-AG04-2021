package com.agency04.sbss.pizza.model.forms;

public class CustomerForm {
    private long customerId;
    private String username;
    private String firstName;
    private String lastName;
    private String phone;

    public CustomerForm() {
    }

    public CustomerForm(String username, String firstName, String lastName, String phone) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public CustomerForm(long customerId, String username, String firstName, String lastName, String phone) {
        this.customerId = customerId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
