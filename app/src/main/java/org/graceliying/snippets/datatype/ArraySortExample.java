package org.graceliying.snippets.datatype;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class provides examples of sorting arrays in Java, including
 * sorting primitive arrays, object arrays, and multidimensional arrays.
 */
public class ArraySortExample {

    /**
     * Demonstrates how to sort a primitive array of integers.
     * <p>
     * This method creates an integer array {@code numbers} with the values {5, 3, 8, 1, 2}.
     * It sorts the array in ascending order using {@code Arrays.sort} and verifies
     * the correctness using assertions.
     *
     * @throws AssertionError if the sorted array does not match the expected result
     */
    public void sortPrimitiveArray() {
        final int[] numbers = {5, 3, 8, 1, 2};
        Arrays.sort(numbers);

        assert Arrays.equals(numbers, new int[]{1, 2, 3, 5, 8}) : "Array should be sorted in ascending order";
    }

    /**
     * Demonstrates how to sort an array of objects in ascending order.
     * <p>
     * This method creates an array of strings {@code words} and sorts it in alphabetical order
     * using {@code Arrays.sort}. It verifies the result with assertions.
     *
     * @throws AssertionError if the sorted array does not match the expected result
     */
    public void sortObjectArray() {
        final String[] words = {"banana", "apple", "cherry", "date"};
        Arrays.sort(words);

        assert Arrays.equals(words, new String[]{"apple", "banana", "cherry", "date"}) : "Array should be sorted alphabetically";
    }

    /**
     * Demonstrates custom sorting of an array of strings in descending order.
     * <p>
     * This method uses a {@code Comparator} to sort the array {@code words} in reverse order.
     *
     * @throws AssertionError if the sorted array does not match the expected result
     */
    public void customSortObjectArray() {
        final String[] words = {"banana", "apple", "cherry", "date"};
        Arrays.sort(words, Comparator.reverseOrder());

        assert Arrays.equals(words, new String[]{"date", "cherry", "banana", "apple"}) : "Array should be sorted in reverse order";
    }

    /**
     * Demonstrates sorting of a 2D integer array based on the first element of each row.
     * <p>
     * This method creates a 2D array {@code intervals} and sorts it using {@code Arrays.sort}
     * with a custom comparator. It ensures the rows are ordered by their first elements.
     *
     * @throws AssertionError if the sorted array does not match the expected result
     */
    public void sort2DArray() {
        final int[][] intervals = {{5, 10}, {0, 30}, {15, 20}};
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        final int[][] expected = {{0, 30}, {5, 10}, {15, 20}};
        assert Arrays.deepEquals(intervals, expected) : "2D array should be sorted by the first element of each row";
    }
}
