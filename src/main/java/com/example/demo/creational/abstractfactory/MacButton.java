package com.example.demo.creational.abstractfactory;

public class MacButton implements Button {
    private final String label;
    public MacButton(String label) { this.label = label; }
    @Override public String click() { throw new UnsupportedOperationException(); }
}
