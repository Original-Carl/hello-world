package com.example.demo.structural.decorator;

public class UpperCaseDecorator implements TextProcessor {
    private final TextProcessor delegate;
    public UpperCaseDecorator(TextProcessor delegate) { this.delegate = delegate; }

    @Override
    public String process(String text) { return delegate.process(text).toUpperCase(); }
}
