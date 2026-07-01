package com.example.demo.behavioral.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class FlightPlanIterator implements Iterator<Waypoint> {
    private final List<Waypoint> waypoints;
    private int index = 0;

    FlightPlanIterator(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public boolean hasNext() {
        return index < waypoints.size();
    }

    @Override
    public Waypoint next() {
        if (!hasNext()) throw new NoSuchElementException();
        return waypoints.get(index++);
    }
}
