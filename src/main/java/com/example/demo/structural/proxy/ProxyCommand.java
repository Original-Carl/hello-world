package com.example.demo.structural.proxy;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ProxyCommand {

    @ShellMethod(key = "proxy", value = "Proxy pattern (structural)")
    public void run() {
        System.out.println("=== Proxy Pattern ===");
        System.out.println("""
                Provide a surrogate or placeholder for another object to control access to it.

                Common proxy types:
                  • Virtual proxy  — defers expensive object creation until first use
                  • Protection proxy — controls access based on permissions
                  • Remote proxy    — represents an object in another address space
                  • Caching proxy   — caches results of expensive operations

                Example: a virtual proxy for a high-resolution image that loads the actual
                image from disk only when display() is first called.

                [stub — full demo coming]
                """);
    }
}
