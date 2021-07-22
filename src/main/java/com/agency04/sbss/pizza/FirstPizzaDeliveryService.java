package com.agency04.sbss.pizza;

public class FirstPizzaDeliveryService implements IPizzaDeliveryService {
    private IPizzeriaService _pizzeriaService;

    public FirstPizzaDeliveryService(IPizzeriaService pizzeriaService)
    {
        _pizzeriaService = pizzeriaService;
    }

    @Override
    public String orderPizza(IPizza orderedPizza) {
        return OrderDescription.getOrderDescription(orderedPizza, _pizzeriaService);
    }
}
