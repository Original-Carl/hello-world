package com.example.demo.behavioral.memento;

public class Counter {
    private int value = 0;

    public int value()            { throw new UnsupportedOperationException(); }
    public void increment()       { throw new UnsupportedOperationException(); }
    public void decrement()       { throw new UnsupportedOperationException(); }
    public CounterMemento save()  { throw new UnsupportedOperationException(); }
    public void restore(CounterMemento m) { throw new UnsupportedOperationException(); }
}
