package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.forms.CustomerForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class CustomerToCustomerForm implements Converter<Customer, CustomerForm> {

    @Override
    public CustomerForm convert(Customer source) {
        return new CustomerForm(source.getCustomerId(), source.getUsername(),
                source.getCustomerDetails().getFirstName(), source.getCustomerDetails().getLastName(),
                source.getCustomerDetails().getPhone());
    }
}
