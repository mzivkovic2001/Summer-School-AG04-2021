package com.agency04.sbss.pizza.model.forms;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.enums.PizzaSize;

import java.util.List;

public class PizzeriaMenuForm {
    private List<Pizza> pizzas;
    private List<PizzaSize> sizes;

    public PizzeriaMenuForm(List<Pizza> pizzas, List<PizzaSize> sizes) {
        this.pizzas = pizzas;
        this.sizes = sizes;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<PizzaSize> getSizes() {
        return sizes;
    }

    public void setSizes(List<PizzaSize> sizes) {
        this.sizes = sizes;
    }
}
