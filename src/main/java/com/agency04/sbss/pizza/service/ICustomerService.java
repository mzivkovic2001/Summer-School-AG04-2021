package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;

import java.io.IOException;

public interface ICustomerService {
    Customer getCustomerByUsername(String username);
    boolean postCustomer(Customer newCustomer);
    boolean doesCustomerExists(String username);
    boolean updateCustomer(Customer customerToUpdate);
    boolean deleteCustomer(String username);
}
