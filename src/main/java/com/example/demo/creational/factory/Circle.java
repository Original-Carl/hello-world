package com.example.demo.creational.factory;

class Circle implements Shape {
    private final double radius;
    Circle(double radius) { this.radius = radius; }
    @Override public String name() { return "Circle(r=" + radius + ")"; }
    @Override public double area() { return Math.PI * radius * radius; }
}
