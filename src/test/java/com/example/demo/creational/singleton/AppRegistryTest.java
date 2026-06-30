package com.example.demo.creational.singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppRegistryTest {

    @Test
    void getInstance_returnsSameReference() {
        AppRegistry r1 = AppRegistry.getInstance();
        AppRegistry r2 = AppRegistry.getInstance();
        assertSame(r1, r2);
    }

    @Test
    void stateIsShared_acrossReferences() {
        AppRegistry r1 = AppRegistry.getInstance();
        AppRegistry r2 = AppRegistry.getInstance();
        r1.put("singleton-test-key", "shared-value");
        assertThat(r2.get("singleton-test-key")).isEqualTo("shared-value");
    }

    @Test
    void defaultValues_arePresent() {
        AppRegistry reg = AppRegistry.getInstance();
        assertThat(reg.get("version")).isNotNull();
        assertThat(reg.get("environment")).isNotNull();
    }

    @Test
    void all_returnsUnmodifiableView() {
        assertThrows(UnsupportedOperationException.class,
                () -> AppRegistry.getInstance().all().put("x", "y"));
    }

    @Test
    void put_andGet_roundTrip() {
        AppRegistry.getInstance().put("singleton-rt-key", "hello");
        assertThat(AppRegistry.getInstance().get("singleton-rt-key")).isEqualTo("hello");
    }
}
