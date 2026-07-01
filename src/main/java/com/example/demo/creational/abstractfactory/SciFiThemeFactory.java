package com.example.demo.creational.abstractfactory;

public class SciFiThemeFactory implements GameThemeFactory {
    @Override public Character createCharacter() { return new CyborgCharacter(); }
    @Override public Item createItem() { return new LaserRifleItem(); }
    @Override public Location createLocation() { return new SpaceStationLocation(); }
}
