package com.example.demo.creational.prototype;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PrototypeCommand {

    @ShellMethod(key = "prototype", value = "Prototype pattern (creational)")
    public void run() {
        System.out.println("=== Prototype Pattern ===");
        System.out.println("""
                Specify the kinds of objects to create using a prototypical instance,
                and create new objects by copying (cloning) that prototype.

                Useful when object creation is expensive (database fetch, complex init)
                and a close copy is cheaper than building from scratch. Java's Cloneable
                interface or a copy constructor are typical implementation vehicles.

                Example: a game engine that clones a pre-configured enemy prototype
                rather than re-running expensive asset-loading for each new instance.

                [stub — full demo coming]
                """);
    }
}
