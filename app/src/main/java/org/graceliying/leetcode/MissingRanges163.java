package org.graceliying.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
 *
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 *
 * Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
 */
public class MissingRanges163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int indexStart = lower;

        List<List<Integer>> missingRanges = new ArrayList<>();
        if (nums.length == 0) {
            missingRanges.add(List.of(lower, upper));
            return missingRanges;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != indexStart) {
                missingRanges.add(List.of(indexStart, nums[i]-1));
                indexStart = nums[i] + 1;
            } else {
                indexStart++;
            }
        }

        if (indexStart <= upper) {
            missingRanges.add(List.of(indexStart, upper));
        }
        return missingRanges;
    }
}
