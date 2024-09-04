package com.codechallenge.java21.patternmatching;

public class ShapeUtils {
    private ShapeUtils() {
    }

    public static double calculateArea(Shape shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
            default -> throw new IllegalArgumentException("Unknown shape");
        };
    }
}