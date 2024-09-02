package com.codechallenge.java21.recordpattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApiResponseProcessorTest {

    private final ApiResponseProcessor processor = new ApiResponseProcessor();

    @Test
    void testProcessUserResponse() {
        ApiResponseProcessor.User user = new ApiResponseProcessor.User("Alice", 30);
        String result = processor.processResponse(user);
        assertEquals("User: Alice, Age: 30", result);
    }

    @Test
    void testProcessOrderResponse() {
        ApiResponseProcessor.Order order = new ApiResponseProcessor.Order("12345", 99.99);
        String result = processor.processResponse(order);
        assertEquals("Order ID: 12345, Amount: 99.99", result);
    }

    @Test
    void testProcessProductResponse() {
        ApiResponseProcessor.Product product = new ApiResponseProcessor.Product("P123", "Laptop");
        String result = processor.processResponse(product);
        assertEquals("Product: Laptop, Product ID: P123", result);
    }

    @Test
    void testProcessUnknownResponse() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> processor.processResponse("Unknown")
        );
        assertEquals("Unknown response type", exception.getMessage());
    }
}
