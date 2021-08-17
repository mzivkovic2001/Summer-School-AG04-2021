package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.forms.PizzeriaInfoForm;
import com.agency04.sbss.pizza.model.forms.PizzeriaMenuForm;
import com.agency04.sbss.pizza.model.forms.PizzaForm;

import java.util.List;

public interface IPizzeriaService {
    String getName();
    String getAddress();
    void makePizza(Pizza pizzaToMake);
    PizzeriaInfoForm getPizzeriaInfo();
    PizzeriaMenuForm getPizzeriaMenu();
    List<Pizza> getPizzaList();
    void insertPizza(PizzaForm pizza);
    boolean doesPizzaExists(long pizzaId);
}
