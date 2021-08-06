package com.agency04.sbss.pizza.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Component
public class Margherita implements IPizza {
    private String name;
    private List<PizzaIngredient> ingredients;

    @PostConstruct
    public void initIt() {
        name = "Margherita";
        ingredients = Arrays.asList
                (
                        PizzaIngredient.TOMATO_SAUCE,
                        PizzaIngredient.MOZZARELLA,
                        PizzaIngredient.OREGANO
                );
        System.out.println(">>Margherita - inside initIt(). Name: " + name);
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println(">>Margherita - inside cleanUp()");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        return ingredients;
    }
}
