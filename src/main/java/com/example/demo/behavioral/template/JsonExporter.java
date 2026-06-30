package com.example.demo.behavioral.template;

public class JsonExporter extends DataExporter {
    @Override protected String header()              { throw new UnsupportedOperationException(); }
    @Override protected String formatRow(String row) { throw new UnsupportedOperationException(); }
    @Override protected String footer()              { throw new UnsupportedOperationException(); }
}
