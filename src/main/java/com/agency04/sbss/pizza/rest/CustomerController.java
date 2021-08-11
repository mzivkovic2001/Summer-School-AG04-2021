package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        if (customerService.doesCustomerExists(username))
            return new ResponseEntity<>(customerService.getCustomerByUsername(username), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        if (customerService.doesCustomerExists(customer.getUsername()))
            return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);

        if (customerService.postCustomer(customer))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Error while inserting customer", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody Customer updatedCustomer) {
        if (customerService.doesCustomerExists(updatedCustomer.getUsername())) {
            if (customerService.updateCustomer(updatedCustomer))
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>("Error while updating customer", HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        if (customerService.doesCustomerExists(username)) {
            if (customerService.deleteCustomer(username))
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>("Error while deleting customer", HttpStatus.BAD_REQUEST);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
