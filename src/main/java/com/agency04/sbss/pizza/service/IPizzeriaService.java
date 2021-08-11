package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzeriaInfo;
import com.agency04.sbss.pizza.model.PizzeriaMenu;

public interface IPizzeriaService {
    String getName();
    String getAddress();
    void makePizza(Pizza pizzaToMake);
    PizzeriaInfo getPizzeriaInfo();
    PizzeriaMenu getPizzeriaMenu();
}
