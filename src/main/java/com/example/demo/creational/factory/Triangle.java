package com.example.demo.creational.factory;

class Triangle implements Shape {
    private final double base, height;
    Triangle(double base, double height) { this.base = base; this.height = height; }
    @Override public String name() { return "Triangle(b=" + base + ",h=" + height + ")"; }
    @Override public double area() { return 0.5 * base * height; }
}
