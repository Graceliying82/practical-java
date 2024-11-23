package org.graceliying.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 */
public class MeetingRooms252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        for (int i = 0; i < intervals.length -1; i++) {
            if (intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
