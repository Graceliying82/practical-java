package org.graceliying.leetcode.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 * Merge Sort is a divide-and-conquer sorting algorithm that splits the array into halves,
 * recursively sorts each half, and then merges the sorted halves back together.
 *
 * Key Features:
 * - Time Complexity: O(n log n) in the best, worst, and average cases.
 * - Space Complexity: O(n) due to the use of temporary arrays.
 * - Stable: Maintains the relative order of equal elements.
 * - Not In-Place: Requires additional memory for merging.
 *
 * How it works:
 * 1. Divide: Recursively split the array into smaller subarrays until each subarray contains a single element.
 * 2. Conquer: Sort each subarray during the merge step.
 * 3. Merge: Combine sorted subarrays into a single sorted array.
 *
 * Best suited for large datasets and scenarios requiring stable sorting.
 */
public class MergeSort {
    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        };
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        };

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0,k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100000);
        }
        System.out.print("Before: \n");
        System.out.print(Arrays.toString(numbers));

        mergeSort(numbers);

        System.out.print("\nAfter:");
        System.out.print(Arrays.toString(numbers));
    }
}
