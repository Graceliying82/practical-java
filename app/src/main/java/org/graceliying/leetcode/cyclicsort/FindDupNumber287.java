package org.graceliying.leetcode.cyclicsort;

import java.util.HashSet;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and using only constant extra space.
 */
public class FindDupNumber287 {
    /**
     * Sort first or using HashSet will be the most intuitive method
     * This is a demo of using HashSet.
     * Time Complexity O(n)
     * Space Complexity O(n)
     */
    public int findDuplicateHash(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            if (numSet.contains(num)) {
                return num;
            } else {
                numSet.add(num);
            }
        }
        return nums.length;
    }
    /**
     * This method flip the number using the num as index. if a num is duplicated, the same num will flip the same index twice
     * So once a negative number is needed to be flip, it's a indicator that the index is the dup one.
     *
     * Time Complexity O(n)
     * Space Complexity O(1)
     */
    public int findDuplicateFlip(int[] nums) {
        // Iterate over the elements of the array.
        for (int i = 0; i < nums.length; i++) {
            // Take the absolute value of the current element.
            int absI = Math.abs(nums[i]);

            // If the number at index `absI` is already negative, it means we've visited this number before.
            if (nums[absI] < 0) {
                return absI; // Return the duplicate number.
            }

            // Otherwise, mark this index as visited by making the number at index `absI` negative.
            nums[absI] = -nums[absI];
        }

        // This line should not be reached if the problem guarantees a duplicate.
        // Returning `nums.length` as a fallback to satisfy method's return type.
        return nums.length;
    }

    /**
     * Main method for testing the findDuplicate function.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        FindDupNumber287 solution = new FindDupNumber287();
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number is: " + solution.findDuplicateFlip(nums)); // Expected: 3
        System.out.println("Duplicate number is: " + solution.findDuplicateHash(nums));
    }
}
