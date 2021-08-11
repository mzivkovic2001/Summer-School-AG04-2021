package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class CustomerService implements ICustomerService {
    private String key;
    @Autowired
    private IMockDbService mockDbService;

    @PostConstruct
    public void initIt() {
        key = "customers";
    }


    @Override
    public Customer getCustomerByUsername(String username) {
        return mockDbService.getDataByPropertyValue(key, "username", username, Customer.class);
    }

    @Override
    public boolean postCustomer(Customer newCustomer) {
        newCustomer.setId(mockDbService.getNextId(key));
        try{
            mockDbService.insertData(key, newCustomer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean doesCustomerExists(String username) {
        return mockDbService.doesDataExists(key, "username", username);
    }

    @Override
    public boolean updateCustomer(Customer customerToUpdate) {
        try {
            mockDbService.updateData(key, "username", customerToUpdate, customerToUpdate.getUsername());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCustomer(String username) {
        Customer customerToDelete = getCustomerByUsername(username);
        try {
            mockDbService.deleteData(key, "username", customerToDelete, customerToDelete.getUsername());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
