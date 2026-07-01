package com.example.demo.creational.abstractfactory;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.Map;

@ShellComponent
public class AbstractFactoryCommand {

    @ShellMethod(key = "abstract-factory", value = "Abstract Factory pattern (creational)")
    public void run() {
        System.out.println("=== Abstract Factory Pattern ===");
        System.out.println("""
                Provide an interface for creating families of related or dependent objects
                without specifying their concrete classes.

                Here: three game-theme factories each produce a coherent family of
                Character + Item + Location. Swapping the factory swaps the entire world.
                """);

        List<Map.Entry<String, GameThemeFactory>> themes = List.of(
                Map.entry("Fantasy-Folklore", new FantasyThemeFactory()),
                Map.entry("Sci-Fi",           new SciFiThemeFactory()),
                Map.entry("Modern-Era",        new ModernThemeFactory())
        );

        for (var entry : themes) {
            GameThemeFactory factory = entry.getValue();
            Character c = factory.createCharacter();
            Item      i = factory.createItem();
            Location  l = factory.createLocation();

            System.out.printf("=== %s ===%n", entry.getKey());
            System.out.printf("  Character : %s — %s%n", c.name(), c.describe());
            System.out.printf("  Item      : %s — %s%n", i.name(), i.describe());
            System.out.printf("  Location  : %s — %s%n", l.name(), l.describe());
            System.out.println();
        }
    }
}
