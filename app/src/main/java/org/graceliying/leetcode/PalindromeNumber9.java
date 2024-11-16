package org.graceliying.leetcode;

public class PalindromeNumber9 {
    // First attempt
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
