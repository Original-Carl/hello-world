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

                Custom iterators are useful for domain traversals: tree in-order walk,
                paginated API responses, lazy file-line streaming.

                [stub — full demo coming]
                """);
    }
}
