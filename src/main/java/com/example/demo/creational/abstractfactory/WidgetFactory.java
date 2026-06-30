package com.example.demo.creational.abstractfactory;

public interface WidgetFactory {
    Button createButton(String label);
    Checkbox createCheckbox();
}
