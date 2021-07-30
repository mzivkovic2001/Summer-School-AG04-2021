package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SecondPizzeriaService implements IPizzeriaService {
    @Value("${foo.name}")
    private String name;
    @Value("${foo.address}")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // define init method
    @PostConstruct
    public void initIt() {
        System.out.println(">>SecondPizzeriaService: inside of doMyStartupStuff(). Name: " + name);
    }

    // define destroy method
    @PreDestroy
    public void cleanUp() {
        System.out.println(">>SecondPizzeriaService: inside of cleanUp().");
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
