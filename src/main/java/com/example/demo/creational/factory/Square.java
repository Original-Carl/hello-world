package com.example.demo.creational.factory;

class Square implements Shape {
    private final double side;
    Square(double side) { this.side = side; }
    @Override public String name() { return "Square(s=" + side + ")"; }
    @Override public double area() { return side * side; }
}
