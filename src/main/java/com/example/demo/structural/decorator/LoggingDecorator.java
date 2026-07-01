package com.example.demo.structural.decorator;

public class LoggingDecorator implements TextProcessor {
    private final TextProcessor delegate;
    public LoggingDecorator(TextProcessor delegate) { this.delegate = delegate; }

    @Override
    public String process(String text) {
        String result = delegate.process(text);
        System.out.println("    [LOG] \"" + text + "\" → \"" + result + "\"");
        return result;
    }
}
