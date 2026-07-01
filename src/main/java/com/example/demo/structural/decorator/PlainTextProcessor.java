package com.example.demo.structural.decorator;

public class PlainTextProcessor implements TextProcessor {
    @Override
    public String process(String text) { return text; }
}
