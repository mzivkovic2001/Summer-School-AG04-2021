package com.agency04.sbss.pizza.rest;
import com.agency04.sbss.pizza.model.forms.DeliveryForm;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private IPizzaDeliveryService pizzaDeliveryService;

    public DeliveryController(IPizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @PostMapping("/order")
    public ResponseEntity createOrder(@RequestBody DeliveryForm order) {
        pizzaDeliveryService.createOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DeliveryForm>> getCurrentOrders() {
        return new ResponseEntity<>(pizzaDeliveryService.getCurrentOrders(), HttpStatus.OK) ;
    }
}
