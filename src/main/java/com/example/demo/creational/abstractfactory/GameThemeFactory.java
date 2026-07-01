package com.example.demo.creational.abstractfactory;

public interface GameThemeFactory {
    Character createCharacter();
    Item createItem();
    Location createLocation();
}
