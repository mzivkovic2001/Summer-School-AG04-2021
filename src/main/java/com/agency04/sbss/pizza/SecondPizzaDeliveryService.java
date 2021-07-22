package com.agency04.sbss.pizza;

public class SecondPizzaDeliveryService implements IPizzaDeliveryService {
    private IPizzeriaService _pizzeriaService;

    // no arg constructor
    public SecondPizzaDeliveryService() {
        System.out.println("RegisteredPizzaDeliveryService - inside no-arg constructor.");
    }

    // setter method
    public void set_pizzeriaService(IPizzeriaService _pizzeriaService) {
        System.out.println("RegisteredPizzaDeliveryService - inside setter method (set_pizzeriaService).");
        this._pizzeriaService = _pizzeriaService;
    }
    @Override
    public String orderPizza(IPizza orderedPizza) {
        return OrderDescription.getOrderDescription(orderedPizza, _pizzeriaService);
    }
}
