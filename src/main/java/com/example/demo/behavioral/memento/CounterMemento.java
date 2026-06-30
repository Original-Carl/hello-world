package com.example.demo.behavioral.memento;

public class CounterMemento {
    CounterMemento(int value) {
        // package-private: only Counter may create mementos
        this.savedValue = value;
    }
    final int savedValue;  // package-private field; no public getter by design
}
