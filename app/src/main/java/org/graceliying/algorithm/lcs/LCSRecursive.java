package org.graceliying.algorithm.lcs;

public class LCSRecursive {

    // Recursive function to calculate LCS
    public static int lcsRecursive(String s1, String s2, int m, int n) {
        // Base case: If either string is empty, the LCS is 0
        if (m == 0 || n == 0) {
            return 0;
        }

        // If the last characters match, include them in the LCS
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcsRecursive(s1, s2, m - 1, n - 1);
        }

        // If they don't match, find the maximum LCS by excluding one character
        return Math.max(lcsRecursive(s1, s2, m - 1, n), lcsRecursive(s1, s2, m, n - 1));
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        int m = s1.length();
        int n = s2.length();

        System.out.println("Length of LCS (Recursive): " + lcsRecursive(s1, s2, m, n));
    }
}
