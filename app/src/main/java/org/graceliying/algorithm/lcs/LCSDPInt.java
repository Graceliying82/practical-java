package org.graceliying.algorithm.lcs;

/**
 * CodeCraft introduces you to an engaging problem-solving challenge. You are presented with two integer lists named as: initialList and finalList of length m and n respectively.
 *
 * The finalList contains unique integers, while the initialList may contain duplicates. You are allowed to perform the following operation any number of times (possibly zero):
 *
 * Insert any positive integer at any position (including the start and the end of the list) in the initialList.
 * Your task is to determine the minimum number of operations required to transform the initialList into a subsequence of the finalList. It can be proven that it is always possible to transform the initialList into a subsequence of the finalList.
 *
 * Note: A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements, without changing the order of the remaining elements.
 *
 * For example, [2, 7, 4] is a subsequence of [4, 2, 3, 7, 2, 1, 41], while [2, 4, 2] is not.
 *
 * Function Description
 *
 * Complete the function minimumInsertions in the editor below.
 *
 * minimumInsertions has the following parameters:
 *
 * int finalList[n] : the elements in the finalList
 * int initialList[m]: the elements in the initialList
 * Returns
 *
 * int: Minimum operations required to make finalList a subsequence of the elements in the initialList.
 */
public class LCSDPInt {
    public static int minimumInsertions(int[] finalList, int[] initialList) {
        // write your code here

        int m = finalList.length;
        int n = initialList.length;

        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (finalList[i-1] == initialList[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return m - dp[m][n];
    }

    public static void main(String[] args) {
        int[] finalList = new int[]{4, 5, 1, 3};
        int[] initialList = new int[]{9, 4, 2, 3, 4};

        System.out.println("Length of LCS (DP): " + minimumInsertions(finalList, initialList));
    }
}
