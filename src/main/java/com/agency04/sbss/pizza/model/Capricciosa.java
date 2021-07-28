package com.agency04.sbss.pizza.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Component
public class Capricciosa implements IPizza {

    @PostConstruct
    public void initIt() {
        System.out.println(">>Capricciosa - inside initIt()");
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println(">>Capricciosa - inside cleanUp()");
    }

    @Override
    public String getName() {
        return "Capricciosa";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {

        return Arrays.asList
                (
                        PizzaIngredient.TOMATO_SAUCE,
                        PizzaIngredient.MOZZARELLA,
                        PizzaIngredient.OREGANO,
                        PizzaIngredient.HAM,
                        PizzaIngredient.ARTICHOKES,
                        PizzaIngredient.MUSHROOMS,
                        PizzaIngredient.OLIVES
                );
    }
}
