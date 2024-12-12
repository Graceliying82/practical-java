package org.graceliying.leetcode.cyclicsort;

/**
 * LeetCode Problem: Find Two Sneaky Numbers
 *
 * Requirements:
 * - Given an array of integers where numbers are not necessarily in sorted order,
 *   find two "sneaky" numbers that do not conform to the array's expected arrangement.
 * - Solve it in O(n) time complexity and O(1) space complexity (in-place processing).
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindSneakyNumbers3289 {
    /**
     * This method finds two sneaky numbers by rearranging the array using an in-place cyclic sort.
     * After sorting, the two sneaky numbers are identified at specific positions.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] getSneakyNumbers(int[] nums) {
        int[] sneakyNums = new int[2]; // Array to store the two sneaky numbers
        int index = 0;
        int lastIndex = nums.length - 1;

        // Rearrange the array to position each number at its correct index (value = index)
        while (index < nums.length - 2) {
            int value = nums[index];

            if (value == index) {
                // Case 1: The value matches its index; move to the next position.
                index++;
            } else if (value != nums[value]) {
                // Case 2: The value does not match nums[value], so swap them.
                int temp = nums[value];
                nums[value] = value;
                nums[index] = temp;
            } else {
                // Case 3: The value matches nums[value], move it to the end of the array.
                int temp = nums[lastIndex];
                nums[lastIndex] = value;
                nums[index] = temp;
                lastIndex--;
            }
        }

        // The last two elements in the array are the sneaky numbers
        sneakyNums[0] = nums[index];
        sneakyNums[1] = nums[index + 1];

        return sneakyNums;
    }

    public static void main(String[] args) {
        FindSneakyNumbers3289 finder = new FindSneakyNumbers3289();
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2}; // Example input

        int[] sneakyNums = finder.getSneakyNumbers(nums);
        log.info("Sneaky numbers: {}, {}", sneakyNums[0], sneakyNums[1]); // Expected 5, 4
    }
}
