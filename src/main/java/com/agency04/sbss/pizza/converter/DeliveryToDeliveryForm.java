package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.forms.DeliveryForm;
import com.agency04.sbss.pizza.model.forms.PizzaOrderForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryToDeliveryForm implements Converter<Delivery, DeliveryForm> {

    @Override
    public DeliveryForm convert(Delivery source) {
        List<PizzaOrderForm> pizzaOrderFormList = source.getPizzaOrders().stream().map(pizzaOrder -> {
            PizzaOrderForm pizzaOrderForm = new PizzaOrderForm(pizzaOrder.getPizza().getPizzaId(),
                    pizzaOrder.getPizza().getName(), pizzaOrder.getSize(), pizzaOrder.getQuantity());
            return pizzaOrderForm;
        }).collect(Collectors.toList());

        DeliveryForm newDeliveryForm = new DeliveryForm(source.getCustomer().getUsername(), source.getSubmissionDate(), pizzaOrderFormList);
        return newDeliveryForm;
    }
}
