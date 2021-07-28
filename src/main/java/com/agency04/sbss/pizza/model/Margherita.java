package com.agency04.sbss.pizza.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Component
public class Margherita implements IPizza {
    @PostConstruct
    public void initIt() {
        System.out.println(">>Margherita - inside initIt()");
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println(">>Margherita - inside cleanUp()");
    }

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
