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

                Example: undo/redo in a text editor — each keystroke produces a
                Memento; undo pops the last Memento and restores it.

                [stub — full demo coming]
                """);
    }
}
