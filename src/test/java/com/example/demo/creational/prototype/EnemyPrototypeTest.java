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
}
