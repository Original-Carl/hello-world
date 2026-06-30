package com.example.demo.behavioral.mediator;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MediatorCommand {

    @ShellMethod(key = "mediator", value = "Mediator pattern (behavioral)")
    public void run() {
        System.out.println("=== Mediator Pattern ===");
        System.out.println("""
                Define an object that encapsulates how a set of objects interact,
                promoting loose coupling by keeping objects from referring to each
                other explicitly.

                Without a mediator, N components with cross-cutting communication
                require O(N²) references. The mediator centralises that logic.

                Example: a chat room (Mediator) that routes messages between User
                objects — users only know about the room, not each other.

                [stub — full demo coming]
                """);
    }
}
