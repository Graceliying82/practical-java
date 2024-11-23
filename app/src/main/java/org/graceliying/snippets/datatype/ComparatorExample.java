package org.graceliying.snippets.datatype;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class provides examples of using {@link Comparator} in Java,
 * demonstrating custom sorting for arrays of objects and multidimensional arrays.
 */
public class ComparatorExample {

    /**
     * Demonstrates sorting an array of strings in ascending and descending order.
     * <p>
     * This method creates an array of strings {@code names} and performs:
     * <ul>
     *     <li>Sorting in ascending order using natural order with {@code Comparator.naturalOrder()}.</li>
     *     <li>Sorting in descending order using {@code Comparator.reverseOrder()}.</li>
     * </ul>
     * Assertions are used to verify the correctness of the sorting results.
     *
     * @throws AssertionError if the sorted arrays do not match the expected results
     */
    public void sortStringsWithComparator() {
        final String[] names = {"Grace", "Alice", "Bob", "Eve"};

        // Sort in ascending order
        Arrays.sort(names, Comparator.naturalOrder());
        assert Arrays.equals(names, new String[]{"Alice", "Bob", "Eve", "Grace"}) : "Names should be sorted alphabetically";

        // Sort in descending order
        Arrays.sort(names, Comparator.reverseOrder());
        assert Arrays.equals(names, new String[]{"Grace", "Eve", "Bob", "Alice"}) : "Names should be sorted in reverse alphabetical order";
    }

    /**
     * Demonstrates sorting an array of custom objects by a specific field using a {@link Comparator}.
     * <p>
     * This method defines a {@code Person} class and sorts an array of {@code Person} objects by their age:
     * <ul>
     *     <li>Ascending order of ages.</li>
     *     <li>Descending order of ages using a lambda expression.</li>
     * </ul>
     * Assertions are used to verify the results.
     *
     * @throws AssertionError if the sorted arrays do not match the expected results
     */
    public void sortCustomObjectsWithComparator() {
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

        final Person[] people = {
            new Person("Grace", 30),
            new Person("Alice", 25),
            new Person("Bob", 35),
            new Person("Eve", 20)
        };

        // Sort by age in ascending order
        Arrays.sort(people, Comparator.comparingInt(person -> person.age));
        assert people[0].name.equals("Eve") && people[0].age == 20 : "People should be sorted by age in ascending order";

        // Sort by age in descending order
        Arrays.sort(people, (p1, p2) -> Integer.compare(p2.age, p1.age));
        assert people[0].name.equals("Bob") && people[0].age == 35 : "People should be sorted by age in descending order";
    }

    /**
     * Demonstrates sorting a 2D integer array by the second element in each row.
     * <p>
     * This method uses a {@link Comparator} to compare rows based on the second element
     * of each row in ascending order.
     *
     * @throws AssertionError if the sorted array does not match the expected result
     */
    public void sort2DArrayWithComparator() {
        final int[][] intervals = {{5, 10}, {0, 30}, {15, 20}, {10, 5}};

        // Sort by the second element in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[1]));

        final int[][] expected = {{10, 5}, {5, 10}, {15, 20}, {0, 30}};
        assert Arrays.deepEquals(intervals, expected) : "2D array should be sorted by the second element of each row";
    }

    /**
     * Demonstrates using {@link Comparator#thenComparing} to define multi-level sorting.
     * <p>
     * This method sorts a 2D array first by the first element and then by the second element
     * if the first elements are equal.
     *
     * @throws AssertionError if the sorted array does not match the expected result
     */
    public void sortWithMultipleCriteria() {
        final int[][] intervals = {{5, 10}, {5, 5}, {0, 30}, {15, 20}};

        // Sort by the first element, then by the second element
        Arrays.sort(intervals, Comparator.comparingInt((int[] arr) -> arr[0])
            .thenComparingInt(arr -> arr[1]));

        final int[][] expected = {{0, 30}, {5, 5}, {5, 10}, {15, 20}};
        assert Arrays.deepEquals(intervals, expected) : "2D array should be sorted by multiple criteria";
    }
}
