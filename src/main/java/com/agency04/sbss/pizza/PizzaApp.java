package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.IPizza;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext pizzaContext = new ClassPathXmlApplicationContext("spring-context.xml");

        // retrieve beans from spring container
        IPizza margherita = pizzaContext.getBean("margherita", IPizza.class);
        IPizza capricciosa = pizzaContext.getBean("capricciosa", IPizza.class);
        IPizzaDeliveryService firstPizzaDeliveryService = pizzaContext.getBean("firstPizzaDeliveryService", IPizzaDeliveryService.class);
        IPizzaDeliveryService secondPizzaDeliveryService = pizzaContext.getBean("secondPizzaDeliveryService", IPizzaDeliveryService.class);

        // call methods on the bean
        System.out.println(firstPizzaDeliveryService.orderPizza(margherita));
        System.out.println(secondPizzaDeliveryService.orderPizza(capricciosa));

        // close the context
        pizzaContext.close();
    }

}
