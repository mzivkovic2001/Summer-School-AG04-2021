package com.agency04.sbss.pizza.rest;
import com.agency04.sbss.pizza.model.forms.CustomerForm;
import com.agency04.sbss.pizza.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<CustomerForm> getCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(customerService.getCustomerByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerForm customer) {
        customerService.postCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerForm updatedCustomer) {
        customerService.updateCustomer(updatedCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
            customerService.deleteCustomer(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
