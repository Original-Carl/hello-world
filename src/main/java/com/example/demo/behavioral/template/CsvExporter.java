package com.example.demo.behavioral.template;

public class CsvExporter extends DataExporter {
    @Override protected String header()              { return "name,age"; }
    @Override protected String formatRow(String row) { return row; }
    @Override protected String footer()              { return "# end of csv export"; }
}
