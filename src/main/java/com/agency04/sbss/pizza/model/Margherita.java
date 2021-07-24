package com.agency04.sbss.pizza.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Margherita implements IPizza {
    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        return Arrays.asList
                (
                        PizzaIngredient.TOMATO_SAUCE,
                        PizzaIngredient.MOZZARELLA,
                        PizzaIngredient.OREGANO
                );
    }
}
