package com.example.demo.creational.builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PizzaBuilderTest {

    @Test
    void defaults_areApplied() {
        Pizza p = new PizzaBuilder().build();
        assertThat(p.size()).isEqualTo("medium");
        assertThat(p.crust()).isEqualTo("thin");
        assertThat(p.toppings()).isEmpty();
        assertThat(p.extraCheese()).isFalse();
    }

    @Test
    void fluentChain_setsAllFields() {
        Pizza p = new PizzaBuilder()
                .size("large").crust("thick")
                .topping("pepperoni").topping("mushrooms")
                .extraCheese()
                .build();
        assertThat(p.size()).isEqualTo("large");
        assertThat(p.crust()).isEqualTo("thick");
        assertThat(p.toppings()).containsExactly("pepperoni", "mushrooms");
        assertThat(p.extraCheese()).isTrue();
    }

    @Test
    void multipleToppings_areAccumulated() {
        Pizza p = new PizzaBuilder()
                .topping("a").topping("b").topping("c")
                .build();
        assertThat(p.toppings()).hasSize(3).containsExactly("a", "b", "c");
    }

    @Test
    void toppings_listIsUnmodifiable() {
        Pizza p = new PizzaBuilder().topping("basil").build();
        assertThrows(UnsupportedOperationException.class, () -> p.toppings().add("extra"));
    }

    @Test
    void toString_includesAllFields() {
        Pizza p = new PizzaBuilder().size("small").crust("gluten-free").topping("basil").build();
        String s = p.toString();
        assertThat(s).contains("small", "gluten-free", "basil");
    }

    @Test
    void builderIsReusable_producesIndependentPizzas() {
        PizzaBuilder builder = new PizzaBuilder().size("large");
        Pizza p1 = builder.topping("pepperoni").build();
        Pizza p2 = new PizzaBuilder().size("small").build();
        assertThat(p1.size()).isEqualTo("large");
        assertThat(p2.size()).isEqualTo("small");
    }
}
