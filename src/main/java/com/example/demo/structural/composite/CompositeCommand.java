package com.example.demo.structural.composite;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CompositeCommand {

    @ShellMethod(key = "composite", value = "Composite pattern (structural)")
    public void run() {
        System.out.println("=== Composite Pattern ===");
        System.out.println("""
                Compose objects into tree structures to represent part-whole hierarchies,
                letting clients treat individual objects and compositions uniformly.

                Both leaf nodes and composite nodes implement the same Component interface,
                so a client iterating a tree doesn't need to distinguish between the two.

                Example: a file-system tree where File and Directory both implement
                Component.size() — a Directory.size() recursively sums its children.

                [stub — full demo coming]
                """);
    }
}
