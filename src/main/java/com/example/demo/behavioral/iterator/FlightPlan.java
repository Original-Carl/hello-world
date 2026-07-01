package com.example.demo.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlightPlan implements Iterable<Waypoint> {
    private final List<Waypoint> waypoints = new ArrayList<>();

    public void add(Waypoint wp) {
        waypoints.add(wp);
    }

    public int size() {
        return waypoints.size();
    }

    @Override
    public Iterator<Waypoint> iterator() {
        return new FlightPlanIterator(List.copyOf(waypoints));
    }
}
