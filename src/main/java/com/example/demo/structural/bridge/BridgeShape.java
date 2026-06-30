package com.example.demo.structural.bridge;

public abstract class BridgeShape {
    protected DrawingAPI api;
    public BridgeShape(DrawingAPI api) { this.api = api; }
    public void setApi(DrawingAPI api) { this.api = api; }
    public abstract String draw();
}
