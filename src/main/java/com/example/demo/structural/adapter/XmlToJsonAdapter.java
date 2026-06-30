package com.example.demo.structural.adapter;

public class XmlToJsonAdapter implements JsonDataSource {
    private final LegacyXmlProvider legacy;

    public XmlToJsonAdapter(LegacyXmlProvider legacy) { this.legacy = legacy; }

    @Override
    public String fetchAsJson(String key) {
        String xml = legacy.getXml(key);
        return xml.replaceAll(
                "<data><key>(.*?)</key><value>(.*?)</value></data>",
                "{\"key\":\"$1\",\"value\":\"$2\"}");
    }
}
