package com.example.demo.structural.facade;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class FacadeCommand {

    @ShellMethod(key = "facade", value = "Facade pattern (structural)")
    public void run() {
        System.out.println("=== Facade Pattern ===");
        System.out.println("Provide a unified, simplified interface to a complex subsystem.\n");

        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("Inception");
        System.out.println();
        theater.endMovie();
        System.out.println("\nThe client called two methods; the facade coordinated five subsystem calls.");
    }
}
