package com.example.demo.behavioral.state;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class StateCommand {

    @ShellMethod(key = "state", value = "State pattern (behavioral)")
    public void run() {
        System.out.println("=== State Pattern ===");
        System.out.println("""
                Allow an object to alter its behaviour when its internal state changes;
                the object will appear to change its class.

                Each state is encapsulated in its own class implementing a State interface.
                The Context delegates behaviour to the current State object and transitions
                between states by replacing it.

                Example: a vending machine transitions between Idle → HasCoin → Dispensing
                → OutOfStock, with each state defining what insert(), eject(), and
                dispense() do.

                [stub — full demo coming]
                """);
    }
}
