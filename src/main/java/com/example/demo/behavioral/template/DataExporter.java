package com.example.demo.behavioral.template;

import java.util.List;

public abstract class DataExporter {

    public final String export(List<String> rows) {
        StringBuilder sb = new StringBuilder();
        sb.append(header()).append("\n");
        for (String row : rows) sb.append(formatRow(row)).append("\n");
        sb.append(footer());
        return sb.toString();
    }

    protected abstract String header();
    protected abstract String formatRow(String row);
    protected abstract String footer();
}
