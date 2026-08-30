package com.example.demo.behavioral.template;

public class JsonExporter extends DataExporter {

    private boolean firstRow = true;

    @Override
    protected String header() {
        firstRow = true;
        return "[";
    }

    @Override
    protected String formatRow(String row) {
        String[] fields = row.split(",", 2);
        String name = fields.length > 0 ? fields[0].trim() : "";
        String age = fields.length > 1 ? fields[1].trim() : "";
        String prefix = firstRow ? "  " : "  , ";
        firstRow = false;
        return prefix + "{\"name\": \"" + name + "\", \"age\": " + age + "}";
    }

    @Override
    protected String footer() { return "]"; }
}
