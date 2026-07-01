package com.example.demo.creational.abstractfactory;

class PistolItem implements Item {
    @Override public String name() { return "Glock 17"; }
    @Override public String describe() { return "A reliable semi-automatic sidearm"; }
}
