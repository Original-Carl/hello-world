package com.example.demo.structural.flyweight;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Random;

@ShellComponent
public class FlyweightCommand {

    @ShellMethod(key = "flyweight", value = "Flyweight pattern (structural)")
    public void run() {
        System.out.println("=== Flyweight Pattern: Sci-Fi RPG Enemy Spawner ===");
        System.out.println("""
                Use sharing to efficiently support a large number of fine-grained objects
                by separating intrinsic (shared) state from extrinsic (per-instance) state.

                Intrinsic  — species, base stats, sprite   : shared via CreatureType
                Extrinsic  — unit name, position, current HP: passed in at render time
                """);

        CreatureTypeFactory factory = new CreatureTypeFactory();

        record Unit(CreatureType type, String name, int x, int y, int hp) {}

        Object[][] catalog = {
            { "Xenomorph Scout",  80,  12, "[SCOUT]" },
            { "Plasma Drone",     50,  20, "[DRONE]" },
            { "Void Wraith",     120,   8, "[WRAITH]"},
        };
        String[] suffixes = { "Alpha", "Beta", "Gamma", "Delta", "Epsilon",
                              "Zeta",  "Eta",  "Theta", "Iota",  "Kappa"  };

        Random rng = new Random(42);
        Unit[] party = new Unit[12];
        for (int i = 0; i < party.length; i++) {
            Object[] def = catalog[i % 3];
            CreatureType type = factory.getType(
                    (String) def[0], (int) def[1], (int) def[2], (String) def[3]);
            String name = ((String) def[0]).split(" ")[0] + "-" + suffixes[i % suffixes.length];
            int x = rng.nextInt(50), y = rng.nextInt(50);
            int hp = 1 + rng.nextInt(type.baseHealth());
            party[i] = new Unit(type, name, x, y, hp);
        }

        System.out.println("  SPRITE   UNIT               SPECIES               POSITION    HP       ATK");
        System.out.println("  " + "-".repeat(78));
        for (Unit u : party) {
            System.out.println("  " + u.type().render(u.name(), u.x(), u.y(), u.hp()));
        }

        System.out.printf("%n%d enemy units in the dungeon, %d CreatureType instances in memory.%n",
                party.length, factory.cachedCount());
        System.out.println("Each shared type holds species stats once — not duplicated per unit.");
    }
}
