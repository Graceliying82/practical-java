package org.graceliying.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumber9Test {

    @Test
    public void testIsPalindrome1() {
        PalindromeNumber9 palindromeNumber = new PalindromeNumber9();
        assertTrue(palindromeNumber.isPalindrom1(121));
        assertFalse(palindromeNumber.isPalindrom1(-121));
        assertFalse(palindromeNumber.isPalindrom1(10));
    }

    @Test
    public void testIsPalindrome2() {
        PalindromeNumber9 palindromeNumber = new PalindromeNumber9();
        assertTrue(palindromeNumber.isPalindrom2(121));
        assertFalse(palindromeNumber.isPalindrom2(-121));
        assertFalse(palindromeNumber.isPalindrom2(10));
    }

}
