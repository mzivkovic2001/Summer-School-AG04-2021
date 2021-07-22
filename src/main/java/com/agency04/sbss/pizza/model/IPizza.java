package com.agency04.sbss.pizza.model;

import java.util.List;

public interface IPizza {
    public String getName();
    public List<PizzaIngredient> getIngredients();
}
