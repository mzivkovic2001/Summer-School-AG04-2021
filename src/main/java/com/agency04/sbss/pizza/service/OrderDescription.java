package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;

import java.util.stream.Collectors;

public class OrderDescription {
    static String getOrderDescription(Pizza orderedPizza, IPizzeriaService pizzeriaService)
    {
        String orderDescription = "\nYou ordered " + orderedPizza.getName() + ": ";

        orderDescription += orderedPizza.getIngredients()
                .stream()
                .map(PizzaIngredient::getName)
        .collect(Collectors.joining(", ", "", "."));

        orderDescription += "\nFrom: \"" + pizzeriaService.getName() + "\" " + pizzeriaService.getAddress();
        return orderDescription;
    }
}
