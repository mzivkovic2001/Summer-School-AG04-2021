package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.model.forms.DeliveryForm;
import com.agency04.sbss.pizza.repo.ICustomerRepository;
import com.agency04.sbss.pizza.repo.IPizzaRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryFormToDelivery implements Converter<DeliveryForm, Delivery> {
    private final IPizzaRepository pizzaRepository;
    private final ICustomerRepository customerRepository;

    public DeliveryFormToDelivery(IPizzaRepository pizzaRepository, ICustomerRepository customerRepository) {
        this.pizzaRepository = pizzaRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Delivery convert(DeliveryForm source) {
        List<PizzaOrder> pizzaOrders = source.getPizzaOrders().stream().map(pizzaForm -> {
            PizzaOrder newPizzaOrder = new PizzaOrder(pizzaRepository.getByPizzaId(pizzaForm.getPizzaId()), pizzaForm.getSize(), pizzaForm.getQuantity());
            return newPizzaOrder;
        }).collect(Collectors.toList());
        Customer customer = customerRepository.getByUsername(source.getUsername());
        Delivery newDelivery = new Delivery(customer, pizzaOrders, source.getSubmissionDate());
        return newDelivery;
    }
}
