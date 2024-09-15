# Optional Class in Java 8
Sometimes we may know based on our business domain knowledge that particular objects
can never be null but every time you doubt that a variable could be null, you’re obliged to add
a further nested if block

## Overview
To handle the challenges with null values, Java 8 introduces java.util.Optional<T>

### Prerequisites

- **Java 8 or later**

## Key Features
- **Safe handling of missing values**
- **Functional approach for chaining transformations**
- **Clearer code with optional patterns instead of null checks**

### Creating an `Optional`
- **`Optional.of(T value)`**: Creates an `Optional` with a non-null value.
    ```java
    Optional<String> optional = Optional.of("Hello"); //if the object inside the of is null you will get nullPointerException
    ```

- **`Optional.ofNullable(T value)`**: Creates an `Optional` that can hold `null`.
    ```java
    Optional<String> optional = Optional.ofNullable(null);
    ```

- **`Optional.empty()`**: Creates an empty `Optional`.
    ```java
    Optional<String> optional = Optional.empty();
    ```

### Accessing and Handling Values
- **`ifPresent(Consumer<? super T> action)`**: Executes the given action if the value is present.
    ```java
    optional.ifPresent(value -> System.out.println(value));
    ```

- **`orElse(T other)`**: Returns the value if present, otherwise returns the provided default value.
    ```java
    String result = optional.orElse("Default Value");
    ```

- **`orElseGet(Supplier<? extends T> other)`**: Lazily provides a default value if the value is not present.
    ```java
    String result = optional.orElseGet(() -> "Default Value");
    ```

- **`orElseThrow()`**: Throws an exception if the value is not present.
    ```java
    String result = optional.orElseThrow(() -> new RuntimeException("No value found"));
    ```

### Functional Transformation with `Optional`
- **`map(Function<? super T, ? extends U> mapper)`**: Transforms the value inside `Optional` if it's present.
    ```java
    Optional<String> optional = Optional.of("Hello");
    Optional<Integer> length = optional.map(String::length);
    ```

- **`flatMap(Function<? super T, Optional<U>> mapper)`**: Similar to `map`, but the transformation returns another `Optional`.
    ```java
    Optional<String> optional = Optional.of("Hello");
    Optional<Integer> length = optional.flatMap(str -> Optional.of(str.length()));
    ```