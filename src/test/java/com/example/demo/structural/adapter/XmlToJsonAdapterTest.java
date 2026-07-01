package com.example.demo.structural.adapter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class XmlToJsonAdapterTest {

    private final LegacyXmlProvider legacy = new LegacyXmlProvider();
    private final JsonDataSource adapter = new XmlToJsonAdapter(legacy);

    @Test
    void legacyProvider_returnsXml() {
        String xml = legacy.getXml("price");
        assertThat(xml).isEqualTo("<data><key>price</key><value>42</value></data>");
    }

    @Test
    void adapter_transformsXmlToJson() {
        String json = adapter.fetchAsJson("price");
        assertThat(json).isEqualTo("{\"key\":\"price\",\"value\":\"42\"}");
    }

    @Test
    void adapter_worksForAnyKey() {
        String json = adapter.fetchAsJson("quantity");
        assertThat(json).contains("\"key\":\"quantity\"");
        assertThat(json).contains("\"value\":\"42\"");
    }

    @Test
    void adapter_implementsJsonDataSource() {
        assertThat(adapter).isInstanceOf(JsonDataSource.class);
    }
}
