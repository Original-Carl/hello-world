package com.example.demo.creational.abstractfactory;

class SpaceStationLocation implements Location {
    @Override public String name() { return "Orbital Station Alpha"; }
    @Override public String describe() { return "A gleaming outpost orbiting a distant moon"; }
}
