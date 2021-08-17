package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.model.enums.PizzaIngredient;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ingredientId;
    private String name;
    @Enumerated(EnumType.STRING)
    private PizzaIngredient pizzaIngredient;

    public Ingredient() {
    }

    public Ingredient(PizzaIngredient pizzaIngredient) {
        this.name = pizzaIngredient.getName();
        this.pizzaIngredient = pizzaIngredient;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public String getName() {
        return name;
    }

    public PizzaIngredient getPizzaIngredient() {
        return pizzaIngredient;
    }

    public void setPizzaIngredient(PizzaIngredient pizzaIngredient) {
        this.pizzaIngredient = pizzaIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getIngredientId() == that.getIngredientId() && getName().equals(that.getName()) && getPizzaIngredient() == that.getPizzaIngredient();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredientId(), getName(), getPizzaIngredient());
    }
}
