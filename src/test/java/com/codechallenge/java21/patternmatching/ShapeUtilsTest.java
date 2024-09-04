package com.codechallenge.java21.patternmatching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShapeUtilsTest {

    @Test
    void calculateArea_Circle() {
        var circle = new Circle(5);
        double area = ShapeUtils.calculateArea(circle);
        assertEquals(78.53981633974483, area, 1e-9);
    }

    @Test
    void calculateArea_Rectangle() {
        var rectangle = new Rectangle(4, 6);
        double area = ShapeUtils.calculateArea(rectangle);
        assertEquals(24.0, area, 1e-9);
    }

    @Test
    void calculateArea_UnknownShape() {
        Shape unknownShape = new Shape() {};
        try {
            ShapeUtils.calculateArea(unknownShape);
        } catch (IllegalArgumentException e) {
            assertEquals("Unknown shape", e.getMessage());
        }
    }
}
