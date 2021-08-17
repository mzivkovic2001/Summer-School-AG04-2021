package com.agency04.sbss.pizza.model.forms;

import com.agency04.sbss.pizza.model.enums.PizzaIngredient;

import java.util.List;

public class PizzaForm {
    private String name;
    private List<PizzaIngredient> pizzaIngredientList;

    public PizzaForm() {
    }

    public PizzaForm(String name, List<PizzaIngredient> pizzaIngredientList) {
        this.name = name;
        this.pizzaIngredientList = pizzaIngredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PizzaIngredient> getPizzaIngredientList() {
        return pizzaIngredientList;
    }

    public void setPizzaIngredientList(List<PizzaIngredient> pizzaIngredientList) {
        this.pizzaIngredientList = pizzaIngredientList;
    }
}
