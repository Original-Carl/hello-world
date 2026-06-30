package com.example.demo.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private String size = "medium";
    private String crust = "thin";
    private final List<String> toppings = new ArrayList<>();
    private boolean extraCheese = false;

    public PizzaBuilder size(String size)       { this.size = size; return this; }
    public PizzaBuilder crust(String crust)     { this.crust = crust; return this; }
    public PizzaBuilder topping(String topping) { toppings.add(topping); return this; }
    public PizzaBuilder extraCheese()           { this.extraCheese = true; return this; }

    public Pizza build() { return new Pizza(size, crust, List.copyOf(toppings), extraCheese); }
}
