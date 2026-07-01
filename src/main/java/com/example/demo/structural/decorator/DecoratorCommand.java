package com.example.demo.structural.decorator;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DecoratorCommand {

    @ShellMethod(key = "decorator", value = "Decorator pattern (structural)")
    public void run() {
        System.out.println("=== Decorator Pattern ===");
        System.out.println("Attach additional responsibilities to an object dynamically;\n" +
                           "decorators provide a flexible alternative to subclassing.\n");

        String input = "  hello, world  ";
        System.out.println("  Input  : \"" + input + "\"");
        System.out.println("  Chain  : Logging → UpperCase → Trim → Plain\n");

        TextProcessor chain = new LoggingDecorator(
                                  new UpperCaseDecorator(
                                      new TrimDecorator(
                                          new PlainTextProcessor())));

        String result = chain.process(input);
        System.out.println("\n  Result : \"" + result + "\"");
    }
}
