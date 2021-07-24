package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;

import java.util.stream.Collectors;

public class OrderDescription {
    static String getOrderDescription(IPizza orderedPizza, IPizzeriaService pizzeriaService)
    {
        String orderDescription = "\nYou ordered " + orderedPizza.getName() + ": ";

        orderDescription += orderedPizza.getIngredients()
                .stream()
                .map((PizzaIngredient ingredient) -> {
                    return ingredient.getName();
                })
        .collect(Collectors.joining(", ", "", "."));

        orderDescription += "\nFrom: \"" + pizzeriaService.getName() + "\" " + pizzeriaService.getAddress();
        return orderDescription;
    }
}
