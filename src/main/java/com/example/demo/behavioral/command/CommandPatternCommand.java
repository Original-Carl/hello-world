package com.example.demo.behavioral.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CommandPatternCommand {

    @ShellMethod(key = "command", value = "Command pattern (behavioral)")
    public void run() {
        System.out.println("=== Command Pattern ===");
        System.out.println("Encapsulate requests as objects, enabling parameterization,\n" +
                           "queuing, logging, and undoable operations.\n");

        TextEditor editor = new TextEditor();

        System.out.println("  --- executing ---");
        editor.execute(new WriteAction(editor, "Hello"));
        editor.execute(new WriteAction(editor, ", World"));
        editor.execute(new DeleteLastAction(editor, 6));

        System.out.println("\n  --- undoing (last 2 operations) ---");
        editor.undo();
        editor.undo();

        System.out.println("\n  Final buffer: \"" + editor.content() + "\"");
    }
}
