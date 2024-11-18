package org.graceliying.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
  Given an integer array nums, return the largest integer that only occurs once.
  If no integer occurs once, return -1.
 */
class LargestUniqueNumber1133Test {
    private LargestUniqueNumber1133 largestUniqueNumber = new LargestUniqueNumber1133();

    @ParameterizedTest
    @MethodSource("provideDifferentArrays")
    void testTheLargestNumOccursOnce(int[] input, int expected) {
        int actual = largestUniqueNumber.getLargestUniqueNumber(input);
        assertEquals(expected, actual, "Expected results is " + expected);
    }

    private static Stream<Arguments> provideDifferentArrays() {
        return Stream.of(
            // the Largest number existed only once. Return the largest one
            Arguments.of(new int[]{1, 2, 3, 4}, 4),
            // the Largest number existed more than once. Return the second largest one
            Arguments.of(new int[]{1, 2, 3, 4, 4, 4}, 3),
            // the Largest number existed more than once
            Arguments.of(new int[]{1, 2, 3, 3, 4, 4, 4}, 2),
            // the Largest number doesn't exist
            Arguments.of(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 4}, -1),
            // empty array
            Arguments.of(new int[]{}, -1)
        );
    }
}
