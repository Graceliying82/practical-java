package org.graceliying.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRooms252Test {
    private MeetingRooms252 meetingRooms = new MeetingRooms252();

    @ParameterizedTest
    @MethodSource("intervalProvider")
    void canAttendMeetings(int[][] inputs, boolean expected) {
        boolean actual = meetingRooms.canAttendMeetings(inputs);
        assertEquals(expected, actual, "Expected can attend is" + expected);
    }

    private static Stream<Arguments> intervalProvider(){
        return Stream.of(
            Arguments.of(new int[][]{{0, 30}, {5, 10}, {15, 20}}, false),
            Arguments.of(new int[][]{{7, 10}, {2, 4}}, true),
            Arguments.of(new int[][]{{5, 8}, {6, 8}}, false));
    }
}
