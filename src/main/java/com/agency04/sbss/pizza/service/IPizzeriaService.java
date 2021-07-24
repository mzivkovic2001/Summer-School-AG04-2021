package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;

public interface IPizzeriaService {
    String getName();
    String getAddress();
    void makePizza(IPizza pizzaToMake);
}
