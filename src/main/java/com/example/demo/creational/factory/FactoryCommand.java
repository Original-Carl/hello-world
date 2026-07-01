package com.example.demo.creational.factory;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class FactoryCommand {

    @ShellMethod(key = "factory", value = "Factory Method pattern (creational)")
    public void run() {
        System.out.println("=== Factory Method Pattern ===");
        System.out.println("The factory decouples object creation from the client;\n" +
                           "callers request a product by type without knowing its class.\n");
        for (String type : List.of("circle", "square", "triangle")) {
            Shape shape = ShapeFactory.create(type);
            System.out.printf("  ShapeFactory.create(\"%-8s) → %-26s area = %.2f%n",
                    type + "\"", shape.name(), shape.area());
        }
    }
}
