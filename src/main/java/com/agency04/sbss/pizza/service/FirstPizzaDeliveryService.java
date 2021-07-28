package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FirstPizzaDeliveryService implements IPizzaDeliveryService {
    private IPizzeriaService pizzeriaService;

    @Autowired
    public FirstPizzaDeliveryService(@Qualifier("firstPizzeriaService")IPizzeriaService firstPizzeriaService)
    {
        pizzeriaService = firstPizzeriaService;
    }

    // define init method
    @PostConstruct
    public void initIt() {
        System.out.println(">>FirstPizzaDeliveryService: inside of doMyStartupStuff().");
    }

    // define destroy method
    @PreDestroy
    public void cleanUp() {
        System.out.println(">>FirstPizzaDeliveryService: inside of cleanUp(). Dependency: " + pizzeriaService);
    }

    @Override
    public String orderPizza(IPizza orderedPizza) {
        return OrderDescription.getOrderDescription(orderedPizza, pizzeriaService);
    }
}
