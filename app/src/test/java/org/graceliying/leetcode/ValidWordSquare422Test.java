package org.graceliying.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidWordSquare422Test {
    private ValidWordSquare422 validWordSquare = new ValidWordSquare422();
    @ParameterizedTest
    @MethodSource("wordsList")
    void validWordSquare(List<String> input, boolean expected) {
        boolean actual = validWordSquare.isValidWordSquare(input);

        assertEquals(expected, actual, "Expected result is" + expected);
    }

    private static Stream<Arguments> wordsList() {
        return Stream.of(
            Arguments.of(List.of("abcd", "bnrt", "crmy", "dtye"), true)
        );
    }
}
