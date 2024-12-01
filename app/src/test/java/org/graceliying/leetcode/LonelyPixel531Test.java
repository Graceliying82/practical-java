package org.graceliying.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LonelyPixel531Test {

    @ParameterizedTest
    @MethodSource("lonelyPixelProvider")
    public void testLonelyPixel(char[][] input, int expected) {
        int actual = LonelyPixel531.findLonelyPixel(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> lonelyPixelProvider() {
        return Stream.of(
            Arguments.of(new char[][]{
                {'W', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'},
            }, 3),
            Arguments.of(new char[][]{
                {'B', 'B', 'B'},
                {'B', 'B', 'W'},
                {'B', 'B', 'B'},
            }, 0),
            Arguments.of(new char[][]{
                {'B', 'W', 'W', 'W', 'W', 'B', 'W', 'B', 'B', 'W'},
                {'B', 'B', 'B', 'W', 'W', 'W', 'B', 'W', 'B', 'W'},
                {'B', 'B', 'B', 'B', 'W', 'W', 'W', 'B', 'W', 'W'},
                {'B', 'W', 'W', 'B', 'W', 'B', 'B', 'W', 'W', 'W'},
                {'W', 'W', 'B', 'W', 'B', 'B', 'B', 'W', 'B', 'B'},
                {'W', 'B', 'B', 'W', 'W', 'W', 'B', 'W', 'W', 'W'},
                {'B', 'W', 'W', 'B', 'B', 'B', 'W', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'B', 'B', 'B', 'B', 'W', 'W', 'W'},
                {'W', 'W', 'B', 'B', 'W', 'W', 'W', 'W', 'B', 'W'},
                {'W', 'W', 'W', 'B', 'B', 'B', 'W', 'W', 'W', 'B'}
            }, 0),
            Arguments.of(new char[][]{
                {'W', 'B', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'},
            }, 1)
        );
    }
}
