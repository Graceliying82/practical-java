package org.graceliying.leetcode.cyclicsort;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber268 {
    // Method to find the missing number


    // This is the most straight forward way of handling this issue. Sort the array first and then walk through the list and find the right answer.
    // Time Complexity O(nlogn)
    // Space Complexity O(1)
    public int findMissingNumberSortArray(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Check for the missing number
        int startNum = 0;
        for (int num : nums) {
            if (num != startNum) {
                return startNum; // Found the missing number
            }
            startNum++;
        }

        // If no number is missing in the range, the missing number is the next one
        return startNum;
    }

    // This is an improved version. It used HashSet to proceess the list first.
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int findMissingNumberHashSet(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }

        return nums.length;
    }

    // Using XOR to find the missing number. Set Missing number to be the length.
    // based on a^b^a = b, every number will appear twice except the missing one.
    // Time Complexity O(n)
    // Space Complexity O(1)
    public int findMissingNumberXOR(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    // Calculate the total of n numbers and minus the real total
    public int missingNumberGauss(int[] nums) {
        int n = nums.length -1;
        int expedtedSum = nums.length*(nums.length + 1)/2;

        int actualSum = 0;
        for (int num: nums) actualSum += num;
        return expedtedSum - actualSum;
    }

    // Test method
    public static void main(String[] args) {
        MissingNumber268 solver = new MissingNumber268();

        // Test case
        int[] nums = {3, 0, 1};
        System.out.println("Missing Number: " + solver.findMissingNumberSortArray(nums)); // Output: 2
        System.out.println("Missing Number: " + solver.findMissingNumberHashSet(nums)); // Output: 2
        System.out.println("Missing Number: " + solver.findMissingNumberXOR(nums));
        System.out.println("Missing Number: " + solver.missingNumberGauss(nums));
    }
}
