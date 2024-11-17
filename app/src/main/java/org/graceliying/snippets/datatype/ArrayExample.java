package org.graceliying.snippets.datatype;

/**
 * This class provides examples of working with arrays in Java, including
 * initialization, modification, and passing arrays as parameters.
 */
public class ArrayExample {

    /**
     * Demonstrates how to initialize arrays in Java.
     * <p>
     * This method creates three arrays:
     * <ul>
     *     <li>{@code arr1} is initialized with the values {1, 2, 3, 4}.</li>
     *     <li>{@code arr2} is initialized using the {@code new} keyword with values {5, 6, 7, 8}.</li>
     *     <li>{@code arr3} is an empty array of size 4, where the first two elements are manually assigned values.</li>
     * </ul>
     * It then uses assertions to verify the correctness of the values in the arrays:
     * <ul>
     *     <li>Assert that {@code arr1[0]} is 1.</li>
     *     <li>Assert that {@code arr2[1]} is 6.</li>
     *     <li>Assert that {@code arr3[2]} is 0, as the uninitialized elements are defaulted to 0.</li>
     * </ul>
     *
     * @throws AssertionError if any of the assertions fail
     */
    // 1. Array Initialization
    public void initializeArray() {
        final int[] arr1 = {1, 2, 3, 4};
        final int[] arr2 = new int[]{5, 6, 7, 8};
        final int[] arr3 = new int[4];
        arr3[0] = 10;
        arr3[1] = 20;

        assert arr1[0] == 1 : "arr1[0] should be 1";
        assert arr2[1] == 6 : "arr2[1] should be 6";
        assert arr3[2] == 0 : "arr3[2] should be 0";
    }

    /**
     * Increases each element of the input array by 1 and returns a new array with the updated values.
     * <p>
     * This method takes an array of integers, iterates through each element, increments each element by 1,
     * and returns a new array containing the updated values. The original array remains unchanged.
     *
     * @param array the input array to be modified
     * @return a new array with each element incremented by 1
     */
    // 2. Passing an Array as a parameter
    public int[] increaseArray(final int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i] + 1;
        }
        return newArray;
    }
}
