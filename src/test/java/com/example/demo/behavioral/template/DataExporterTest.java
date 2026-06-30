package com.example.demo.behavioral.template;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DataExporterTest {

    private static final List<String> ROWS = List.of("Alice,30", "Bob,25");

    @Test
    void csvExporter_header_isFirstLine() {
        String output = new CsvExporter().export(ROWS);
        String firstLine = output.lines().findFirst().orElse("");
        assertThat(firstLine).isNotEmpty();
    }

    @Test
    void csvExporter_rows_areCommaSeparated() {
        String output = new CsvExporter().export(ROWS);
        assertThat(output).contains("Alice").contains("Bob");
    }

    @Test
    void csvExporter_footer_isLastLine() {
        String output = new CsvExporter().export(ROWS);
        assertThat(output.strip()).isNotEmpty();
        String lastLine = output.strip().lines().reduce((a, b) -> b).orElse("");
        assertThat(lastLine).isNotEmpty();
    }

    @Test
    void jsonExporter_output_isValidJsonStructure() {
        String output = new JsonExporter().export(ROWS);
        assertThat(output).contains("[").contains("]");
    }

    @Test
    void jsonExporter_containsAllInputRows() {
        String output = new JsonExporter().export(ROWS);
        assertThat(output).contains("Alice").contains("Bob");
    }

    @Test
    void export_callsHooksInOrder() {
        List<String> callOrder = new java.util.ArrayList<>();
        DataExporter spy = new DataExporter() {
            @Override protected String header()              { callOrder.add("header"); return "H"; }
            @Override protected String formatRow(String row){ callOrder.add("row"); return row; }
            @Override protected String footer()             { callOrder.add("footer"); return "F"; }
        };
        spy.export(List.of("r1", "r2"));
        assertThat(callOrder).startsWith("header").endsWith("footer");
        assertThat(callOrder.indexOf("header")).isLessThan(callOrder.indexOf("footer"));
    }

    @Test
    void sameData_differentExporter_differentFormat() {
        String csv  = new CsvExporter().export(ROWS);
        String json = new JsonExporter().export(ROWS);
        assertThat(csv).isNotEqualTo(json);
    }

    @Test
    void export_isFinal() throws NoSuchMethodException {
        int mods = DataExporter.class.getMethod("export", List.class).getModifiers();
        assertThat(Modifier.isFinal(mods)).isTrue();
    }
}
