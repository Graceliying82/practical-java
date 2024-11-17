package org.graceliying.snippets.datatype;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for {@link ArrayExample}.
 *
 * This class contains tests for methods in the ArrayExample class, specifically
 * for testing the initialization and transformation of arrays (e.g., increasing each element of the array by 1).
 */
class ArrayExampleTest {
    private ArrayExample arrayExample= new ArrayExample();

    /**
     * Tests the initialization of an array in the {@link ArrayExample#initializeArray()} method.
     *
     * This test verifies that the array initialization works as expected. It doesn't assert any specific behavior,
     * but it ensures that the method runs without exceptions.
     */
    @Test
    void testInitializeArray() {
        arrayExample.initializeArray();;
    }

    /**
     * Parameterized test for the {@link ArrayExample#increaseArray(int[])} method.
     *
     * This test takes an input array, calls the {@code increaseArray} method, and compares the result with the expected array.
     * It is run with different sets of inputs, including edge cases such as an empty array and negative numbers.
     *
     * @param input the input array to be passed to {@code increaseArray}.
     * @param expected the expected result array after the increase operation.
     */
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testIncreaseArrayParameterized(int[] input, int[] expected) {

        int[] outputArray = arrayExample.increaseArray(input);

        assertArrayEquals(expected, outputArray, "Expected results is " + expected);
    }

    /**
     * Provides the test cases for the parameterized test {@link #testIncreaseArrayParameterized(int[], int[])}.
     *
     * This method returns a stream of test cases consisting of input arrays and the expected output arrays after the increase operation.
     *
     * @return a stream of arguments, where each argument is a pair of input array and expected output array.
     */
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{2, 3, 4}), // Normal case
            Arguments.of(new int[]{}, new int[]{}),               // Empty Array
            Arguments.of(new int[]{-1, -2, -3}, new int[]{0, -1, -2}), // Negative number
            Arguments.of(new int[]{0}, new int[]{1})                  // Single Element
        );
    }
}
