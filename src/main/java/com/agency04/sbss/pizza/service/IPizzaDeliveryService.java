package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.forms.DeliveryForm;

import java.util.List;

public interface IPizzaDeliveryService {
    void createOrder(DeliveryForm deliveryForm);
    List<DeliveryForm> getCurrentOrders();
}
