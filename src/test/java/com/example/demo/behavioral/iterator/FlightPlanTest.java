package com.example.demo.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FlightPlanTest {

    private static Waypoint wp(int q, int r, String label) {
        return new Waypoint(q, r, label);
    }

    @Test
    void iterator_traversesAllWaypointsInOrder() {
        FlightPlan plan = new FlightPlan();
        plan.add(wp(0, 0, "Starport Kepler"));
        plan.add(wp(3, 0, "Debris Field 7"));
        plan.add(wp(6, -2, "Dock Platform 3"));

        Iterator<Waypoint> it = plan.iterator();
        assertThat(it.next().label()).isEqualTo("Starport Kepler");
        assertThat(it.next().label()).isEqualTo("Debris Field 7");
        assertThat(it.next().label()).isEqualTo("Dock Platform 3");
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void hasNext_trueWhileWaypointsRemain() {
        FlightPlan plan = new FlightPlan();
        plan.add(wp(0, 0, "A"));
        plan.add(wp(1, 0, "B"));
        plan.add(wp(2, 0, "C"));

        Iterator<Waypoint> it = plan.iterator();
        assertThat(it.hasNext()).isTrue(); it.next();
        assertThat(it.hasNext()).isTrue(); it.next();
        assertThat(it.hasNext()).isTrue(); it.next();
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void hasNext_falseWhenExhausted() {
        FlightPlan plan = new FlightPlan();
        plan.add(wp(0, 0, "Solo Stop"));

        Iterator<Waypoint> it = plan.iterator();
        it.next();
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void next_throwsNoSuchElementWhenExhausted() {
        FlightPlan plan = new FlightPlan();
        plan.add(wp(0, 0, "Only Stop"));

        Iterator<Waypoint> it = plan.iterator();
        it.next();
        assertThatThrownBy(it::next).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void twoIterators_onSamePlan_areIndependent() {
        FlightPlan plan = new FlightPlan();
        plan.add(wp(0, 0, "Alpha"));
        plan.add(wp(1, 0, "Beta"));
        plan.add(wp(2, 0, "Gamma"));

        Iterator<Waypoint> itA = plan.iterator();
        Iterator<Waypoint> itB = plan.iterator();

        itA.next(); // advance A to Beta
        itA.next();

        assertThat(itB.next().label()).isEqualTo("Alpha"); // B still at start
    }

    @Test
    void emptyPlan_hasNoWaypoints() {
        assertThat(new FlightPlan().iterator().hasNext()).isFalse();
    }

    @Test
    void singleWaypoint_iteratesOnce() {
        FlightPlan plan = new FlightPlan();
        plan.add(wp(4, -1, "Lone Beacon"));

        Iterator<Waypoint> it = plan.iterator();
        assertThat(it.next().label()).isEqualTo("Lone Beacon");
        assertThat(it.hasNext()).isFalse();
    }
}
