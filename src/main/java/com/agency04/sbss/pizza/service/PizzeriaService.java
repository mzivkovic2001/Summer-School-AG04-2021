package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.model.enums.PizzaIngredient;
import com.agency04.sbss.pizza.model.enums.PizzaSize;
import com.agency04.sbss.pizza.model.forms.PizzaForm;
import com.agency04.sbss.pizza.model.forms.PizzeriaInfoForm;
import com.agency04.sbss.pizza.model.forms.PizzeriaMenuForm;
import com.agency04.sbss.pizza.repo.IIngredientRepository;
import com.agency04.sbss.pizza.repo.IPizzaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PizzeriaService implements IPizzeriaService {
    @Value("${foo.name}")
    private String name;
    @Value("${foo.address}")
    private String address;

    private IPizzaRepository pizzaRepository;
    private IIngredientRepository ingredientRepository;

    public PizzeriaService(IPizzaRepository pizzaRepository, IIngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void makePizza(Pizza pizzaToMake) {

    }
    @Override
    public PizzeriaInfoForm getPizzeriaInfo() {
        return new PizzeriaInfoForm(getName(), getAddress());
    }

    @Override
    public PizzeriaMenuForm getPizzeriaMenu() {
        return new PizzeriaMenuForm(getPizzaList(), Stream.of(PizzaSize.values()).collect(Collectors.toList()));
    }

    @Override
    public List<Pizza> getPizzaList() {
        return pizzaRepository.findAll();
    }

    @Transactional
    @Override
    public void insertPizza(PizzaForm pizza) {
        List<Ingredient> ingredients = pizza.getPizzaIngredientList().stream().map((PizzaIngredient ingredientEnum) -> {
            if (!ingredientRepository.existsByPizzaIngredient(ingredientEnum)) {
                Ingredient insertedIngredient = ingredientRepository.save(new Ingredient(ingredientEnum));
                return insertedIngredient;
            } else {
                return ingredientRepository.getByPizzaIngredient(ingredientEnum);
            }
        }).collect(Collectors.toList());
        pizzaRepository.save(new Pizza(pizza.getName(), ingredients));
    }

    @Override
    public boolean doesPizzaExists(long pizzaId) {
        return pizzaRepository.existsById(pizzaId);
    }


}
