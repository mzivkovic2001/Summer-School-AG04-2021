package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.model.forms.CustomerForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class CustomerFormToCustomer implements Converter<CustomerForm, Customer> {

    @Override
    public Customer convert(CustomerForm source) {
        CustomerDetails details = new CustomerDetails(source.getFirstName(), source.getLastName(), source.getPhone());
        return new Customer(source.getUsername(), details);
    }
}
