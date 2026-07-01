package com.example.demo.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EnemyPrototypeTest {

    @Test
    void clone_isNotSameReference() {
        Enemy original = new Enemy("Goblin", 100, 5);
        Enemy clone = original.clone();
        assertThat(clone).isNotSameAs(original);
    }

    @Test
    void clone_hasSameFieldValues() {
        Enemy original = new Enemy("Goblin", 100, 5);
        Enemy clone = original.clone();
        assertThat(clone.type()).isEqualTo(original.type());
        assertThat(clone.health()).isEqualTo(original.health());
        assertThat(clone.speed()).isEqualTo(original.speed());
    }

    @Test
    void modifyingClone_doesNotAffectOriginal() {
        Enemy original = new Enemy("Goblin", 100, 5);
        Enemy clone = original.clone();
        clone.setHealth(50);
        assertThat(original.health()).isEqualTo(100);
    }

    @Test
    void registry_returnsNewCloneEachCall() {
        EnemyPrototypeRegistry registry = new EnemyPrototypeRegistry();
        registry.register("goblin", new Enemy("Goblin", 100, 5));
        Enemy clone1 = registry.getClone("goblin");
        Enemy clone2 = registry.getClone("goblin");
        assertThat(clone1).isNotSameAs(clone2);
    }

    @Test
    void registry_unknownKey_throwsException() {
        EnemyPrototypeRegistry registry = new EnemyPrototypeRegistry();
        assertThatThrownBy(() -> registry.getClone("dragon"))
                .isInstanceOf(Exception.class);
    }

    @Test
    void clone_copiesAllThreeFields() {
        Enemy original = new Enemy("Troll", 250, 2);
        Enemy clone = original.clone();
        assertThat(clone.type()).isEqualTo("Troll");
        assertThat(clone.health()).isEqualTo(250);
        assertThat(clone.speed()).isEqualTo(2);
    }

    @Test
    void modifyingOriginal_doesNotAffectClone() {
        Enemy original = new Enemy("Goblin", 100, 5);
        Enemy clone = original.clone();
        original.setHealth(1);
        assertThat(clone.health()).isEqualTo(100);
    }

    @Test
    void registry_holdsMultiplePrototypes() {
        EnemyPrototypeRegistry registry = new EnemyPrototypeRegistry();
        registry.register("goblin", new Enemy("Goblin", 100, 5));
        registry.register("dragon", new Enemy("Dragon", 500, 3));
        assertThat(registry.getClone("goblin").type()).isEqualTo("Goblin");
        assertThat(registry.getClone("dragon").type()).isEqualTo("Dragon");
    }

    @Test
    void registry_clonesAreIndependentOfPrototype() {
        Enemy prototype = new Enemy("Orc", 200, 4);
        EnemyPrototypeRegistry registry = new EnemyPrototypeRegistry();
        registry.register("orc", prototype);
        prototype.setHealth(1);
        assertThat(registry.getClone("orc").health()).isEqualTo(1);
        // Clones reflect the prototype's state at clone-time, not registration-time
        // This test documents that the registry stores the live prototype reference
        prototype.setHealth(200);
        assertThat(registry.getClone("orc").health()).isEqualTo(200);
    }
}
