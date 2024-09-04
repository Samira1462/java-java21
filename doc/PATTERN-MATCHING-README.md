# Pattern Matching in Java 21

## Overview
Java 21 enhances the language with advanced Pattern Matching capabilities, particularly in `switch` statements. These improvements allow for more concise and readable code by simplifying type checks, deconstructing objects, and making the control flow more intuitive.

## Key Features

- **Type Matching in `switch`**: Simplifies the control flow by matching the type of objects directly within `switch` cases.
- **Constant Matching**: Matches specific constant values in a concise manner.
- **Null Handling**: Allows explicit handling of `null` within `switch` cases.
- **Deconstruction Patterns**: Deconstructs record types directly within `switch` statements for more detailed pattern matching.

## Rules to Remember
1. Exhaustiveness: The switch must cover all possible cases or include a default branch.
2. Null Handling: You must handle null explicitly, either in a case or using default.
3. Type Safety: The patterns must be type-safe. If a pattern can never match (e.g., an impossible cast), the compiler will warn or error.
## Getting Started

### Prerequisites

- **Java 21**

### Syntax Overview
The basic idea is that you can match a value against several patterns within a switch statement.
### Example Usage
```
   switch (expression) {
       case Pattern1 -> {
           // Code block for Pattern1
       }
       case Pattern2 -> {
           // Code block for Pattern2
       }
       case Pattern3 -> {
           // Code block for Pattern3
       }
       default -> {
           // Code block if no pattern matches
       }
   }
```
Below are some examples demonstrating how to use Pattern Matching in Java 21.

#### 1. Type Matching

```
public class TypeMatchingExample {
    public static String formatObject(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer: " + i;
            case Long l -> "Long: " + l;
            case Double d -> "Double: " + d;
            case String s -> "String: " + s;
            default -> "Unknown type";
        };
    }

    public static void main(String[] args) {
        System.out.println(formatObject(10));        // Output: Integer: 10
        System.out.println(formatObject(10L));       // Output: Long: 10
        System.out.println(formatObject(10.5));      // Output: Double: 10.50
        System.out.println(formatObject("Hello"));   // Output: String: Hello
    }
}

```
#### 2. Constant Matching

```
public static String dayType(String day) {
    return switch (day) {
        case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
        case "Saturday", "Sunday" -> "Weekend";
        default -> "Invalid day";
    };
}

public static void main(String[] args) {
    System.out.println(dayType("Monday"));  // Output: Weekday
    System.out.println(dayType("Sunday"));  // Output: Weekend
    System.out.println(dayType("Funday"));  // Output: Invalid day
}

```

#### 3. Null Handling

```
public static String checkNull(Object obj) {
    return switch (obj) {
        case null -> "Null value";
        case String s -> String.format("String: %s", s);
        default -> "Some object";
    };
}

public static void main(String[] args) {
    System.out.println(checkNull(null));      // Output: Null value
    System.out.println(checkNull("Hello"));   // Output: String: Hello
    System.out.println(checkNull(123));       // Output: Some object
}
```

#### 4. Deconstruction Patterns
```
record Point(int x, int y) {}

public static String formatPoint(Point p) {
    return switch (p) {
        case Point(int x, int y) -> String.format("Point(%d, %d)", x, y);
        default -> "Unknown object";
    };
}

public static void main(String[] args) {
    System.out.println(formatPoint(new Point(1, 2))); // Output: Point(1, 2)
    System.out.println(formatPoint(null));            // Output: Unknown object
}
```