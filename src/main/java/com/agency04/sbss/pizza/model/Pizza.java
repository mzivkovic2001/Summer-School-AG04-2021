package com.agency04.sbss.pizza.model;


import java.util.List;


public class Pizza {
    private String name;
    private List<PizzaIngredient> ingredients;
    private double price;
    private int id;

    public Pizza() {
    }

    public Pizza(int id, String name, List<PizzaIngredient> ingredients, double price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PizzaIngredient> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<PizzaIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
