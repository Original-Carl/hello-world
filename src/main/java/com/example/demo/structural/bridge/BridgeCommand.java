package com.example.demo.structural.bridge;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class BridgeCommand {

    @ShellMethod(key = "bridge", value = "Bridge pattern (structural)")
    public void run() {
        System.out.println("=== Bridge Pattern ===");
        System.out.println("""
                Decouple an abstraction from its implementation so that both can vary
                independently.

                Without Bridge, combining M abstractions with N implementations leads
                to M×N subclasses. Bridge collapses this into M+N by holding the
                implementation as a field (composition) rather than encoding it in the
                class hierarchy.

                Example: Shape (abstraction) delegates rendering to DrawingAPI (impl);
                you can add Circle or Square without touching SVGDrawingAPI or CanvasAPI.

                [stub — full demo coming]
                """);
    }
}
