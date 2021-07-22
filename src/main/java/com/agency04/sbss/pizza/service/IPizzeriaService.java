package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;

public interface IPizzeriaService {
    public String getName();
    public String getAddress();
    public void makePizza(IPizza pizzaToMake);
}
