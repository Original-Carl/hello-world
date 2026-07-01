package com.example.demo.behavioral.iterator;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class IteratorCommand {

    @ShellMethod(key = "iterator", value = "Iterator pattern (behavioral)")
    public void run() {
        System.out.println("=== Iterator Pattern ===");
        System.out.println("""
                Provide a way to sequentially access elements of an aggregate without
                exposing its underlying representation.

                Java's java.util.Iterator is the canonical example. The pattern lets
                you write algorithms once, over the Iterator interface, and apply them
                to any data structure that implements it (list, tree, graph, etc.).

                Demo: ISS Argonaut flight plan — iterating waypoints without knowing
                the FlightPlan's internal structure.
                """);

        FlightPlan plan = new FlightPlan();
        plan.add(new Waypoint(0,   0,  "Starport Kepler"));
        plan.add(new Waypoint(3,   0,  "Debris Field 7"));
        plan.add(new Waypoint(6,  -2,  "Dock Platform 3"));

        System.out.printf("Route has %d stops:%n", plan.size());
        int stop = 1;
        for (Waypoint wp : plan) {
            System.out.printf("  %d. %-22s  hex=(%2d,%2d)%n", stop++, wp.label(), wp.q(), wp.r());
        }
    }
}
