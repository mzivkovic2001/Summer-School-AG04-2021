package com.agency04.sbss.pizza;

import java.util.Arrays;
import java.util.List;

public class Capricciosa implements IPizza {
    @Override
    public String getName() {
        return "Capricciosa";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        List<PizzaIngredient> capricciosaIngredients = Arrays.asList
                (
                        PizzaIngredient.TOMATO_SAUCE,
                        PizzaIngredient.MOZZARELLA,
                        PizzaIngredient.OREGANO,
                        PizzaIngredient.HAM,
                        PizzaIngredient.ARTICHOKES,
                        PizzaIngredient.MUSHROOMS,
                        PizzaIngredient.OLIVES
                );
        return capricciosaIngredients;
    }
}
