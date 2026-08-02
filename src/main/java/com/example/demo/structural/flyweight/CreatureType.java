package com.example.demo.structural.flyweight;

public class CreatureType {
    private final String species;
    private final int baseHealth;
    private final int attackPower;
    private final String sprite;

    CreatureType(String species, int baseHealth, int attackPower, String sprite) {
        this.species = species;
        this.baseHealth = baseHealth;
        this.attackPower = attackPower;
        this.sprite = sprite;
    }

    public String species()    { return species; }
    public int baseHealth()    { return baseHealth; }
    public int attackPower()   { return attackPower; }

    public String render(String unitName, int x, int y, int currentHealth) {
        return String.format("%-8s %-18s %-20s at (%2d,%2d)  HP %3d/%-3d  ATK %d",
                sprite, unitName, "(" + species + ")", x, y, currentHealth, baseHealth, attackPower);
    }
}
