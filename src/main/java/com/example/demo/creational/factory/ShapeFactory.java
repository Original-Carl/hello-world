package com.example.demo.creational.factory;

public class ShapeFactory {
    public static Shape create(String type) {
        return switch (type.toLowerCase()) {
            case "circle"   -> new Circle(5.0);
            case "square"   -> new Square(4.0);
            case "triangle" -> new Triangle(3.0, 6.0);
            default -> throw new IllegalArgumentException("Unknown shape: " + type);
        };
    }
}
