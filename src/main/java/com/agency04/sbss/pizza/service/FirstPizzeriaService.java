package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// manually constructed bean inside of PizzaConfig
public class FirstPizzeriaService implements IPizzeriaService {
    // Private fields
    private String name;
    private String address;

    // getters & setters
    public void setName(String name) {
        System.out.println("FirstPizzeriaService -- setting name.");
        this.name = name;
    }
    public void setAddress(String address) {
        System.out.println("FirstPizzeriaService -- setting address.");
        this.address = address;
    }

    // define init method
    @PostConstruct
    public void initIt() {
        name = "Papizza";
        address = "Vodovodna 25";
        System.out.println(">>FirstPizzeriaService: inside of initIt().");
    }

    // define destroy method
    @PreDestroy
    public void cleanUp() {
        System.out.println(">>FirstPizzeriaService: inside of cleanUp(). Name: " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void makePizza(IPizza pizzaToMake) {
    }
}
