package com.codechallenge.java21.recordpattern;

public class ApiResponseProcessor {

    public record User(String name, int age) {}
    public record Order(String orderId, double amount) {}
    public record Product(String productId, String name) {}

    // Method to process the response
    public String processResponse(Object response) {
        return switch (response) {
            case User(String name, int age) -> "User: " + name + ", Age: " + age;
            case Order(String orderId, double amount) -> "Order ID: " + orderId + ", Amount: " + amount;
            case Product(String productId, String name) -> "Product: " + name + ", Product ID: " + productId;
            default -> throw new IllegalArgumentException("Unknown response type");
        };
    }
}
