package org.graceliying.leetcode.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * LeetCode 912: Sort an Array
 *
 * Problem Description:
 * - Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 */
@Slf4j
public class SortAnArray912 {
    public static int[] quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return nums;
        }
        int pivot = nums[high];

        int leftPoint = low;
        int rightPoint = high;

        while (leftPoint < rightPoint) {
            while (nums[leftPoint] <= pivot && leftPoint < rightPoint) {
                leftPoint++;
            }
            while (nums[rightPoint] >= pivot && leftPoint < rightPoint) {
                rightPoint--;
            }
            swap(nums, leftPoint, rightPoint);
        }

        swap(nums, leftPoint, high);
        quickSort(nums, low, leftPoint - 1);
        quickSort(nums, leftPoint + 1, high);
        return nums;
    };

    private  static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int[] sortArray(int[] nums) {

        return quickSort(nums, 0, nums.length-1);
    }

    /**
     * Main method for testing the findDuplicates function.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SortAnArray912 solution = new SortAnArray912();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] sorted = solution.sortArray(nums);
        log.info(Arrays.toString(sorted));
    }
}
