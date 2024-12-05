package org.graceliying.algorithm;

public class LCSDynamicProgramming {
    // DP function to calculate LCS
    public static int lcsDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, add 1 to the result of the previous indices
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, take the maximum of excluding one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right corner of the table contains the LCS length
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ABCAGH";
        String s2 = "AEDFHR";

        System.out.println("Length of LCS (DP): " + lcsDP(s1, s2));
    }
}
