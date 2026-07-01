package com.example.demo.behavioral.memento;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MementoCommand {

    @ShellMethod(key = "memento", value = "Memento pattern (behavioral)")
    public void run() {
        System.out.println("=== Memento Pattern ===");
        System.out.println("""
                Without violating encapsulation, capture and externalise an object's
                internal state so the object can be restored to that state later.

                Three roles:
                  • Originator  — the object whose state is saved/restored
                  • Memento     — the snapshot (opaque to everyone except Originator)
                  • Caretaker   — holds mementos but never inspects them

                Demo: ISS Argonaut navigating a hex grid between a starport and a
                docking platform, with course corrections that can be undone.
                """);

        Starship ship = new Starship(0, 0, 2, "E");
        FlightLog log = new FlightLog();

        printState("Docked at starport      ", ship);
        log.push(ship.save());

        ship.move();
        ship.move();
        printState("En route (2 moves E)    ", ship);
        log.push(ship.save());

        ship.setDirection("NE");
        ship.setSpeed(3);
        ship.move();
        printState("Course correction → NE/3", ship);

        ship.restore(log.pop());
        printState("Undo correction         ", ship);

        ship.restore(log.pop());
        printState("Undo journey → starport ", ship);
    }

    private void printState(String label, Starship s) {
        System.out.printf("  %-26s  pos=(%2d,%2d)  speed=%d  heading=%s%n",
                label, s.q(), s.r(), s.speed(), s.direction());
    }
}
