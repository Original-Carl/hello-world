package com.example.demo.creational.abstractfactory;

class EnchantedSwordItem implements Item {
    @Override public String name() { return "Excalibur"; }
    @Override public String describe() { return "A legendary blade imbued with magical runes"; }
}
