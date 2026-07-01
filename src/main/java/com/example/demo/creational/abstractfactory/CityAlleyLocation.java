package com.example.demo.creational.abstractfactory;

class CityAlleyLocation implements Location {
    @Override public String name() { return "Downtown Alley"; }
    @Override public String describe() { return "A grimy urban passage beneath flickering neon lights"; }
}
