package com.example.demo.creational.abstractfactory;

public class WindowsButton implements Button {
    private final String label;
    public WindowsButton(String label) { this.label = label; }
    @Override public String click() { throw new UnsupportedOperationException(); }
}
