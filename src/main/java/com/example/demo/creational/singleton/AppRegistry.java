package com.example.demo.creational.singleton;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class AppRegistry {
    private static final AppRegistry INSTANCE = new AppRegistry();
    private final Map<String, String> store = new LinkedHashMap<>();

    private AppRegistry() {
        store.put("version", "1.0.0");
        store.put("environment", "demo");
    }

    public static AppRegistry getInstance() { return INSTANCE; }

    public void put(String key, String value) { store.put(key, value); }
    public String get(String key) { return store.get(key); }
    public Map<String, String> all() { return Collections.unmodifiableMap(store); }
}
