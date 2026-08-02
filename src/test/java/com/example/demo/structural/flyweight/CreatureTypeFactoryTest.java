package com.example.demo.structural.flyweight;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreatureTypeFactoryTest {

    @Test
    void sameIntrinsicState_returnsSameInstance() {
        CreatureTypeFactory factory = new CreatureTypeFactory();
        CreatureType t1 = factory.getType("Xenomorph Scout", 80, 12, "[SCOUT]");
        CreatureType t2 = factory.getType("Xenomorph Scout", 80, 12, "[SCOUT]");
        assertThat(t1).isSameAs(t2);
    }

    @Test
    void differentSpecies_returnsDifferentInstance() {
        CreatureTypeFactory factory = new CreatureTypeFactory();
        CreatureType t1 = factory.getType("Xenomorph Scout", 80, 12, "[SCOUT]");
        CreatureType t2 = factory.getType("Plasma Drone",    80, 12, "[SCOUT]");
        assertThat(t1).isNotSameAs(t2);
    }

    @Test
    void differentBaseHealth_returnsDifferentInstance() {
        CreatureTypeFactory factory = new CreatureTypeFactory();
        CreatureType t1 = factory.getType("Xenomorph Scout",  80, 12, "[SCOUT]");
        CreatureType t2 = factory.getType("Xenomorph Scout", 100, 12, "[SCOUT]");
        assertThat(t1).isNotSameAs(t2);
    }

    @Test
    void cachedCount_doesNotGrowOnRepeatRequests() {
        CreatureTypeFactory factory = new CreatureTypeFactory();
        factory.getType("Void Wraith", 120, 8, "[WRAITH]");
        factory.getType("Void Wraith", 120, 8, "[WRAITH]");
        factory.getType("Void Wraith", 120, 8, "[WRAITH]");
        assertThat(factory.cachedCount()).isEqualTo(1);
    }

    @Test
    void render_includesExtrinsicState() {
        CreatureTypeFactory factory = new CreatureTypeFactory();
        CreatureType t = factory.getType("Plasma Drone", 50, 20, "[DRONE]");
        String rendered = t.render("Drone-Alpha", 10, 20, 35);
        assertThat(rendered).contains("Drone-Alpha").contains("10").contains("20").contains("35");
    }

    @Test
    void manyRenders_fewCachedInstances() {
        CreatureTypeFactory factory = new CreatureTypeFactory();
        String[] species = { "Xenomorph Scout", "Plasma Drone", "Void Wraith" };
        String[] sprites = { "[SCOUT]",         "[DRONE]",      "[WRAITH]"   };
        for (int i = 0; i < 100; i++) {
            int idx = i % 3;
            factory.getType(species[idx], 80, 12, sprites[idx]).render("Unit-" + i, i, i, 50);
        }
        assertThat(factory.cachedCount()).isEqualTo(3);
    }
}
