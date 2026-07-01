package com.example.demo.creational.abstractfactory;

public class FantasyThemeFactory implements GameThemeFactory {
    @Override public Character createCharacter() { return new WizardCharacter(); }
    @Override public Item createItem() { return new MagicStaffItem(); }
    @Override public Location createLocation() { return new EnchantedForestLocation(); }
}
