package com.agency04.sbss.pizza.model;

import java.util.List;

public interface IPizza {
    String getName();
    List<PizzaIngredient> getIngredients();
}
