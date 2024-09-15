package com.codechallenge.java21.optional;

import java.util.Optional;
import java.util.logging.Logger;

public class OptionalInJava8 {
    private static final Logger logger = Logger.getLogger(OptionalInJava8.class.getName());

    private OptionalInJava8() {}

    public static void logEmptyOptional() {
        Optional<String> empty = Optional.empty();
        logger.info(() -> "The Result is: " + empty);
    }

    public static void logNonEmptyOptional() {
        String[] str = new String[10];
        str[5] = "Hallo";

        Optional<String> value = Optional.of(str[5]);
        logger.info(() -> STR."The Result is: \{value.get()}");
    }

    public static void useOfNullable() {
        var str = new String[10];

        var nullValue = Optional.ofNullable(str[4]);
        nullValue.ifPresent(System.out::println);
        System.out.println(nullValue.orElse("No Value"));
    }

    public static void mapAndFlatMapExample() {
        Optional<String> nonEmptyString = Optional.of("Hallo Optional");
        Optional<String> emptyString = Optional.empty();

        System.out.println(STR."Non-Empty Optional: \{nonEmptyString.map(String::toUpperCase)}");
        System.out.println(STR."Empty Optional: \{emptyString.map(String::toUpperCase)}");

        Optional<Optional<String>> nonEmptyOptionalInput = Optional.of(Optional.of("Hallo Optional"));
        System.out.println(STR."Optional value: \{nonEmptyOptionalInput}");
        System.out.println(STR."Optional.map: \{nonEmptyOptionalInput.map(input -> input.map(String::toUpperCase))}");
        System.out.println(STR."Optional.flatMap: \{nonEmptyOptionalInput.flatMap(input -> input.map(String::toUpperCase))}");
    }

    public static void filterExample() {
        Optional<String> country = Optional.of("Germany");
        Optional<String> emptyCountry = Optional.empty();

        System.out.println(country.filter(g -> g.equals("india"))); // Optional.empty
        System.out.println(country.filter(g -> g.equalsIgnoreCase("INDIA"))); // Optional.empty
        System.out.println(emptyCountry.filter(g -> g.equalsIgnoreCase("INDIA"))); // Optional.empty
    }

    public static void ifPresentExample() {
        Optional<String> country = Optional.of("Germany");

        if (country.isPresent()) {
            System.out.println("Value available");
        }

        country.ifPresent(c -> System.out.println(STR."In Country Option, value available is: \{c}"));
    }

    public static void orElseExample() {
        Optional<String> country = Optional.of("Germany");
        Optional<String> emptyCountry = Optional.empty();

        System.out.println(country.orElse("No Country data available"));
        System.out.println(emptyCountry.orElse("No Country data available"));
        System.out.println(emptyCountry.orElseGet(() -> "No Country data available"));
    }

    public static void ifPresentOrElseExample() {
        Optional<String> country = Optional.of("Germany");

        country.ifPresentOrElse(
                _ -> System.out.println("germany"),
                () -> System.out.println("Value is absent")
        );
    }
}
