package com.agency04.sbss.pizza.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Component
public class Capricciosa implements IPizza {
    private String name;
    private List<PizzaIngredient> ingredients;

    @PostConstruct
    public void initIt() {
        name = "Capricciosa";
        ingredients = Arrays.asList
                (
                        PizzaIngredient.TOMATO_SAUCE,
                        PizzaIngredient.MOZZARELLA,
                        PizzaIngredient.OREGANO,
                        PizzaIngredient.HAM,
                        PizzaIngredient.ARTICHOKES,
                        PizzaIngredient.MUSHROOMS,
                        PizzaIngredient.OLIVES
                );
        System.out.println(">>Capricciosa - inside initIt(). Name: " + name);
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println(">>Capricciosa - inside cleanUp()");
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
