package com.example.demo.creational.builder;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class BuilderCommand {

    @ShellMethod(key = "builder", value = "Builder pattern (creational)")
    public void run() {
        System.out.println("=== Builder Pattern ===");
        System.out.println("Separate complex object construction from its representation;\n" +
                           "the same builder process can create different representations.\n");

        Pizza p1 = new PizzaBuilder()
                .size("large").crust("thick")
                .topping("pepperoni").topping("mushrooms")
                .extraCheese()
                .build();

        Pizza p2 = new PizzaBuilder()
                .size("small").crust("gluten-free")
                .topping("basil")
                .build();

        System.out.println("  Pizza 1: " + p1);
        System.out.println("  Pizza 2: " + p2);
        System.out.println("\nSame PizzaBuilder class, two completely different configurations.");
    }
}
