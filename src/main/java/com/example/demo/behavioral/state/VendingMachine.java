package com.example.demo.behavioral.state;

public class VendingMachine {
    private VendingState state;
    private int stock;

    public VendingMachine(int stock) {
        this.stock = stock;
        this.state = new IdleState();
    }

    public String insert()   { return state.insert(this); }
    public String eject()    { return state.eject(this); }
    public String dispense() { return state.dispense(this); }

    public VendingState getState()          { return state; }
    public void setState(VendingState s)    { this.state = s; }
    public int getStock()                   { return stock; }
    public void setStock(int stock)         { this.stock = stock; }
}
