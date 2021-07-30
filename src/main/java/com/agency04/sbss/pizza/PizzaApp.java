package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.IPizza;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext pizzaContext = new AnnotationConfigApplicationContext(PizzaConfig.class);

        // retrieve beans from spring container
        IPizza margherita = pizzaContext.getBean("margherita", IPizza.class);
        IPizza capricciosa = pizzaContext.getBean("capricciosa", IPizza.class);
        IPizzaDeliveryService firstPizzaDeliveryService = pizzaContext.getBean("firstPizzaDeliveryService", IPizzaDeliveryService.class);
        IPizzaDeliveryService secondPizzaDeliveryService = pizzaContext.getBean("secondPizzaDeliveryService", IPizzaDeliveryService.class);

        // call methods on the bean
        System.out.println(firstPizzaDeliveryService.orderPizza(margherita));
        System.out.println(secondPizzaDeliveryService.orderPizza(capricciosa));

        // close the context
        System.out.println("\n");
        pizzaContext.close();
    }

}
