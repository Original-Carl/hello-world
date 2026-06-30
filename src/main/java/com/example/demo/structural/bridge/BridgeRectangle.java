package com.example.demo.structural.bridge;

public class BridgeRectangle extends BridgeShape {
    private final double x, y, w, h;
    public BridgeRectangle(double x, double y, double w, double h, DrawingAPI api) { super(api); this.x = x; this.y = y; this.w = w; this.h = h; }
    @Override public String draw() { throw new UnsupportedOperationException(); }
}
