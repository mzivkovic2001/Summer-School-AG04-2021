package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FirstPizzeriaService implements IPizzeriaService {
    // Private fields
    @Value("Papizza")
    private String name;
    @Value("Vodovodna 25")
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
