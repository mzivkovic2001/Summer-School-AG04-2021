package com.agency04.sbss.pizza;

public interface IPizzeriaService {
    public String getName();
    public String getAddress();
    public void makePizza(IPizza pizzaToMake);
}
