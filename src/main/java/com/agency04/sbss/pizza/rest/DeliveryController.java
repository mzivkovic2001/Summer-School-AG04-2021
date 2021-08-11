package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @Autowired
    private IPizzaDeliveryService pizzaDeliveryService;

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody DeliveryOrderForm order) {
        return ResponseEntity.ok().body(pizzaDeliveryService.createOrder(order));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DeliveryOrderForm>> getCurrentOrders() {
        return new ResponseEntity<>(pizzaDeliveryService.getCurrentOrders(), HttpStatus.OK) ;
    }
}
