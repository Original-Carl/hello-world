package com.example.demo.creational.builder;

import java.util.List;

public record Pizza(String size, String crust, List<String> toppings, boolean extraCheese) {
    @Override
    public String toString() {
        String t = toppings.isEmpty() ? "none" : String.join(", ", toppings);
        return size + " pizza on " + crust + " crust" +
               (extraCheese ? " + extra cheese" : "") +
               " [toppings: " + t + "]";
    }
}
