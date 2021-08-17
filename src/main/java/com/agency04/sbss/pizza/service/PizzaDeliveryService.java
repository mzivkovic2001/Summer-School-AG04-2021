package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.forms.DeliveryForm;
import com.agency04.sbss.pizza.model.forms.PizzaOrderForm;
import com.agency04.sbss.pizza.repo.ICustomerRepository;
import com.agency04.sbss.pizza.repo.IDeliveryRepository;
import com.agency04.sbss.pizza.repo.IPizzaRepository;
import com.agency04.sbss.pizza.rest.exceptions.PizzaAppNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaDeliveryService implements IPizzaDeliveryService {
    private IPizzaRepository pizzaRepository;
    private IDeliveryRepository deliveryRepository;
    private ICustomerRepository customerRepository;
    private ConversionService conversionService;

    public PizzaDeliveryService(IPizzaRepository pizzaRepository, IDeliveryRepository deliveryRepository, ICustomerRepository customerRepository, ConversionService conversionService) {
        this.pizzaRepository = pizzaRepository;
        this.deliveryRepository = deliveryRepository;
        this.customerRepository = customerRepository;
        this.conversionService = conversionService;
    }

    @Override
    public void createOrder(DeliveryForm deliveryForm) {
        checkIfOrderedPizzasExist(deliveryForm.getPizzaOrders());
        checkIfCustomerExist(deliveryForm.getUsername());

        Delivery newDelivery = conversionService.convert(deliveryForm, Delivery.class);
        System.out.println(newDelivery);

        deliveryRepository.save(newDelivery);
    }

    @Override
    public List<DeliveryForm> getCurrentOrders() {
        List<DeliveryForm> deliveryForms = deliveryRepository.findAll().stream()
                .map(delivery -> conversionService.convert(delivery, DeliveryForm.class)).collect(Collectors.toList());
        return deliveryForms;
    }

    void checkIfOrderedPizzasExist(List<PizzaOrderForm> pizzaOrderForms) {
        for (PizzaOrderForm pizzaOrderForm: pizzaOrderForms) {
            if (!this.pizzaRepository.existsById(pizzaOrderForm.getPizzaId())) {
                throw new PizzaAppNotFoundException("Pizza with an id of " + pizzaOrderForm.getPizzaId() + " does not exist");
            }
        }
    }

    void checkIfCustomerExist(String customerUsername) {
        if (!customerRepository.existsByUsername(customerUsername)) {
           throw new PizzaAppNotFoundException("Customer with username " + customerUsername + " does not exist.");
        }
    }
}