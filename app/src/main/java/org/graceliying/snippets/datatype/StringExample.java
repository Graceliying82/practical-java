package org.graceliying.snippets.datatype;

/**
 * This class provides examples of commonly used String methods in Java,
 * demonstrating their functionality with practical examples.
 */
public class StringExample {

    /**
     * Demonstrates basic String operations including character access,
     * substring extraction, and comparison.
     */
    public void stringBasics() {
        final String text = "Hello, World!";

        // charAt() - Accessing a specific character
        char charAt5 = text.charAt(5);
        assert charAt5 == ',' : "Character at index 5 should be ','";

        // indexOf() and lastIndexOf() - Finding character positions
        int firstO = text.indexOf('o');
        int lastO = text.lastIndexOf('o');
        assert firstO == 4 : "First 'o' should be at index 4";
        assert lastO == 8 : "Last 'o' should be at index 8";

        // substring() - Extracting part of the string
        String substring = text.substring(7, 12);
        assert substring.equals("World") : "Substring should be 'World'";
    }

    /**
     * Demonstrates String comparison and equality methods.
     */
    public void stringComparisons() {
        final String str1 = "hello";
        final String str2 = "Hello";

        // equals() - Case-sensitive comparison
        assert !str1.equals(str2) : "Strings are not equal (case-sensitive)";

        // equalsIgnoreCase() - Case-insensitive comparison
        assert str1.equalsIgnoreCase(str2) : "Strings are equal (case-insensitive)";

        // compareTo() - Lexicographical comparison
        assert str1.compareTo(str2) > 0 : "str1 is lexicographically greater than str2";
    }

    /**
     * Demonstrates methods to manipulate and modify strings.
     */
    public void stringManipulations() {
        final String original = "  Java Programming  ";

        // trim() - Removing leading and trailing spaces
        String trimmed = original.trim();
        assert trimmed.equals("Java Programming") : "Trimmed string should be 'Java Programming'";

        // toLowerCase() and toUpperCase() - Changing case
        String lower = original.toLowerCase().trim();
        String upper = original.toUpperCase().trim();
        assert lower.equals("java programming") : "Lowercase string should be 'java programming'";
        assert upper.equals("JAVA PROGRAMMING") : "Uppercase string should be 'JAVA PROGRAMMING'";

        // replace() - Replacing characters or substrings
        String replaced = trimmed.replace("Java", "Kotlin");
        assert replaced.equals("Kotlin Programming") : "Replaced string should be 'Kotlin Programming'";
    }

    /**
     * Demonstrates methods for combining and splitting strings.
     */
    public void stringCombining() {
        final String part1 = "Hello";
        final String part2 = "World";

        // concat() - Combining strings
        String combined = part1.concat(", ").concat(part2).concat("!");
        assert combined.equals("Hello, World!") : "Combined string should be 'Hello, World!'";

        // toCharArray() - Converting to character array
        char[] chars = combined.toCharArray();
        assert chars[0] == 'H' : "First character should be 'H'";

        // getChars() - Extracting characters into an array
        char[] buffer = new char[5];
        combined.getChars(7, 12, buffer, 0);
        assert new String(buffer).equals("World") : "Extracted characters should form 'World'";
    }

    /**
     * Demonstrates methods for checking prefixes, suffixes, and string representation.
     */
    public void stringChecksAndConversions() {
        final String text = "file.txt";

        // startsWith() and endsWith() - Prefix and suffix checks
        assert text.startsWith("file") : "String should start with 'file'";
        assert text.endsWith(".txt") : "String should end with '.txt'";

        // valueOf() - Converting other types to String
        int number = 42;
        String numberString = String.valueOf(number);
        assert numberString.equals("42") : "String representation of number should be '42'";
    }
}
