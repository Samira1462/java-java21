package com.codechallenge.java21.recordpatterns;

public class RecordPatterns {
    public record Circle(Point center, int radius) {}
    public record Point(int x, int y) {}
}
