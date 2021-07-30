package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.FirstPizzaDeliveryService;
import com.agency04.sbss.pizza.service.FirstPizzeriaService;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import com.agency04.sbss.pizza.service.IPizzeriaService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    // define bean with primary annotation for firstPizzeriaService
    @Bean
    @Primary
    public IPizzeriaService papizzaPizzeriaService() {
        return new FirstPizzeriaService();
    }

}
