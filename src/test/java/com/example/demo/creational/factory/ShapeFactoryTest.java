package com.example.demo.creational.factory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeFactoryTest {

    @Test
    void circle_hasCorrectNameAndArea() {
        Shape s = ShapeFactory.create("circle");
        assertThat(s.name()).isEqualTo("Circle(r=5.0)");
        assertThat(s.area()).isCloseTo(Math.PI * 25, within(1e-9));
    }

    @Test
    void square_hasCorrectNameAndArea() {
        Shape s = ShapeFactory.create("square");
        assertThat(s.name()).isEqualTo("Square(s=4.0)");
        assertThat(s.area()).isEqualTo(16.0);
    }

    @Test
    void triangle_hasCorrectNameAndArea() {
        Shape s = ShapeFactory.create("triangle");
        assertThat(s.name()).isEqualTo("Triangle(b=3.0,h=6.0)");
        assertThat(s.area()).isEqualTo(9.0);
    }

    @Test
    void caseInsensitive_uppercase() {
        assertThatNoException().isThrownBy(() -> ShapeFactory.create("CIRCLE"));
        assertThatNoException().isThrownBy(() -> ShapeFactory.create("SQUARE"));
        assertThatNoException().isThrownBy(() -> ShapeFactory.create("TRIANGLE"));
    }

    @Test
    void unknownType_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.create("hexagon"));
    }
}
