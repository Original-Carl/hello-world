package com.example.demo.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class EnemyPrototypeRegistry {
    private final Map<String, Enemy> registry = new HashMap<>();

    public void register(String key, Enemy prototype) {
        registry.put(key, prototype);
    }

    public Enemy getClone(String key) {
        Enemy prototype = registry.get(key);
        if (prototype == null) throw new IllegalArgumentException("Unknown prototype key: " + key);
        return prototype.clone();
    }
}
