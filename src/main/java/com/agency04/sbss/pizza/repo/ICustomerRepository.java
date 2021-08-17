package com.agency04.sbss.pizza.repo;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer getByUsername(String username);
    boolean existsByUsername(String username);
    void deleteByUsername(String username);
}
