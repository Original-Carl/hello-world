package com.example.demo.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractFactoryTest {

    @Test
    void windowsFactory_createButton_returnsWindowsButton() {
        WidgetFactory factory = new WindowsWidgetFactory();
        Button button = factory.createButton("OK");
        assertThat(button).isInstanceOf(WindowsButton.class);
    }

    @Test
    void macFactory_createButton_returnsMacButton() {
        WidgetFactory factory = new MacWidgetFactory();
        Button button = factory.createButton("OK");
        assertThat(button).isInstanceOf(MacButton.class);
    }

    @Test
    void windowsFactory_createCheckbox_returnsWindowsCheckbox() {
        WidgetFactory factory = new WindowsWidgetFactory();
        Checkbox checkbox = factory.createCheckbox();
        assertThat(checkbox).isInstanceOf(WindowsCheckbox.class);
    }

    @Test
    void macFactory_createCheckbox_returnsMacCheckbox() {
        WidgetFactory factory = new MacWidgetFactory();
        Checkbox checkbox = factory.createCheckbox();
        assertThat(checkbox).isInstanceOf(MacCheckbox.class);
    }

    @Test
    void windowsFactory_neverReturnsMacWidgets() {
        WidgetFactory factory = new WindowsWidgetFactory();
        assertThat(factory.createButton("X")).isNotInstanceOf(MacButton.class);
        assertThat(factory.createCheckbox()).isNotInstanceOf(MacCheckbox.class);
    }

    @Test
    void swappingFactory_switchesEntireFamily() {
        WidgetFactory win = new WindowsWidgetFactory();
        WidgetFactory mac = new MacWidgetFactory();
        Button winBtn = win.createButton("A");
        Button macBtn = mac.createButton("A");
        assertThat(winBtn.getClass()).isNotEqualTo(macBtn.getClass());
    }
}
