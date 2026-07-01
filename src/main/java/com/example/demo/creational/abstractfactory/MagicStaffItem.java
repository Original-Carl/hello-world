package com.example.demo.creational.abstractfactory;

class MagicStaffItem implements Item {
    @Override public String name() { return "Staff of Quinctus"; }
    @Override public String describe() { return "An ancient staff crackling with elemental energy"; }
}
