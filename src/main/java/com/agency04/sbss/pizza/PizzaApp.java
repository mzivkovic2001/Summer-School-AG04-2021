package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.IPizza;
import com.agency04.sbss.pizza.service.IPizzaDeliveryService;
import com.agency04.sbss.pizza.service.IPizzeriaService;
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
        IPizzeriaService pizzeria_a = pizzaContext.getBean("firstPizzeriaService", IPizzeriaService.class);
        IPizzeriaService pizzeria_b = pizzaContext.getBean("firstPizzeriaService", IPizzeriaService.class);
        IPizzeriaService pizzeria_c = pizzaContext.getBean("secondPizzeriaService", IPizzeriaService.class);
        IPizzeriaService pizzeria_d = pizzaContext.getBean("secondPizzeriaService", IPizzeriaService.class);

        // call methods on the bean
        System.out.println(firstPizzaDeliveryService.orderPizza(margherita));
        System.out.println(secondPizzaDeliveryService.orderPizza(capricciosa));

        // check if pizzerias are sharing the same memory location
        System.out.println("\nPointing to the same object (scope - singleton): " + (pizzeria_a == pizzeria_b));
        System.out.println("Memory location for the pizzera_a: " + pizzeria_a);
        System.out.println("Memory location for the pizzera_b: " + pizzeria_b); // both pizzerias should point to the same adress location in memory during the run of the app
        System.out.println("\nPointing to the same object (scope - prototype): " + (pizzeria_c == pizzeria_d));
        System.out.println("Memory location for the pizzera_a: " + pizzeria_c);
        System.out.println("Memory location for the pizzera_b: " + pizzeria_d + "\n"); // for each getBean request new object is created and each object points to a different memory location

        // preDestroy pizzerias with a prototype type of scope

        // close the context
        pizzaContext.close();
    }

}
