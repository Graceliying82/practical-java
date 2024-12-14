package org.graceliying.leetcode.slidingWindow;

import java.util.HashMap;

public class MaximumSubArraySum2461 {
    /**
     * This method finds the maximum sum of any subarray of length `k` in the given array `nums`.
     *
     * <p>The approach uses a sliding window technique to ensure efficient calculation of the
     * subarray sum. A HashMap is used to track the indices of elements in the current window
     * to handle duplicates.
     *
     * @param nums the input array of integers
     * @param k the length of the subarray
     * @return the maximum sum of any subarray of length `k`
     */
    public long maximumSubArraySum(int[] nums, int k) {
        long result = 0;
        long sumTemp = 0;
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            // Check for duplicates
            int currentIndex = numToIndex.getOrDefault(nums[end], -1);

            // Adjust the start of the window to maintain the constraints
            while (start <= currentIndex || (end - start + 1 > k)) {
                sumTemp -= nums[start];
                start++;
            }

            // Update the HashMap and add the current number to the window sum
            numToIndex.put(nums[end], end);
            sumTemp += nums[end];

            // Update the result if the current window size equals `k`
            if (end - start + 1 == k) {
                result = Math.max(result, sumTemp);
            }

            end++;
        }

        return result;
    }

    /**
     * Main method to test the maximumSubarraySum function.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MaximumSubArraySum2461 solution = new MaximumSubArraySum2461();

        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Maximum subarray sum of length " + k1 + ": " + solution.maximumSubArraySum(nums1, k1)); // Output: 9

        int[] nums2 = {4, 2, 4, 5, 6};
        int k2 = 3;
        System.out.println("Maximum subarray sum of length " + k2 + ": " + solution.maximumSubArraySum(nums2, k2)); // Output: 15

        int[] nums3 = {2, 1, 5, 1, 3, 2};
        int k3 = 3;
        System.out.println("Maximum subarray sum of length " + k3 + ": " + solution.maximumSubArraySum(nums3, k3)); // Output: 9
    }
}
