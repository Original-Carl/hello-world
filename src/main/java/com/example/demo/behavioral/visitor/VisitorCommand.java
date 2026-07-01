package com.example.demo.behavioral.visitor;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class VisitorCommand {

    @ShellMethod(key = "visitor", value = "Visitor pattern (behavioral)")
    public void run() {
        System.out.println("=== Visitor Pattern ===");
        System.out.println("""
                Represent an operation to be performed on elements of an object structure;
                Visitor lets you define a new operation without changing the classes of
                the elements it operates on.

                Double dispatch: each element calls visitor.visit(this), and the correct
                overload is selected based on both the visitor type and the element type.

                Example: an AST (abstract syntax tree) with NumberNode, AddNode, MulNode —
                a PrintVisitor, EvalVisitor, and TypeCheckVisitor each traverse the same
                nodes without modifying the AST classes.

                [stub — full demo coming]
                """);
    }
}
