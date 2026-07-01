package com.example.demo.creational.abstractfactory;

class SmartPhoneItem implements Item {
    @Override public String name() { return "Doom Rectangle"; }
    @Override public String describe() { return "A glowing slab of glass that knows everything"; }
}
