package com.example.demo.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlightLog {
    private final Deque<NavSnapshot> log = new ArrayDeque<>();

    public void push(NavSnapshot s) {
        log.push(s);
    }

    public NavSnapshot pop() {
        return log.isEmpty() ? null : log.pop();
    }
}
