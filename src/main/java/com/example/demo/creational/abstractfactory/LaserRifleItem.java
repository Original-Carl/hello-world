package com.example.demo.creational.abstractfactory;

class LaserRifleItem implements Item {
    @Override public String name() { return "Plasma Rifle MK-IV"; }
    @Override public String describe() { return "A high-energy weapon that fires concentrated plasma bolts"; }
}
