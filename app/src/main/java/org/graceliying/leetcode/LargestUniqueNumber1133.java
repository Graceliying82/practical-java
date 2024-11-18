package org.graceliying.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
  Given an integer array nums, return the largest integer that only occurs once.
  If no integer occurs once, return -1.
 */
public class LargestUniqueNumber1133 {

    public int getLargestUniqueNumber(int[] nums) {
        int largest = -1;

        // 1. get counts of each number
        Map<Integer, Integer> noDupMap = new HashMap<>();

        for (int num: nums) {
            if (noDupMap.get(num) == null) {
                noDupMap.put(num, 1);
            } else {
                noDupMap.put(num, noDupMap.get(num) + 1);
            }
        }

        // 2. loop through to find the largest number
        for (Map.Entry<Integer, Integer> numInMap: noDupMap.entrySet()) {
            if (numInMap.getValue() == 1) {
                final int currentValue = numInMap.getKey();
                largest = largest < currentValue ? currentValue : largest;
            }
        }
        return largest;
    }
}
