package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.DeliveryOrderPizzaItem;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.rest.exceptions.PizzaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaDeliveryService implements IPizzaDeliveryService {
    private String key;
    @Autowired
    private IMockDbService mockDbService;
    @Autowired
    private IPizzeriaService pizzeriaService;

    @PostConstruct
    public void initIt() {
        key = "deliveryOrders";
    }

    @Override
    public List<String> createOrder(DeliveryOrderForm order) {
        if (!orderedPizzaExists(order.getOrderedPizzas())){
            throw new PizzaNotFoundException("One of ordered pizzas is not on the menu.");
        }
        order.setId(mockDbService.getNextId(key));
        order.getOrderedPizzas().stream()
                .forEach(pizza -> {
                    Pizza orderedPizza = mockDbService.getDataByPropertyValue("pizzas", "id", pizza.getPizzaId(), Pizza.class);
                    pizza.setPrice((orderedPizza.getPrice() + pizza.getSize().getPriceIncrement()) * pizza.getQuantity());
                });

        try {
            mockDbService.insertData(key, order);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new PizzaNotFoundException(ex);
        }

        List<String> ordersDescriptions = order.getOrderedPizzas().stream().map(item -> {
            return OrderDescription.getOrderDescription(mockDbService.getDataByPropertyValue("pizzas", "id", item.getPizzaId(), Pizza.class), pizzeriaService);
        }).collect(Collectors.toList());

        return ordersDescriptions;
    }

    @Override
    public List<DeliveryOrderForm> getCurrentOrders() {
        return mockDbService.getData(key);
    }

    boolean orderedPizzaExists(List<DeliveryOrderPizzaItem> orderedItems) {
        List<Integer> orderedPizzas = orderedItems.stream()
                .map(DeliveryOrderPizzaItem::getPizzaId)
                .collect(Collectors.toList());

        int counter = 0;
        for (int orderedPizzaId: orderedPizzas) {
            if (mockDbService.doesDataExists("pizzas", "id", orderedPizzaId) ) {
                counter++;
            }
        }

        return (counter == orderedPizzas.size()) ? true: false;
    }
}





















































































































































































































