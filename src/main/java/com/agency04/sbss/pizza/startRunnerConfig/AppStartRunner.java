package com.agency04.sbss.pizza.startRunnerConfig;

import com.agency04.sbss.pizza.model.enums.PizzaIngredient;
import com.agency04.sbss.pizza.model.forms.CustomerForm;
import com.agency04.sbss.pizza.model.forms.PizzaForm;
import com.agency04.sbss.pizza.service.ICustomerService;
import com.agency04.sbss.pizza.service.IPizzeriaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class AppStartRunner implements ApplicationRunner {
    private ICustomerService customerService;
    private IPizzeriaService pizzeriaService;

    public AppStartRunner(ICustomerService customerService, IPizzeriaService pizzeriaService) {
        this.customerService = customerService;
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        customers();
        pizzas();
    }

    public void customers() {
        customerService.postCustomer(new CustomerForm("fastFoodLover", "Ivo", "Ivic", "0918523212"));
        customerService.postCustomer(new CustomerForm("lovePizza", "Ana", "Anic", "0954876655"));
    }

    public void pizzas() {
        PizzaForm margherita = new PizzaForm("Margherita", Arrays.asList(PizzaIngredient.MOZZARELLA, PizzaIngredient.OLIVES, PizzaIngredient.TOMATO_SAUCE));
        pizzeriaService.insertPizza(margherita);
        PizzaForm cappriciosa = new PizzaForm("Cappriciosa",
                Arrays.asList(PizzaIngredient.MOZZARELLA, PizzaIngredient.OLIVES, PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.HAM, PizzaIngredient.MUSHROOMS,
                        PizzaIngredient.ARTICHOKES, PizzaIngredient.OREGANO));
        pizzeriaService.insertPizza(cappriciosa);
    }
}
