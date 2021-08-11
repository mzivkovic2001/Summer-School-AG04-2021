package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PizzeriaService implements IPizzeriaService {
    @Value("${foo.name}")
    private String name;
    @Value("${foo.address}")
    private String address;
    @Autowired
    private IMockDbService mockDbService;

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
    public void makePizza(Pizza pizzaToMake) {

    }
    @Override
    public PizzeriaInfo getPizzeriaInfo() {
        return new PizzeriaInfo(getName(), getAddress());
    }

    @Override
    public PizzeriaMenu getPizzeriaMenu() {
        return new PizzeriaMenu(mockDbService.getData("pizzas"), Stream.of(PizzaSize.values()).collect(Collectors.toList()));
    }
}
