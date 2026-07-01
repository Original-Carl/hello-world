package com.example.demo.structural.adapter;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class AdapterCommand {

    @ShellMethod(key = "adapter", value = "Adapter pattern (structural)")
    public void run() {
        System.out.println("=== Adapter Pattern ===");
        System.out.println("Convert an interface into one clients expect;\n" +
                           "lets incompatible interfaces work together.\n");

        LegacyXmlProvider legacy = new LegacyXmlProvider();
        System.out.println("  [LegacyXmlProvider]  getXml(\"price\")    → " + legacy.getXml("price"));

        JsonDataSource adapted = new XmlToJsonAdapter(legacy);
        System.out.println("  [XmlToJsonAdapter]   fetchAsJson(\"price\") → " + adapted.fetchAsJson("price"));
        System.out.println("\nClient only sees JsonDataSource; the legacy class is unchanged.");
    }
}
