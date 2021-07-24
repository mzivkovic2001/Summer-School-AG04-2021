package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FirstPizzaDeliveryService implements IPizzaDeliveryService {
    private IPizzeriaService pizzeriaService;

    @Autowired
    public FirstPizzaDeliveryService(@Qualifier("firstPizzeriaService")IPizzeriaService firstPizzeriaService)
    {
        pizzeriaService = firstPizzeriaService;
    }

    @Override
    public String orderPizza(IPizza orderedPizza) {
        return OrderDescription.getOrderDescription(orderedPizza, pizzeriaService);
    }
}
