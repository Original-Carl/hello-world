package com.example.demo.behavioral.chain;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ChainCommand {

    @ShellMethod(key = "chain", value = "Chain of Responsibility pattern (behavioral)")
    public void run() {
        System.out.println("=== Chain of Responsibility Pattern ===");
        System.out.println("""
                Avoid coupling the sender of a request to its receiver by giving more than
                one object a chance to handle the request; chain the receiving objects and
                pass the request along the chain until one handles it.

                Each handler decides: handle the request, pass it on, or both.

                Example: an HTTP middleware pipeline — each handler either responds (auth
                failure, rate-limit exceeded) or calls the next handler in the chain.

                [stub — full demo coming]
                """);
    }
}
