package com.example.demo.behavioral.memento;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class StarshipNavTest {

    @Test
    void save_andRestore_revertsPosition() {
        Starship ship = new Starship(0, 0, 2, "E");
        NavSnapshot snap = ship.save();
        ship.move();
        ship.restore(snap);
        assertThat(ship.q()).isEqualTo(0);
        assertThat(ship.r()).isEqualTo(0);
    }

    @Test
    void save_andRestore_revertsSpeed() {
        Starship ship = new Starship(0, 0, 2, "E");
        NavSnapshot snap = ship.save();
        ship.setSpeed(5);
        ship.restore(snap);
        assertThat(ship.speed()).isEqualTo(2);
    }

    @Test
    void save_andRestore_revertsDirection() {
        Starship ship = new Starship(0, 0, 2, "E");
        NavSnapshot snap = ship.save();
        ship.setDirection("NW");
        ship.restore(snap);
        assertThat(ship.direction()).isEqualTo("E");
    }

    @Test
    void save_andRestore_revertsAllFields() {
        Starship ship = new Starship(3, -1, 2, "NE");
        NavSnapshot snap = ship.save();
        ship.setSpeed(5);
        ship.setDirection("SW");
        ship.move();
        ship.restore(snap);
        assertThat(ship.q()).isEqualTo(3);
        assertThat(ship.r()).isEqualTo(-1);
        assertThat(ship.speed()).isEqualTo(2);
        assertThat(ship.direction()).isEqualTo("NE");
    }

    @Test
    void move_advancesPositionBySpeedAndDirection() {
        Starship ship = new Starship(0, 0, 3, "E");
        ship.move();
        assertThat(ship.q()).isEqualTo(3);
        assertThat(ship.r()).isEqualTo(0);

        Starship ship2 = new Starship(0, 0, 2, "NE");
        ship2.move();
        assertThat(ship2.q()).isEqualTo(2);
        assertThat(ship2.r()).isEqualTo(-2);
    }

    @Test
    void multipleSnapshots_undoInReverseOrder() {
        Starship ship = new Starship(0, 0, 1, "E");
        FlightLog log = new FlightLog();

        log.push(ship.save());  // snap at (0,0)
        ship.move();
        log.push(ship.save());  // snap at (1,0)
        ship.move();            // ship now at (2,0)

        ship.restore(log.pop());
        assertThat(ship.q()).isEqualTo(1);

        ship.restore(log.pop());
        assertThat(ship.q()).isEqualTo(0);
    }

    @Test
    void flightLog_pop_onEmpty_returnsNull() {
        assertThat(new FlightLog().pop()).isNull();
    }

    @Test
    void snapshot_hasNoPublicMethods() {
        long publicMethods = java.util.Arrays.stream(NavSnapshot.class.getMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers())
                        && m.getDeclaringClass() != Object.class)
                .count();
        assertThat(publicMethods).isZero();
    }
}
