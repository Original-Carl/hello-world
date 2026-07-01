package com.example.demo.behavioral.state;

public interface VendingState {
    String insert(VendingMachine m);
    String eject(VendingMachine m);
    String dispense(VendingMachine m);
}
