package org.graceliying.snippets.generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxingAndUnboxingTest {
    private BoxingAndUnboxing boxingAndUnboxing = new BoxingAndUnboxing();

    @Test
    void testSumWithNonEmptyList() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        int sum = boxingAndUnboxing.sum(ints);
        assertEquals(15, sum, "Sum should be 15 for input [1, 2, 3, 4, 5]");
    }

    @Test
    void testSumWithEmptyList() {
        List<Integer> ints = Arrays.asList();
        int sum = boxingAndUnboxing.sum(ints);
        assertEquals(0, sum, "Sum should be 15 for input []");
    }

    @Test
    void testSumWithNegativeNumbers() {
        List<Integer> ints = Arrays.asList(-1, -2, -3, -4, -5);
        int sum = boxingAndUnboxing.sum(ints);
        assertEquals(-15, sum, "Sum should be -15 for input [-1, -2, -3, -4, -5]");
    }

    @Test
    void testSumWithNullInput() {
        assertThrows(NullPointerException.class, () -> boxingAndUnboxing.sum(null),
            "Method should throw NullPointerException for null input");
    }

    @Test
    void testJoinWithNonEmptyList() {
        List<Integer> listToJoin = Arrays.asList(1,2,3);
        List<Integer> joinedList = boxingAndUnboxing.join(listToJoin, 4);
        assertEquals(joinedList, Arrays.asList(1,2,3,4), "Joined list should be [1, 2, 3, 4]");
    }

    @Test
    void testJoinWithEmptyList() {
        List<Integer> listToJoin = Arrays.asList();
        List<Integer> joinedList = boxingAndUnboxing.join(listToJoin, 4);
        assertEquals(joinedList, Arrays.asList(4), "Joined list should be [4]");
    }
}
