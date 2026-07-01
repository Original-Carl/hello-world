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
                """);

        EnemyPrototypeRegistry registry = new EnemyPrototypeRegistry();
        registry.register("goblin", new Enemy("Goblin", 5, 5));
        registry.register("dragon", new Enemy("Dragon", 50, 3));

        for (String key : java.util.List.of("goblin", "dragon")) {
            Enemy a = registry.getClone(key);
            Enemy b = registry.getClone(key);
            b.setHealth(b.health() * 2);
            System.out.printf("%-8s  clone-A health=%d  clone-B health=%d (after doubling)  same ref=%b%n",
                    a.type(), a.health(), b.health(), a == b);
        }
    }
}
