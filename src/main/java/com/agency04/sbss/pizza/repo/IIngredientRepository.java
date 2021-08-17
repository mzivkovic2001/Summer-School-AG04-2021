package com.agency04.sbss.pizza.repo;

import com.agency04.sbss.pizza.model.Ingredient;
import com.agency04.sbss.pizza.model.enums.PizzaIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
    boolean existsByPizzaIngredient(PizzaIngredient pizzaIngredient);
    Ingredient getByPizzaIngredient(PizzaIngredient pizzaIngredient);
}
