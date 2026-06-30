package com.example.demo.structural.bridge;

public class BridgeCircle extends BridgeShape {
    private final double x, y, r;
    public BridgeCircle(double x, double y, double r, DrawingAPI api) { super(api); this.x = x; this.y = y; this.r = r; }
    @Override public String draw() { throw new UnsupportedOperationException(); }
}
