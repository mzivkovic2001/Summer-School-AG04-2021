package com.agency04.sbss.pizza.model;

public class Customer{
    private int id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String surname, String username, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
