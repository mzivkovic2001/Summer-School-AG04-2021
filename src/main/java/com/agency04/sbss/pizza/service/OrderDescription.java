package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.IPizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;

public class OrderDescription {
    static String getOrderDescription(IPizza orderedPizza, IPizzeriaService pizzeriaService)
    {
        String orderDescription = "\nYou ordered " + orderedPizza.getName() + ": ";

        for (PizzaIngredient ingredient: orderedPizza.getIngredients())
        {
            orderDescription += ingredient.getName();
            Integer ordinalElementNum = orderedPizza.getIngredients().indexOf(ingredient) + 1;
            Integer n = orderedPizza.getIngredients().size();
            if (ordinalElementNum < n) {
                orderDescription += ", ";
            } else {
                orderDescription += ".";
            }
        }
        orderDescription += "\nFrom: \"" + pizzeriaService.getName() + "\" " + pizzeriaService.getAddress();
        return orderDescription;
    }
}
