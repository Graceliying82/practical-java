package org.graceliying.leetcode.cyclicsort;

/**
 * LeetCode Problem #448: Find All Numbers Disappeared in an Array
 *
 * Requirements:
 * - Given an array of integers where 1 ≤ nums[i] ≤ n (n is the size of the array),
 *   some elements appear twice, and others appear once.
 * - Find all the integers between 1 and n that do not appear in the array.
 * - Solve it without using extra space (other than the output list) and with O(n) time complexity.
 */

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class FindDisappearedNumbers448 {
    /**
     * This method use in place sort. We try to swith value to it's correct location index = value-1
     * After sort any location doesn't match its value will be the missing one.
     * Time Complexity O(n)
     * Space Complexity O(1)
     */
    public List<Integer> findDisappearedNumbersInPlaceSort(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>(); // List to store missing numbers

        int index = 0;

        // Reorder the array such that the number at index i equals i + 1 whenever possible
        while (index < nums.length) {
            int value = nums[index];

            // If the value is already in the correct position or a duplicate, move to the next index
            if (value == index + 1 || nums[value - 1] == value) {
                index++;
            } else {
                // Swap nums[index] with nums[value - 1] to place the number in its correct position
                int temp = nums[value - 1];
                nums[value - 1] = value;
                nums[index] = temp;
            }
        }

        // Identify the missing numbers by checking indices
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                missingNumbers.add(j + 1); // Add missing number (index + 1)
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers448 finder = new FindDisappearedNumbers448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // Example input

        log.info("Missing numbers: {}", finder.findDisappearedNumbersInPlaceSort(nums)); // Output: [5, 6]
    }
}
