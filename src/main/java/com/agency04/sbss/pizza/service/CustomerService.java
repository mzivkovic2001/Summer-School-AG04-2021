package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.repo.ICustomerRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.model.forms.CustomerForm;
import com.agency04.sbss.pizza.rest.exceptions.PizzaAppBadRequestException;
import com.agency04.sbss.pizza.rest.exceptions.PizzaAppNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository;
    private ConversionService conversionService;

    public CustomerService(ICustomerRepository customerRepository, ConversionService conversionService) {
        this.customerRepository = customerRepository;
        this.conversionService = conversionService;
    }

    @Override
    public CustomerForm getCustomerByUsername(String username) {
        if (!doesCustomerExists(username)) {
            throw new PizzaAppNotFoundException("Customer with username " + username + " does not exist.");
        } else {
            return conversionService.convert(customerRepository.getByUsername(username), CustomerForm.class);
        }
    }

    @Override
    public void postCustomer(CustomerForm customerForm) {
        if(doesCustomerExists(customerForm.getUsername())) {
            throw new PizzaAppBadRequestException("Username " + customerForm.getUsername() + " is taken by another customer.");
        } else {
            Customer newCustomer = conversionService.convert(customerForm, Customer.class);
            customerRepository.save(newCustomer);
        }
    }

    @Override
    public boolean doesCustomerExists(String username) {
        return customerRepository.existsByUsername(username);
    }

    @Override
    public void updateCustomer(CustomerForm customerToUpdate) {
        if (!doesCustomerExists(customerToUpdate.getUsername())) {
            throw new PizzaAppNotFoundException("Customer with username " + customerToUpdate.getUsername() + " does not exist.");
        } else {
            Customer customer = customerRepository.getByUsername(customerToUpdate.getUsername());
            CustomerDetails detailsToUpdate = customer.getCustomerDetails();
            detailsToUpdate.setFirstName(customerToUpdate.getFirstName());
            detailsToUpdate.setLastName(customerToUpdate.getLastName());
            detailsToUpdate.setPhone(customerToUpdate.getPhone());
            customerRepository.save(customer);
        }
    }

    @Transactional
    @Override
    public void deleteCustomer(String username) {
        if(!doesCustomerExists(username)) {
            throw new PizzaAppNotFoundException("Customer with username " + username + " does not exist.");
        } else {
            customerRepository.deleteByUsername(username);
        }
    }
}
