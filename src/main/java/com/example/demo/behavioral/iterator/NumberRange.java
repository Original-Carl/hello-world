package com.example.demo.behavioral.iterator;

import java.util.Iterator;

public class NumberRange implements Iterable<Integer> {
    private final int start;
    private final int end;

    public NumberRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() { throw new UnsupportedOperationException(); }
}
