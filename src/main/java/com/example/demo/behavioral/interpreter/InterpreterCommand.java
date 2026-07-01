package com.example.demo.behavioral.interpreter;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class InterpreterCommand {

    @ShellMethod(key = "interpreter", value = "Interpreter pattern (behavioral)")
    public void run() {
        System.out.println("=== Interpreter Pattern ===");
        System.out.println("""
                Given a language, define a representation for its grammar along with an
                interpreter that uses the representation to interpret sentences in the language.

                Each grammar rule maps to a class; a sentence is an object tree that is
                evaluated by calling interpret() recursively.

                Example: a simple boolean expression language —
                  And(Or(Var("x"), Lit(true)), Not(Var("y")))
                is evaluated against a context {x=false, y=false} → true.

                Rarely the best tool for complex grammars (use a parser generator instead),
                but clean for small, stable DSLs like search filters or rule engines.

                [stub — full demo coming]
                """);
    }
}
