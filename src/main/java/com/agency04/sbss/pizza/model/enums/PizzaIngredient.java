package com.agency04.sbss.pizza.model.enums;

public enum PizzaIngredient {
    TOMATO_SAUCE("tomato sauce"),
    MOZZARELLA("mozzarella"),
    OREGANO("oregano"),
    ARTICHOKES("artichokes"),
    MUSHROOMS("mushrooms"),
    OLIVES("olives"),
    HAM("ham");

    private final String ingredient;

    /**
     * @param ingredient
     */
    private PizzaIngredient(final String ingredient) {
        this.ingredient = ingredient;
    }

    public String getName() {
        return ingredient;
    }
}
