package org.graceliying.leetcode.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 442: Find All Duplicates in an Array
 *
 * Problem Description:
 * - You are given an integer array `nums` of length `n` where all elements
 *   appear once or twice. Each integer is in the range [1, n].
 * - Find all elements that appear twice and return them in a list.
 * - Solve this problem without using extra space (excluding the output list)
 *   and in \(O(n)\) time complexity.
 */
public class FindAllDupInAnArray422 {


    /* Approach1:
     * - Use the input array itself to track visited numbers by marking the
     *   corresponding index negative.
     * - Iterate through the array, taking the absolute value of each number.
     *   For each number:
     *   - If the value at its corresponding index is already negative, it
     *     means the number has been visited before, so it's a duplicate.
     *   - Otherwise, mark the corresponding index negative to indicate it
     *     has been visited.
     * - Collect all duplicates in a result list.
     */
    public List<Integer> findDuplicates(int[] nums) {
        // List to store the results (duplicates found in the array).
        List<Integer> results = new ArrayList<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Get the absolute value of the current element (1-based indexing).
            int absIndex = Math.abs(nums[i]);

            // Check if the value at the corresponding index is negative.
            if (nums[absIndex - 1] < 0) {
                // If negative, the current number is a duplicate; add to results.
                results.add(absIndex);
            }

            // Mark the index as visited by negating the value.
            nums[absIndex - 1] = -nums[absIndex - 1];
        }

        // Return the list of duplicates.
        return results;
    }

    /**
     * Main method for testing the findDuplicates function.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        FindAllDupInAnArray422 solution = new FindAllDupInAnArray422();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = solution.findDuplicates(nums);
        System.out.println("Duplicates are: " + duplicates); // Expected: [2, 3]
    }
}
