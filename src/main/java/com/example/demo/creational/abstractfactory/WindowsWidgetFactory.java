package com.example.demo.creational.abstractfactory;

public class WindowsWidgetFactory implements WidgetFactory {
    @Override public Button createButton(String label) { throw new UnsupportedOperationException(); }
    @Override public Checkbox createCheckbox()          { throw new UnsupportedOperationException(); }
}
