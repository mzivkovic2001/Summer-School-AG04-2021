package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import java.util.List;

public interface IPizzaDeliveryService {
    List<String> createOrder(DeliveryOrderForm order);
    List<DeliveryOrderForm> getCurrentOrders();
}
