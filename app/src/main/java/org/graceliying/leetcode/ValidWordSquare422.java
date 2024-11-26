package org.graceliying.leetcode;

import java.util.List;

/**
 * Given an array of strings words, return true if it forms a valid word square.
 *
 * A sequence of strings forms a valid word square if the kth row and column read the same string,
 * where 0 &lt;= k &lt; max(numRows, numColumns).
 *
 * Example:
 * Input: words = ["abcd","bnrt","crmy","dtye"]
 * Output: true
 */
public class ValidWordSquare422 {
    public boolean isValidWordSquare(List<String> words) {
        // handle corner cases
        String firstWord = words.get(0);
        if (firstWord.length() != words.size()) {
            return false;
        }
        for (int i = 0; i < firstWord.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String word: words) {
                if (i < word.length()) {
                    stringBuilder.append(word.charAt(i));
                }
            }
            String wordI = words.get(i);
            if (!wordI.equals(stringBuilder.toString())) {
                return false;
            }
        }
        return true;
    }
}
