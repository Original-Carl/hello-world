package com.example.demo.structural.decorator;

public class TrimDecorator implements TextProcessor {
    private final TextProcessor delegate;
    public TrimDecorator(TextProcessor delegate) { this.delegate = delegate; }

    @Override
    public String process(String text) { return delegate.process(text).trim(); }
}
