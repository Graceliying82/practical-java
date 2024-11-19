package org.graceliying.snippets.datatype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Comparison of List Initialization Methods:
 *
 * | Method                       | Mutable | Fixed Size | Notes                                                  |
 * |------------------------------|---------|------------|--------------------------------------------------------|
 * | `new ArrayList<>()`          | ✅ Yes  | ❌ No       | Most flexible, allows adding/removing elements.        |
 * | `List.of()`                  | ❌ No   | ✅ Yes      | Immutable, concise for Java 9 and later.              |
 * | `Arrays.asList()`            | ❌ No   | ✅ Yes      | Fixed-size, but allows modifying elements in place.    |
 * | `Collections.singletonList()`| ❌ No   | ✅ Yes      | Immutable, only one element.                          |
 * | Double-Brace Initialization  | ✅ Yes  | ❌ No       | Concise but not recommended for large-scale use.      |
 * | `Stream.of()`                | ✅ Yes  | ❌ No       | Useful for dynamic initialization.                    |
 *
 * Best Practice:
 * - Use `ArrayList` for **mutable lists** where you may need to add, remove, or modify elements.
 * - Use `List.of()` or `Collections.singletonList()` for creating **immutable lists** in modern Java (Java 9+).
 * - Avoid `Double-Brace Initialization` for production code due to potential memory and serialization overhead.
 */


/**
 * Demonstrates various ways to initialize a List of Strings in Java.
 * Includes comparisons and best practices for different approaches.
 */
public class ListExample {

    public void initializeList() {
        // Method 1: Use ArrayList with new keyword
        List<String> stringList1 = new ArrayList<>();
        stringList1.add("Apple");
        stringList1.add("Banana");

        // Method 2: Use List.of to initialize a list -- Java 9 or later
        List<String> expectedStringList1 = List.of("Apple", "Banana");

        assert stringList1.equals(expectedStringList1);

        // Method 3: use Arrays.asList()
        List<String> stringList2 = Arrays.asList("Cherry", "Orange");
        List<String> expectedStringList2 = List.of("Cherry", "Orange");

        assert stringList2.equals(expectedStringList2);

        // Method 4: use Collections.singletonList();
        List<String> stringList3 = Collections.singletonList( "Orange");

        // Method 5: use Double-Brace Initialization
        List<String> expectedStringList3 = new ArrayList<>() {{
            add("Orange");
        }};
        assert stringList3.equals(expectedStringList3);

        // Method 6: use stream
        List<String> stringList4 = Stream.of("Kiwi", "Watermelon").collect(Collectors.toList());
        List<String> expectedStringList4 = List.of("Kiwi", "Watermelon");
        assert stringList4.equals(expectedStringList4);
    }
}
