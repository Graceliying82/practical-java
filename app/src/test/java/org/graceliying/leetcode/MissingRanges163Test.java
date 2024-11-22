package org.graceliying.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MissingRanges163Test {
    private MissingRanges163 missingRanges163 = new MissingRanges163();
    @ParameterizedTest
    @MethodSource("rangeProvider")
    public void testMissingRanges(int[] nums, int lower, int upper, List<List<Integer>> expected) {
        List<List<Integer>> actual = missingRanges163.findMissingRanges(nums, lower, upper);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> rangeProvider() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4}, 0, 4, List.of(List.of(0, 0))),
            Arguments.of(new int[]{0, 1, 3, 50, 75}, 0, 99, List.of(
                List.of(2, 2),
                List.of(4, 49),
                List.of(51, 74),
                List.of(76, 99)
            )),
            Arguments.of(new int[]{-1}, -1, -1, Arrays.asList()),
            Arguments.of(new int[]{}, 1, 1, Arrays.asList(List.of(1, 1))),
            Arguments.of(new int[]{-1}, -1, 0, Arrays.asList(List.of(0, 0)))
        );
    }
}
