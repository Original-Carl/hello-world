package com.example.demo.creational.abstractfactory;

public class ModernThemeFactory implements GameThemeFactory {
    @Override public Character createCharacter() { return new DetectiveCharacter(); }
    @Override public Item createItem() { return new SmartPhoneItem(); }
    @Override public Location createLocation() { return new CityAlleyLocation(); }
}
