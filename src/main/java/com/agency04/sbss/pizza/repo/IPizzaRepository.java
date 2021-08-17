package com.agency04.sbss.pizza.repo;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza getByPizzaId(Long id);
}
