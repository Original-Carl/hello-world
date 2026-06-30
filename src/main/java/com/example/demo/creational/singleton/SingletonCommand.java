package com.example.demo.creational.singleton;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class SingletonCommand {

    @ShellMethod(key = "singleton", value = "Singleton pattern (creational)")
    public void run() {
        System.out.println("=== Singleton Pattern ===");
        System.out.println("Ensure a class has exactly one instance and provide a global access point.\n");

        AppRegistry r1 = AppRegistry.getInstance();
        AppRegistry r2 = AppRegistry.getInstance();

        r1.put("demo-key", "hello");

        System.out.println("  r1 == r2              : " + (r1 == r2));
        System.out.println("  r2.get(\"demo-key\")    : \"" + r2.get("demo-key") + "\"  (set via r1)");
        System.out.println("  System.identityHashCode: " + System.identityHashCode(r1));
        System.out.println("  Registry contents     : " + r1.all());
    }
}
