package com.example.demo.creational.abstractfactory;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class AbstractFactoryCommand {

    @ShellMethod(key = "abstract-factory", value = "Abstract Factory pattern (creational)")
    public void run() {
        System.out.println("=== Abstract Factory Pattern ===");
        System.out.println("""
                Provide an interface for creating families of related or dependent objects
                without specifying their concrete classes.

                Classic example: a UI toolkit factory that produces Button + Checkbox
                for a given look-and-feel (Windows / macOS / Web). Swapping the factory
                swaps the entire family at once — no individual class is referenced directly.

                Differs from Factory Method in that it produces *multiple* product types
                (a product family), whereas Factory Method produces one product.

                [stub — full demo coming]
                """);
    }
}
