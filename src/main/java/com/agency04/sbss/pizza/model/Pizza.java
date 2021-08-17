package com.agency04.sbss.pizza.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pizzaId;

    @Column(unique=true)
    private String name;

    @ManyToMany
    @JoinTable(name = "ingredients", joinColumns = @JoinColumn(name = "ingredientName"))
    private List<Ingredient> ingredients;

    public Pizza() {
    }

    public Pizza(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public long getPizzaId() {
        return pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return getPizzaId() == pizza.getPizzaId() && getName().equals(pizza.getName()) && getIngredients().equals(pizza.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPizzaId(), getName(), getIngredients());
    }
}
