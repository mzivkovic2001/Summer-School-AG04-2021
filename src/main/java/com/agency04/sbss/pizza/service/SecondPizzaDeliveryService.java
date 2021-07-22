package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SecondPizzaDeliveryService implements IPizzaDeliveryService {
    private IPizzeriaService _pizzeriaService;
    // no arg constructor
    public SecondPizzaDeliveryService() {
        System.out.println("SecondPizzaDeliveryService - inside no-arg constructor.");
    }
    // setter method
    @Autowired
    public void set_pizzeriaService(@Qualifier("secondPizzeriaService")IPizzeriaService _pizzeriaService) {
        System.out.println("SecondPizzaDeliveryService - inside setter method (set_pizzeriaService).");
        this._pizzeriaService = _pizzeriaService;
    }

    @Override
    public String orderPizza(IPizza orderedPizza) {
        return OrderDescription.getOrderDescription(orderedPizza, _pizzeriaService);
    }
}
