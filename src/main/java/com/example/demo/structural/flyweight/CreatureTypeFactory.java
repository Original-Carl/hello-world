package com.example.demo.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CreatureTypeFactory {
    private final Map<String, CreatureType> cache = new HashMap<>();

    public CreatureType getType(String species, int baseHealth, int attackPower, String sprite) {
        String key = species + "|" + baseHealth + "|" + attackPower + "|" + sprite;
        return cache.computeIfAbsent(key, k -> new CreatureType(species, baseHealth, attackPower, sprite));
    }

    public int cachedCount() { return cache.size(); }
}
