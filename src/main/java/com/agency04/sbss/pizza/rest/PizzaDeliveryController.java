package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.IPizza;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PizzaDeliveryController {
    private IPizza margherita;
    private IPizza capricciosa;
    @Autowired
    private IPizzaDeliveryService firstPizzaDeliveryService;
    private IPizzaDeliveryService secondPizzaDeliveryService;

    public PizzaDeliveryController
            (@Qualifier("margherita")IPizza margherita,
             @Qualifier("capricciosa")IPizza capricciosa,
             IPizzaDeliveryService firstPizzaDeliveryService,
             @Qualifier("secondPizzaDeliveryService")IPizzaDeliveryService secondPizzaDeliveryService)
    {
        this.margherita = margherita;
        this.capricciosa = capricciosa;
        this.firstPizzaDeliveryService = firstPizzaDeliveryService;
        this.secondPizzaDeliveryService = secondPizzaDeliveryService;

    }

    // expose / that returns description of pizza order
    @GetMapping("/")
    public List<String> orderPizza() {
        return Arrays.asList(
                firstPizzaDeliveryService.orderPizza(margherita),
                secondPizzaDeliveryService.orderPizza(capricciosa)
        ); 
    }
}
