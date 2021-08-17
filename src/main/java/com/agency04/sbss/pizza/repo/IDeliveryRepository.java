package com.agency04.sbss.pizza.repo;

import com.agency04.sbss.pizza.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryRepository extends JpaRepository<Delivery, Long> {
}
