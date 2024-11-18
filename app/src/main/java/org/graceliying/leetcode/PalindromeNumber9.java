package org.graceliying.leetcode;

/**
 * This class contains two methods for checking if a given integer is a palindrome.
 * A palindrome number is a number that reads the same backward as forward.
 */
public class PalindromeNumber9 {
    // First attempt
    /**
     * Determines if a number is a palindrome by converting the number to a string and
     * comparing the characters from the start and end.
     *
     * @param x the integer to check
     * @return true if the integer is a palindrome, false otherwise
     */
    public boolean isPalindrom1(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            String xString = String.valueOf(x);
            int start = 0;
            int end = xString.length() - 1;
            while (start < end) {
                if (xString.charAt(start) == xString.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    // Improved version
    /**
     * An optimized version that reverses only half of the number and compares it
     * with the remaining part of the number.
     *
     * @param x the integer to check
     * @return true if the integer is a palindrome, false otherwise
     */
    public boolean isPalindrom2(int x) {
        if (x < 0) {
            return false;
        }

        if (x != 0 && x % 10 == 0) {
            return false;
        }

        int reverseHalf = 0;

        while (reverseHalf < x) {
            reverseHalf = reverseHalf * 10 + x % 10;
            x = x / 10;
        }

        return (reverseHalf == x || reverseHalf / 10 == x);
    }
}
