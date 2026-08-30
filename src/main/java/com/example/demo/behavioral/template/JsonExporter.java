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
        // Demo-only string interpolation: assumes trusted, well-formed "name,age" input.
        // Real code should build this with a JSON library (escaping, type validation)
        // rather than concatenation.
        String[] fields = row.split(",", 2);
        String name = fields.length > 0 ? fields[0].trim() : "";
        String age = fields.length > 1 ? fields[1].trim() : "";
        // Leading comma (not trailing) since formatRow() sees one row at a time and
        // has no way to know whether the current row is the last one.
        String prefix = firstRow ? "  " : "  , ";
        firstRow = false;
        return prefix + "{\"name\": \"" + name + "\", \"age\": " + age + "}";
    }

    @Override
    protected String footer() { return "]"; }
}
