package com.example.demo.behavioral.state;

public class HasCoinState implements VendingState {
    @Override public String insert(VendingMachine m)   { throw new UnsupportedOperationException(); }
    @Override public String eject(VendingMachine m)    { throw new UnsupportedOperationException(); }
    @Override public String dispense(VendingMachine m) { throw new UnsupportedOperationException(); }
}
