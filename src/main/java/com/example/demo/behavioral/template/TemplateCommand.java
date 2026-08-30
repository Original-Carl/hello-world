package com.example.demo.behavioral.template;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class TemplateCommand {

    @ShellMethod(key = "template", value = "Template Method pattern (behavioral)")
    public void run() {
        System.out.println("=== Template Method Pattern ===");
        System.out.println("""
                Define the skeleton of an algorithm in an abstract base class, deferring
                some steps to subclasses; subclasses redefine steps without changing the
                algorithm's structure.

                The base class calls abstract "hook" methods at fixed points; concrete
                subclasses fill them in. This is the inversion-of-control principle
                ("don't call us, we'll call you").

                Example: a DataProcessor base class defines read() → process() → write();
                CsvProcessor and JsonProcessor override only the parsing step.
                """);

        List<String> rows = List.of("Alice,30", "Bob,25");

        System.out.println("  Exporting the same rows through CsvExporter.export():");
        System.out.println(new CsvExporter().export(rows).indent(4));

        System.out.println("  Exporting the same rows through JsonExporter.export():");
        System.out.println(new JsonExporter().export(rows).indent(4));

        System.out.println("  Both share DataExporter.export() (final) — only header()/formatRow()/footer() differ.");
    }
}
