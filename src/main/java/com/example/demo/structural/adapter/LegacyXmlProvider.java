package com.example.demo.structural.adapter;

public class LegacyXmlProvider {
    public String getXml(String key) {
        return "<data><key>" + key + "</key><value>42</value></data>";
    }
}
