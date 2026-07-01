package com.example.demo.structural.flyweight;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class FlyweightCommand {

    @ShellMethod(key = "flyweight", value = "Flyweight pattern (structural)")
    public void run() {
        System.out.println("=== Flyweight Pattern ===");
        System.out.println("""
                Use sharing to efficiently support a large number of fine-grained objects
                by separating intrinsic (shared, immutable) state from extrinsic (per-instance)
                state.

                A FlyweightFactory caches and reuses shared instances; callers pass
                extrinsic state on each method call rather than storing it in the object.

                Example: a text editor representing each character as a Flyweight
                (glyph type + font = intrinsic), with position stored externally per use.

                [stub — full demo coming]
                """);
    }
}
