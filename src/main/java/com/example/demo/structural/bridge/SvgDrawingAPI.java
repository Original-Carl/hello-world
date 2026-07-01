package com.example.demo.structural.bridge;

public class SvgDrawingAPI implements DrawingAPI {
    @Override public String drawCircle(double x, double y, double r)           { throw new UnsupportedOperationException(); }
    @Override public String drawRectangle(double x, double y, double w, double h) { throw new UnsupportedOperationException(); }
}
