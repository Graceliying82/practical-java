package org.graceliying.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TernaryExpressionParser439Test {
    private TernaryExpressionParser439 ternaryExpressionParser = new TernaryExpressionParser439();

    @ParameterizedTest
    @MethodSource("evaluationGenerator")
    public void testEvaluate(String expression, String expected) {
        String actual = ternaryExpressionParser.evaluate(expression);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> evaluationGenerator() {
        return Stream.of(
//            Arguments.of("T?2:3", "2"),
//            Arguments.of("F?1:T?4:5", "4"),
//            Arguments.of("T?T?F:5:3", "F"),
            Arguments.of("F?T:F?T?1:2:F?3:4", "4")

        );
    }

}
