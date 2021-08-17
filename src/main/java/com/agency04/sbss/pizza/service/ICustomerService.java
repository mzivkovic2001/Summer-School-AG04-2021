package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.forms.CustomerForm;

public interface ICustomerService {
    CustomerForm getCustomerByUsername(String username);
    void postCustomer(CustomerForm customerForm);
    boolean doesCustomerExists(String username);
    void updateCustomer(CustomerForm customerToUpdate);
    void deleteCustomer(String username);
}
